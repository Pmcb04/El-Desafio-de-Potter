 import java.io.*;
import java.util.*;
/**
 * Write a description of class initData here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class initData
{
    private Hogwarts hogwarts = Hogwarts.getInstance();
    
    public initData() throws IOException{
        initData();
    }
    
    
    /***
     * 
     */
    private void initData() throws IOException{
        
       FileReader fr = new FileReader("input.log");  
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
  
       while(cont >= 0){
           
          sc.nextLine();
          num = sc.nextInt();
          sc.nextLine();
          House h;
          
          
            switch(numHouses - cont){
            
                case 1:
                    h = new Gryffindor(sc.nextLine());
                break;
                
                case 2:
                     h = new Slytherin(sc.nextLine());
                break;
                
                case 3:
                     h = new Hufflepuff(sc.nextLine());
                break;
            
                default:
                    h  = new Gryffindor("ERROR");
                break;
            }
          
       
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
                
                while(j < vS.length && !vS[j].equalsIgnoreCase("endPotion")){

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
