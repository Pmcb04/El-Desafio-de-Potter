
import java.util.*;
/**
 * Write a description of class EnergyComparator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
class NameWandComparator implements Comparator<Wand>
{
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int compare(Wand w1, Wand w2){
        if(w1.getName().compareTo(w2.getName()) == 0)  
            return 0;  
        else if(w1.getName().compareTo(w2.getName()) > 0)  
            return 1;  
        else  
            return -1;
    }
}