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
             if(h.howCharacters() > 0)
                currentCharacters.add(h.getCharacter());
            }
        }
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void insertWand(Wand w)
    {
        newWandCollection.add(w);
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
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
       Iterator<Character> it1 = currentCharacters.iterator();
       while(it1.hasNext()){
           Character c1 = it1.next();
           Iterator<Character> it2 = currentCharacters.iterator();
           while(it2.hasNext()){
               Character c2 = it2.next();
               if(c1.getEnergyPoints() > 0 && c2.getEnergyPoints() > 0 && !(c1.getName().equals(c2.getName()))){
                 c1.fight(c2, fw);
               }
           }
        }
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     */
    public void sendCharacters(FileWriter fw) throws IOException{
        Iterator<Character> it = currentCharacters.iterator();
        Character c;
        while(it.hasNext()){
            c = it.next();
            if(c.getEnergyPoints() <= 0f){
               dungeon.add(c);
            }
            else{
               giveWand(c);
            }
            printResultDuels(c, fw);
            it.remove();
         }
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     */
    public void checkHouses(){
        Iterator<String> it = houseCollection.keySet().iterator();
        House h;
        while(it.hasNext()){
            String key = it.next();
            String nameHouse = houseCollection.get(key).getName();
            if (nameHouse != null){
             h = houseCollection.get(key);
             if(h.howCharacters() > 0)
                h.checkCharacters();
            }
        }
    }
    
    /**
     * An example of a method - replace this comment with your own
     * Si nuestro conjunto no esta vacio le cambia la varita
     */
    public void giveWand(Character c){
        if(!newWandCollection.isEmpty()){
            Wand newWand = newWandCollection.first();
            c.changeWand(newWand);
            newWandCollection.remove(newWand);
        }
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
             if(h.howCharacters() > 0){
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
        }
        
        System.out.println();
        fw.write("\n");
    }

    /***
     * 
     */
    public void printResultDuels(Character c, FileWriter fw) throws IOException{
        
        if(c.getEnergyPoints() < 0){
          c.setEnergyPoints(0f);
          c.printCharacter(fw);
          System.out.println("goes to dungeon");
          fw.write("goes to dungeon");
        }else{
          c.printCharacter(fw);
          System.out.println("returns to the house");
          fw.write("returns to the house"); 
        }    
        
        System.out.println();
        fw.write("\n");
    }
     
}

