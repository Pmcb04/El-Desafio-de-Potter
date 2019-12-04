import java.util.*;

/**
 * Class NameWandComparator
 * Sorts by name of Wand in an ascending order. If defensivePoints are equal, it sorts by name
 * 
 * @author Pedro Miguel Carmona Broncano & Rubén Marín Lucas & Adrián Ruiz Parra
 * @version 12/11/2019
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