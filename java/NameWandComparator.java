import java.util.*;

/**
 * Class NameWandComparator
 * Sorts by name of Wand in an ascending order.
 * 
 * @author Pedro Miguel Carmona Broncano & Rubén Marín Lucas & Adrián Ruiz Parra
 * @version 12/11/2019
 */
class NameWandComparator implements Comparator<Wand>
{
    public int compare(Wand w1, Wand w2){
        if(w1.getName().equals(w2.getName()))  
            return 0;  
        else
            return w1.getName().compareTo(w2.getName());  
    }
}