import java.util.*;
/**
 * Write a description of class EnergyComparator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
class EnergyComparator implements Comparator<Character>
{
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int compare(Character c1, Character c2){
        if(c1.getEnergyPoints() == c2.getEnergyPoints())  
            return c1.getName().compareTo(c2.getName());  
        else if(c1.getEnergyPoints() > c2.getEnergyPoints())  
            return 1;  
        else  
            return -1;
    }
}
