    import java.io.*;
    import java.util.*;
    /**
    * Class HogwartsDemo
    *
    * @author Pedro Miguel Carmona Broncano & Rubén Marín Lucas & Adrián Ruiz Parra
    * @version 12/11/2019
    */
    public class HogwartDemo
    {
    private final static int totalTurns = 10;
    private static Hogwarts hogwarts = Hogwarts.getInstance();
    

    /***
     * Prints string s
     * @param s String that will be printed
     * @param fw FileWriter
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
          fw.write("\n");
          System.out.println();
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
             fw.write("\n");
             
             printString("duels", fw);  
             hogwarts.attackCharacters(fw);

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
          String s = String.format("house:<%s>", winnerHouse.getName());
          System.out.println(s);
          fw.write(s);
          fw.write("\n");   
          winnerHouse.printCharacterList(fw);
          fw.write("\n");
          System.out.println();
          
          
          fw.close();
     
      
    }
}
