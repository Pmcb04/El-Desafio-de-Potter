import java.util.*;
/**
 * Class EnergyComparator
 * Sorts by energyPoints in an ascending order. If energyPoints are equal, it sorts by name
 * 
 * @author Pedro Miguel Carmona Broncano & Rubén Marín Lucas & Adrián Ruiz Parra
 * @version 12/11/2019
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
