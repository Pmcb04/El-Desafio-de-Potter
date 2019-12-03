import java.util.*; 
import java.io.*;

/**
 * This class stores information about houses, characters and duels with its results.
 * 
 * The control of all duels is managed by this class. It takes care of fights of different characters
 * and it decides if the characters are sent to their houses or they are sent to the dungeon, depending
 * on their energy points. Besides, when a student is being sent to his house they are provided with a new wand 
 * if the collection of wands isn't empty.
 * 
 * Singleton Pattern
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
    //Collection of Characters that are fighting 
    private ArrayList<Character> currentCharacters;
    //Collection of Characters that are in the dungeon
    private ArrayList<Character> dungeon;
    //Collection of new Wands that are going to be given to some characters
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
     * Returns an (unique) instance of class Hogwarts
     *
     * @return Instance of class Hogwarts
     */
    public synchronized static Hogwarts getInstance(){
        if(instance == null){
            instance = new Hogwarts();
        }
        return instance;
    }

    /**
     * Inserts the first character of each house in currentCharacters. These characters will be ordered 
     * by their energy points
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
          if(h.howManyCharacters() > 0){
              currentCharacters.add(h.getCharacter());
          }
        }
        orderCurrentCharacters();
       }
    }
    
    /**
     * Inserts a wand in newWandCollection.
     *
     * @param w The wand to insert
     */
    public void insertWand(Wand w){
        newWandCollection.add(w);
    }

    /**
     * Inserts a house in houseCollection.
     *
     * @param nameHouse The name of the house
     * @param h The house to insert
     */
    public void insertHouse(String nameHouse, House h){
        houseCollection.put(nameHouse, h);
    }

    /**
     * Orders the characters by their energy points 
     *
     */
    public void orderCurrentCharacters(){
        Collections.sort(currentCharacters, new EnergyComparator());  
    }
    
    
    /**
     * All characters will fight each other if their energy points is not 0 
     * The characters that starts the fights will be chosen in ascendent order by their energy points
     * The information from different fights will be printed
     *
     *@param fw The FileWriter where the fight will be printed
     */
    public void attackCharacters(FileWriter fw) throws IOException{
       String s1;
       for(Character c1 : currentCharacters){
           for(Character c2 : currentCharacters){
               if(!(c1.getName().equals(c2.getName()))){
                 printAttackCharacters(c1,c2,fw);
                 if(c1.getEnergyPoints()>0 && c2.getEnergyPoints()>0){
                     c1.fight(c2, fw);
                 }
               }
           }
        }
       fw.write("\n");
    }
    
    
    /**
     * Prints the information of the duel between two characters in a file writer
     *
     *@param fw FileWriter where the info will be printed
     *@param c1 The character that fights against the other character 
     *@param c2 The opponent character
     */
    public void printAttackCharacters(Character c1, Character c2,FileWriter fw) throws IOException{
          String s1;
          s1 = String.format("<%s> is dueling against <%s>%n", 
                                   c1.getName(), c2.getName());
          fw.write(s1);
          System.out.printf(s1);
    }
    
    
    
    /**
     * If a character has no energy points left he will be sent to the dungeon. Else the character 
     * will get a new wand if there are wands in newWandCollection.
     * Prints the results of all duels
     *
     *@param fw FileWriter where the info will be printed
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
    
    
    
    /***
     * Print method to print the results of all duels
     * 
     * @param fw FileWriter where the info will be printed
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
    
    
    /**
     * Check if all houses have characters. If a house has characters, we check the first character of the house in checkCharacters.
     *
     */
    public void checkHouses(){
        Iterator<String> it = houseCollection.keySet().iterator();
        while(it.hasNext()){
           String key = it.next();
           String nameHouse = houseCollection.get(key).getName();
           if (nameHouse != null){
             House h = houseCollection.get(key);
             if(h.howManyCharacters() > 0){
                h.checkCharacters();
             }
           }
        }
    }
    
    /**
     * The character will change his wand to a new one if the newWandCollection is not empty. Prints the information too.
     * 
     * @param fw FileWriter where the info will be printed
     * @param c The character that may get a new wand
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
     * Print method to print the wand that has been assigned to character
     * 
     * @param fw FileWriter where the info will be printed
     * @param w The wand that will be assigned
     */
    public void printGiveWand(Wand w, FileWriter fw) throws IOException{
        String s;
        s = String.format("new wand assigned: <%s (class %s)>%n", w.getName(), w.getType());
        fw.write(s);
    } 
    
    /**
     * Returns true if just one house has characters left.
     * 
     * @return True if just one house has characters left.
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
     * Checks if all houses have different number of characters, in this case returns true, in other case returns false
     * 
     * @return True if all houses have different number of characters
     */
    public boolean checkDifferentNumberCharacters(){
        Iterator<String> it1 = houseCollection.keySet().iterator(); 
        House h1; House h2; boolean found = true;
        while(it1.hasNext()){
         String key1 = it1.next();
         String nameHouse1 = houseCollection.get(key1).getName();
         if (nameHouse1 != null){
            h1 = houseCollection.get(key1);
           if(h1.howManyCharacters() < 0){
             Iterator<String> it2 = houseCollection.keySet().iterator(); 
             while(it2.hasNext() && found){
                 String key2 = it2.next();
                 String nameHouse2 = houseCollection.get(key2).getName();
                 if (nameHouse2 != null){
                    h2 = houseCollection.get(key2);
                    if(!(h1.getName().equals(h2.getName())) && (h1.howManyCharacters() == h2.howManyCharacters())){
                           found = false;
                    } 
                }
             }
           } 
         }
       }
       return found;
    }
    
    /**
     * Checks if all houses have different total energy points, in this case returns true, in other case returns False
     * 
     * @return True if total energy points of each house is different
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
                 found = false;
                } 
             }
           }
        }
       }
       return found;
    }
    
    
     /**
     * Checks if all houses have different total sum of  defensive and offensive points, in this case return true, 
     * in other case return False
     * 
     * @return True if total sum of the defensive points and offensive points of each house is different
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
                      found = false;
                } 
             }
         }
        }
       }
       return found;
    }
    
    /**
     * Returns the house with the biggest number of characters
     * 
     * @return House with the biggest number of characters
     */
    public House maxNumberCharacters(){
      Iterator<String> it = houseCollection.keySet().iterator(); 
      House h1; House h2; String key, nameHouse;
      
      key = it.next(); 
      h1 = houseCollection.get(key);
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
     * Returns the house with the biggest total energy points
     * 
     * @return House with the biggest total energy points
     */
    public House maxEnergyPoints(){
      Iterator<String> it = houseCollection.keySet().iterator(); 
      House h1; House h2; String key, nameHouse;
      key = it.next(); 
      h1 = houseCollection.get(key);
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
     * Returns the house with the smallest sum of defensive and offensive points
     * 
     * @return House with the smallest sum of defensive and offensive points
     */
    public House minDefensiveOffensivePoints(){
      Iterator<String> it = houseCollection.keySet().iterator(); 
      House h1, h2; String key, nameHouse; 
      key = it.next(); 
      h1 = houseCollection.get(key);
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
     * If there is just one house that has characters, returns it
     * 
     * @return The winner house
     */
    public House winnerHouse(){
        Iterator<String> it = houseCollection.keySet().iterator(); 
        House h; boolean found = false; String nameHouse, key;
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
     * Print method to print all wands of the newWandCollection
     *
     * @param fw FileWriter where the info will be written
     */
    public void printWands(FileWriter fw) throws IOException{
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
     * Gets the winner house depending of all cases
     * @return The winner house
     */
    public House getWinnerHouse(){
        if(endSimulation()){
            return winnerHouse();  
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
     * Print method to print all characters of their respective houses
     *
     * @param fw FileWriter where the info will be written
     */
    public void printAllCharacters(FileWriter fw) throws IOException{
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
     * Print method to print all characters that will be fighting
     *
     * @param fw FileWriter where the info will be written
     */
    public void printCurrentCharacters(FileWriter fw) throws IOException{
        for(Character c : currentCharacters){
            c.printCharacter(fw);
            fw.write("\n");
        }
        System.out.println();
        fw.write("\n");
    }
    
    
    /**
     * Print method to prints all characters that are in the dungeon
     *
     * @param fw FileWriter where the info will be written
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
    
     
}

