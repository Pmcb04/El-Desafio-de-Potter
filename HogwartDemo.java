    import java.io.*;
    import java.util.*;
    /**
    * Write a description of class HogwartDemo here.
    *
    * @author (your name)
    * @version (a version number or a date)
    */
    public class HogwartDemo
    {
    private final static int totalTurns = 10;
    private static Hogwarts hogwarts = Hogwarts.getInstance();
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    private static void printString(String s, FileWriter fw) throws IOException
    {
       s += ":";

       System.out.println(s);
       fw.write(s + "\n");
       
        for(int i = 0; i < s.length(); i++){
             System.out.print("-");
             fw.write("-");
        }
     
        System.out.println();
        fw.write("\n");
    }
    
    public static void main (String[] arg) throws IOException{
        
          FileWriter fw = new FileWriter("output.log");
          initData id = new initData();
    
          int turns = 0; 
          boolean endSimulation = false;
          printString("houses", fw);
          hogwarts.printAllCharacters(fw);
          
          printString("new wands", fw);
          hogwarts.printWands(fw);
          
          while(!endSimulation && turns < 10){
             String turnS = String.format("turn:<%d>%n", turns);
             System.out.printf(turnS);
             fw.write(turnS);
             
             printString("characters who are going to duel", fw);
             hogwarts.insertCharacters();
             hogwarts.printCurrentCharacters(fw);
             
                    
             System.out.println();
             fw.write("\n");
             printString("duels", fw);  
             hogwarts.attackCharacters(fw);
            
                    
             System.out.println();
             fw.write("\n");
             printString("duel results", fw);
             hogwarts.sendCharacters(fw);
             hogwarts.checkHouses();
             
             endSimulation = hogwarts.endSimulation();
             turns++;
          }
          
          printString("end of the simulation", fw);
          printString("houses", fw);
          hogwarts.printAllCharacters(fw);
          
          printString("new wands", fw);
          hogwarts.printWands(fw);
          
          printString("dungeon characters", fw);
          hogwarts.printDungeon(fw);
          
          printString("the winner house is", fw);
          House winnerHouse = hogwarts.getWinnerHouse();
          System.out.printf("house:<%s>%n", winnerHouse.getName());
          winnerHouse.printCharacterList(fw);
          
          
          fw.close();
     
      
    }
}
