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
   
    private static Hogwarts hogwarts = Hogwarts.getInstance();
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static void printString(String s, FileWriter fw) throws IOException
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
        
            /// cada casa puede tener un numero de personajes distintos
            /// todos los personajes tienen una varita al inicio
            
         FileWriter fw = new FileWriter("output.log");
         
           /* String s;

         House Gryffindor = new Gryffindor("Gryffindor");
         Wand harryW = new  HollyDefensive("HarryW");
         Character harry = new OffensiveCharacter("Harry Potter", 20, 20, 30, harryW);  
         Wand ronW = new OffensiveHawthron("RonW");
         Character ron = new DefensiveCharacter("Ron Weasley", 20, 26, 20, ronW);
         Wand nevilleW = new OffensiveHawthron("NevilleW");
         Character neville = new OffensiveCharacter("Neville Long",20, 20, 28, nevilleW);
         Wand hermioneW = new  HollyDefensive("HermioneW");
         Character hermione = new DefensiveCharacter("Hermiones Granger" , 20,20,28, hermioneW);
         
         Gryffindor.setCharacter(harry);
         Gryffindor.setCharacter(ron);
         Gryffindor.setCharacter(neville);
         Gryffindor.setCharacter(hermione);
         
         Gryffindor.orderCharacters();
 
         Gryffindor.printCharacterList(fw);
          
          
          
          Hogwarts hg = Hogwarts.getInstance();*/
          
          initData id = new initData();
          printString("new Wands", fw);
          hogwarts.printWands(fw);
        
          printString("houses", fw);
          hogwarts.printCharacters(fw);
          
            fw.close();
     
      
    }
}
