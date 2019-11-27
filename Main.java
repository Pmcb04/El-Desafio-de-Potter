 import java.io.*;
import java.util.*;
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main
{
    public static void main (String[] arg) throws IOException{
        
            /// cada casa puede tener un numero de personajes distintos
            /// todos los personajes tienen una varita al inicio
            FileReader fr = new FileReader("input.log");
            FileWriter fw = new FileWriter("output.log");
            Scanner sc = new Scanner(fr);
            
             String s;
             while (sc.hasNextLine()){
                 s = sc.nextLine();
                 System.out.println(s);
                 fw.write(s+"\n");
             }
          
           
        
         House Gryffindor = new Gryffindor("Gryffindor");
         Wand harryW = new  HollyDefensive("HarryW");
         Character harry = new OffensiveCharacter("Harry Potter", 20, 20, 30);    
         harry.changeWand(harryW);
         Wand ronW = new OffensiveHawthron("RonW");
         Character ron = new DefensiveCharacter("Ron Weasley", 20, 26, 20);
         ron.changeWand(ronW);
         Wand nevilleW = new OffensiveHawthron("NevilleW");
         Character neville = new OffensiveCharacter("Neville Long",20, 20, 28 );
         neville.changeWand(nevilleW);
         Wand hermioneW = new  HollyDefensive("HermioneW");
         Character hermione = new DefensiveCharacter("Hermiones Granger" , 20,20,28);
         hermione.changeWand(hermioneW);
         
         Gryffindor.setCharacter(harry);
         Gryffindor.setCharacter(ron);
         Gryffindor.setCharacter(neville);
         Gryffindor.setCharacter(hermione);
         
         Gryffindor.orderCharacters();
 
         Gryffindor.printCharacterList(fw);
          
          fw.close();
     
      
    }
}
