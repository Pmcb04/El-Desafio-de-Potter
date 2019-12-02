import java.util.*; 
import java.io.*;

/**
 * Write a description of class Howarts here.
 *
 * @author Pedro Miguel Carmona Broncano & Rubén Marín Lucas & Adrián Ruiz Parra
 * @version 26/11/2019
 */
public class Hogwarts
{
    //Instance of Hogwarts
    private static Hogwarts instance;
    //Collection of Houses
    private HashMap<String, House> houseCollection;
    //Collection of Characters, currently they are in the play 
    private ArrayList<Character> currentCharacters;
    //Collection of Characters, they are in the dungeon
    private ArrayList<Character> dungeon;
    //Collection of Wands
    private TreeSet<Wand> newWandCollection;

    /**
     * Constructor for objects of class Hogwarts
     */
    private Hogwarts(){
        houseCollection = new HashMap<String, House>();
        currentCharacters = new ArrayList<Character>();
        dungeon = new ArrayList<Character>();
        newWandCollection = new TreeSet<Wand>(new NameWandComparator());
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @return     instance of our class Hogwarts
     */
    public synchronized static Hogwarts getInstance(){
        if(instance == null){
            instance = new Hogwarts();
        }
        return instance;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     */
    public void insertCharacters(){
        Iterator<String> it = houseCollection.keySet().iterator();
        House h;
        while(it.hasNext()){
            String key = it.next();
            String nameHouse = houseCollection.get(key).getName();
            if (nameHouse != null){
             h = houseCollection.get(key);
             if(h.howManyCharacters() > 0)
                currentCharacters.add(h.getCharacter());
            }
        }
        orderCurrentCharacters();
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     */
    public void insertWand(Wand w)
    {
        newWandCollection.add(w);
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     */
    public void insertHouse(String nameHouse, House h)
    {
        houseCollection.put(nameHouse, h);
    }

    /**
     * Sorts the characters by his energy in ascending order
     *
     */
    public void orderCurrentCharacters(){
        Collections.sort(currentCharacters, new EnergyComparator());  
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     */
    public void attackCharacters(FileWriter fw) throws IOException{
       String s1;
       for(Character c1 : currentCharacters){
           for(Character c2 : currentCharacters){
               if(!(c1.getName().equals(c2.getName()))){
                 printAttackCharacters(c1,c2,fw);
                 if(c1.getEnergyPoints()>0&&c2.getEnergyPoints()>0)  c1.fight(c2, fw);
               }
           }
        }
        fw.write("\n");
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     */
    public void printAttackCharacters(Character c1, Character c2,FileWriter fw) throws IOException{
                 String s1;
                 s1 = String.format("<%s> is dueling against <%s>%n", 
                                   c1.getName(), c2.getName());
                 fw.write(s1);
                 System.out.printf(s1);
               }
    
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     */
    public void sendCharacters(FileWriter fw) throws IOException{
        Iterator<Character> it = currentCharacters.iterator();
        while(it.hasNext()){
            Character c = it.next();
            printResultDuels(c, fw);
            if(c.getEnergyPoints() <= 0f){
               dungeon.add(c);
            }
            else{
               giveWand(c,fw);
            }
            it.remove();
         }
            fw.write("\n");
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     */
    public void checkHouses(){
        Iterator<String> it = houseCollection.keySet().iterator();
        
        while(it.hasNext()){
            String key = it.next();
            String nameHouse = houseCollection.get(key).getName();
            if (nameHouse != null){
             House h = houseCollection.get(key);
             if(h.howManyCharacters() > 0)
                h.checkCharacters();
            }
        }
    }
    
    /**
     * An example of a method - replace this comment with your own
     * Si nuestro conjunto no esta vacio le cambia la varita
     */
    public void giveWand(Character c,  FileWriter fw) throws IOException{
        if(!newWandCollection.isEmpty()){
            Wand newWand = newWandCollection.first();
            c.changeWand(newWand);
            printGiveWand(newWand, fw);
            newWandCollection.remove(newWand);
        }
    } 
    
    
    /**
     * An example of a method - replace this comment with your own
     * Si nuestro conjunto no esta vacio le cambia la varita
     */
    public void printGiveWand(Wand w, FileWriter fw) throws IOException{
        String s;
        s = String.format("new wand assigned: <%s (class %s)>%n", w.getName(), w.getType());
        fw.write(s);
    } 
    
    /**
     * An example of a method - replace this comment with your own
     * Cuando solo existe una casa con personajes
     * @return
     */
    public boolean endSimulation(){
        Iterator<String> it = houseCollection.keySet().iterator(); 
        House h; boolean found = false; int count = 0;
        while(it.hasNext()){
          String key = it.next();
          String nameHouse = houseCollection.get(key).getName();
          if (nameHouse != null){
             h = houseCollection.get(key);
             if(h.howManyCharacters() == 0){
                count++;
             }
          }
        }
        if(count >= houseCollection.size()-1){
           found = true;
        }
        return found;
       }

    /**
     * An example of a method - replace this comment with your own
     * Comprueba que todas las casas tienen distinto numero de personajes, pero no devuelve true si hay dos casas con 0
     * @return
     */
    public boolean checkDifferentNumberCharacters(){
        Iterator<String> it1 = houseCollection.keySet().iterator(); 
        House h1; House h2; boolean found = true;
        while(it1.hasNext()){
         String key1 = it1.next();
         String nameHouse1 = houseCollection.get(key1).getName();
         if (nameHouse1 != null){
            h1 = houseCollection.get(key1);
         
           if(h1.howManyCharacters() < 0){//Para que no me cuente los iguales a 0
             Iterator<String> it2 = houseCollection.keySet().iterator(); 
             while(it2.hasNext() && found){
                 String key2 = it2.next();
                 String nameHouse2 = houseCollection.get(key2).getName();
                 if (nameHouse2 != null){
                    h2 = houseCollection.get(key2);
                    if(!(h1.getName().equals(h2.getName())) && (h1.howManyCharacters() == h2.howManyCharacters())){
                           found = false;//Si alguno es igual no son distintos
                    } 
                }
             }
           } 
         }
       }
       
       return found;
    }
    
    /**
     * An example of a method - replace this comment with your own
     * Comprueba que todas las casas tienen distinto puntos de energia
     * @return
     */
    public boolean checkDifferentEnergyPoints(){
        Iterator<String> it1 = houseCollection.keySet().iterator(); 
        House h1; House h2; boolean found = true;
        while(it1.hasNext()){
         String key1 = it1.next();
         String nameHouse1 = houseCollection.get(key1).getName();
          if (nameHouse1 != null){
            h1 = houseCollection.get(key1);
          
         Iterator<String> it2 = houseCollection.keySet().iterator(); 
         while(it2.hasNext() && found){
             String key2 = it2.next();
             String nameHouse2 = houseCollection.get(key2).getName();
             if (nameHouse2 != null){
                h2 = houseCollection.get(key2);
                if(!(h1.getName().equals(h2.getName())) && (h1.getTotalEnergyPoints() == h2.getTotalEnergyPoints())){
                 found = false;//Si alguno es igual no son distintos
                } 
             }
         }
        }
       }
       return found;
    }
    
    
     /**
     * An example of a method - replace this comment with your own
     * Comprueba que todas las cosas tienen distinto puntos de energia
     * @return
     */
    public boolean checkDifferentDefensiveOffensivePoints(){
        Iterator<String> it1 = houseCollection.keySet().iterator(); 
        House h1; House h2; boolean found = true;
        while(it1.hasNext()){
         String key1 = it1.next();
         String nameHouse1 = houseCollection.get(key1).getName();
         if (nameHouse1 != null){
            h1 = houseCollection.get(key1);
         
         Iterator<String> it2 = houseCollection.keySet().iterator(); 
         while(it2.hasNext() && found){
             String key2 = it2.next();
             String nameHouse2 = houseCollection.get(key2).getName();
             if (nameHouse2 != null){
                h2 = houseCollection.get(key2);
                if(!(h1.getName().equals(h2.getName())) && 
                (h1.getTotalDefensiveOffensivePoints() == h2.getTotalDefensiveOffensivePoints())){
                      found = false;//Si alguno es igual no son distintos
                } 
             }
         }
        }
       }
       return found;
    }
    
    /**
     * An example of a method - replace this comment with your own
     * Devuelve la casa con mayor numero de personajes
     * @return
     */
    public House maxNumberCharacters(){
      Iterator<String> it = houseCollection.keySet().iterator(); 
      House h1; House h2; String key, nameHouse;
      
      key = it.next(); 
      h1 = houseCollection.get(key);//Primer elemento, mayor hasta ahora
      nameHouse = houseCollection.get(key).getName();
      if (nameHouse != null){
     while(it.hasNext()){
       key = it.next();
       nameHouse = houseCollection.get(key).getName();
       if (nameHouse != null){
         h2 = houseCollection.get(key);
         if(h2.howManyCharacters() > h1.howManyCharacters()){
             h1 = h2;
         }
       }
     }  
    }
      return h1;
      
   }
    
    /**
     * An example of a method - replace this comment with your own
     * Devuelve la casa con mayor numero de puntos de energia
     * @return
     */
    public House maxEnergyPoints(){
      Iterator<String> it = houseCollection.keySet().iterator(); 
      House h1; House h2; String key, nameHouse;
        
      key = it.next(); 
      h1 = houseCollection.get(key);//Primer elemento, mayor hasta ahora
      nameHouse = houseCollection.get(key).getName();
      if (nameHouse != null){
        while(it.hasNext()){
         key = it.next();
         nameHouse = houseCollection.get(key).getName();
         if (nameHouse != null){
           h2 = houseCollection.get(key);
           if(h2.getTotalEnergyPoints() > h1.getTotalEnergyPoints()){
                h1 = h2;
           }
         }
      }
     } 
      
       return h1;
    }
    
    /**
     * An example of a method - replace this comment with your own
     * Devuelve la casa con mayor numero de puntos de energia
     * @return
     */
    public House minDefensiveOffensivePoints(){
      Iterator<String> it = houseCollection.keySet().iterator(); 
      House h1; House h2; boolean found = true; String key, nameHouse;
        
      key = it.next(); 
      h1 = houseCollection.get(key);//Primer elemento, menor hasta ahora
      nameHouse = houseCollection.get(key).getName();
      if (nameHouse != null){
        while(it.hasNext()){
         key = it.next();
         nameHouse = houseCollection.get(key).getName();
         if (nameHouse != null){
            h2 = houseCollection.get(key);
            if(h2.getTotalEnergyPoints() < h1.getTotalEnergyPoints()){
                h1 = h2;
            }
         }
       }
      }
       return h1;
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     * Devuelve la casa que tiene personajes
     * @return
     */
    public House winnerHouse(){
        Iterator<String> it = houseCollection.keySet().iterator(); 
        House h; boolean found = false; int count = 0; String nameHouse; String key;
        while(it.hasNext() && !found){
          key = it.next();
          nameHouse = houseCollection.get(key).getName();
          if (nameHouse != null){
             h = houseCollection.get(key);
             if(h.howManyCharacters() > 0){
                found = true;
                return h;
             }
          }
        }
        return null;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void printWands(FileWriter fw) throws IOException
    {
      Iterator<Wand> it = newWandCollection.iterator();
      String s;
      Wand w;
      while(it.hasNext()){
          w = it.next();
          s = String.format("wand: <%s (%s)>%n", w.getName(), w.getType());
          System.out.printf(s);
          fw.write(s);
      }
      
      System.out.println();
      fw.write("\n");
      
    }
    
    

        /**
     * An example of a method - replace this comment with your own
     * Devuelve la casa ganadora
     * @return
     */
    public House getWinnerHouse(){
        if(endSimulation()){
            return this.winnerHouse();  
        }
        else{
            if(checkDifferentNumberCharacters()){
                return maxNumberCharacters();
            }
            else if(checkDifferentEnergyPoints()){
                return maxEnergyPoints();
            }
            else if(checkDifferentNumberCharacters()){
                return minDefensiveOffensivePoints();
            }
        }
        return null;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void printAllCharacters(FileWriter fw) throws IOException
    {
        Iterator<String> it = houseCollection.keySet().iterator();
        House h;
        String s;
        while(it.hasNext()){
            String key = it.next();
            String nameHouse = houseCollection.get(key).getName();
            if (nameHouse != null){
             h = houseCollection.get(key);
             s = String.format("house:<%s>%n", h.getName());
             System.out.printf(s);
             fw.write(s);
             if(h.howManyCharacters() > 0){
                 h.printCharacterList(fw);
             }
             System.out.println();
             fw.write("\n");
           }
        }
      
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void printCurrentCharacters(FileWriter fw) throws IOException
    {
        for(Character c : currentCharacters){
            c.printCharacter(fw);
            fw.write("\n");
        }
        
        System.out.println();
        fw.write("\n");
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void printDungeon(FileWriter fw) throws IOException
    {
        for(Character c : dungeon){
            c.setEnergyPoints(0f);
            c.printCharacter(fw);
            fw.write("\n");
        }
        
        System.out.println();
        fw.write("\n");
    }


    /***
     * 
     */
    public void printResultDuels(Character c, FileWriter fw) throws IOException{
        
        if(c.getEnergyPoints() <= 0){
          c.setEnergyPoints(0f);
          c.printCharacter(fw);
          System.out.println(" goes to dungeon");
          fw.write(" goes to dungeon");
        }else{
          c.printCharacter(fw);
          System.out.println(" returns to the house");
          fw.write(" returns to the house"); 
        }    
        
        System.out.println();
        fw.write("\n");
    }
    
     
}

