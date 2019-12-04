 import java.io.*;
 import java.util.*;
/**
 * Class initData
 *
 * @author Pedro Miguel Carmona Broncano & Rubén Marín Lucas & Adrián Ruiz Parra
 * @version 12/11/2019
 */
public class initData
{
    private Hogwarts hogwarts = Hogwarts.getInstance();
    
    public initData() throws IOException{
        initData();
    }
    
    
    /***
     * Reads the input file
     */
    private void initData() throws IOException{
        
       FileReader fr = new FileReader("files/input.log");  
       Scanner sc = new Scanner(fr);
       String [] vS;
       int num, numHouses, cont, j;
       Wand w = new HollyDefensive("ERROR");
       Character c = new DefensiveCharacter("ERROR", w);
       
       
       num = sc.nextInt(); 
       sc.nextLine(); 
       
       for(int i = 0; i < num; i++){
           vS = sc.nextLine().split(","); 
           if(vS[1].equalsIgnoreCase("HollyDefensive")){
               w = new HollyDefensive(vS[0]);
           }else if (vS[1].equalsIgnoreCase("OffensiveHawthron")){
               w = new OffensiveHawthron(vS[0]);
           }
           hogwarts.insertWand(w);  
       }
       
       sc.nextLine();
       numHouses = sc.nextInt();
       cont = numHouses - 1;
       String s;
  
       while(cont >= 0){
           
          sc.nextLine();
          num = sc.nextInt();
          sc.nextLine();
          House h;
          s = sc.nextLine();
          
            if(s.equalsIgnoreCase("Gryffindor")) h = new Gryffindor();
            else if(s.equalsIgnoreCase("Hufflepuff")) h = new Hufflepuff();
            else if(s.equalsIgnoreCase("Slytherin")) h = new Slytherin();
            else h = new Gryffindor();
  
       
            for(int i = 0; i < num; i++){
                vS = sc.nextLine().split(",");
                if(vS[1].equalsIgnoreCase("HollyDefensive")){
                    w = new HollyDefensive(vS[0]);
                }else if (vS[1].equalsIgnoreCase("OffensiveHawthron")){
                    w = new OffensiveHawthron(vS[0]);
                }
           
                if(vS[2].equalsIgnoreCase("Defensive")){
                    c = new DefensiveCharacter(vS[3], w);
                }else if (vS[2].equalsIgnoreCase("Offensive")){
                    c = new OffensiveCharacter(vS[3], w);
                }
                
                j = 4;
                
                while(j < vS.length){

                    if(vS[j].equalsIgnoreCase("invigorationPotion")){
                        c = new InvigorationPotion(c);
                    }else if (vS[j].equalsIgnoreCase("felixFelicisPotion")){
                        c = new FelixFelicisPotion(c);
                    }
                    j++;
                }
   
                h.setCharacter(c);
          
            }
        
          h.orderCharacters();
          hogwarts.insertHouse(h.getName(),h);
        
          cont--;
       }
       
      
    }
}
