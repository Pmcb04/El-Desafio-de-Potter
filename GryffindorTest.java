

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class GryffindorTest
 *
 * @author Pedro Miguel Carmona Broncano & Rubén Marín Lucas & Adrián Ruiz Parra
 * @version 12/11/2019
 */
public class GryffindorTest
{
    private HollyDefensive hollyDef1;
    private HollyDefensive hollyDef2;
    private OffensiveHawthron offensiv1;
    private DefensiveCharacter defensiv1;
    private OffensiveCharacter offensiv2;
    private Gryffindor gryffind1;

    /**
     * Default constructor for test class GryffindorTest
     */
    public GryffindorTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        hollyDef1 = new HollyDefensive("varita1");
        hollyDef2 = new HollyDefensive("varHolly");
        offensiv1 = new OffensiveHawthron("varHawt");
        defensiv1 = new DefensiveCharacter("character1", hollyDef2);
        offensiv2 = new OffensiveCharacter("character2", offensiv1);
        gryffind1 = new Gryffindor("Gryffindor");
        gryffind1.setCharacter(offensiv2);
        gryffind1.setCharacter(defensiv1);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testOrderCharacters()
    {
        gryffind1.orderCharacters();
        assertEquals(offensiv2, gryffind1.getCharacter());
    }

    @Test
    public void testGetName()
    {
        assertEquals("Gryffindor", gryffind1.getName());
    }

    @Test
    public void testSetName()
    {
        gryffind1.setName("testGryffindor");
        assertEquals("testGryffindor", gryffind1.getName());
    }

    @Test
    public void testHowManycharacters()
    {
        assertEquals(2, gryffind1.howManyCharacters());
    }

    @Test
    public void testSetCharacter()
    {
        DefensiveCharacter defensiv2 = new DefensiveCharacter("testCharacter", hollyDef2);
        gryffind1.setCharacter(defensiv2);
        assertEquals(3, gryffind1.howManyCharacters());
    }

    @Test
    public void testGetCharacter()
    {
        assertEquals(offensiv2, gryffind1.getCharacter());
    }

    @Test
    public void testGetTotalEnergyPoints()
    {
        assertEquals(40, gryffind1.getTotalEnergyPoints());
    }

    @Test
    public void testGetTotalDefensiveOffensivePoints()
    {
        assertEquals(90, gryffind1.getTotalDefensiveOffensivePoints());
    }
}

