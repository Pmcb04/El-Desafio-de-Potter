import java.util.*;
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
    private ArrayList<Character> currentCharacter;
    //Collection of Characters, they are in the dungeon
    private ArrayList<Character> dungeon;

    /**
     * Constructor for objects of class Hogwarts
     */
    private Hogwarts(){
        houseCollection = new HashMap<String, House>();
        currentCharacter = new ArrayList<Character>();
        dungeon = new ArrayList<Character>();
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
    public void insertCharacter(){
        Iterator<String> it = houseCollection.keySet().iterator();
        House h;
        while(it.hasNext()){
            String key = it.next();
            String nameHouse = houseCollection.get(key).getName();
            if (nameHouse != null){
             h = houseCollection.get(key);
             currentCharacter.add(h.getCharacter());
            }
        }
    }
    
    /**
     * Sorts the characters by his energy in ascending order
     *
     */
    public void orderCurrentCharacters(){
        Collections.sort(currentCharacter, new EnergyComparator());  
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     */
    public void attackCharacter(){
       Iterator<Character> it1 = currentCharacter.iterator();
       while(it1.hasNext()){
           Character c1 = it1.next();
           Iterator<Character> it2 = currentCharacter.iterator();
           while(it2.hasNext()){
               Character c2 = it2.next();
               if(!(c1.getName().equals(c2.getName())) && c1.getEnergyPoints() > 0 && c2.getEnergyPoints() > 0){
                 c1.fight(c2);
               }
           }
        }
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     */
    public void sendCharacter(){
        Iterator<Character> it = currentCharacter.iterator();
        int index;
        while(it.hasNext()){
            Character c = it.next();
            if(c.getEnergyPoints() == 0f){
                sendToDungeon(c);
               }else{
                 sendToHouse(c);  
              }
         }
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     */
    public void sendToDungeon(Character c){
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     */
    public void sendToHouse(Character c){
        
    }
}

