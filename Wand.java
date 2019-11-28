import java.io.*;
/**
 * Class Character
 *
 * @author Pedro Miguel Carmona Broncano & Rubén Marín Lucas & Adrián Ruiz Parra
 * @version 26/11/2019
 */
public interface Wand
{
    public float offensiveUse(float characterOffensivePoints, float characterEnergyPoints);
    public float defensiveUse(float characterdefensivePoints, float characterEnergyPoints);
    public String getName();
    public String getType();
}
