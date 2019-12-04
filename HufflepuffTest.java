

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class HufflepuffTest
 *
 * @author Pedro Miguel Carmona Broncano & Rubén Marín Lucas & Adrián Ruiz Parra
 * @version 12/11/2019
 */
public class HufflepuffTest
{
    private HollyDefensive hollyDef1;
    private HollyDefensive hollyDef2;
    private OffensiveHawthron offensiv1;
    private DefensiveCharacter defensiv1;
    private OffensiveCharacter offensiv2;
    private Hufflepuff hufflepu1;

    /**
     * Default constructor for test class HufflepuffTest
     */
    public HufflepuffTest()
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
        hufflepu1 = new Hufflepuff();
        hufflepu1.setCharacter(offensiv2);
        hufflepu1.setCharacter(defensiv1);
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
        hufflepu1.orderCharacters();
        assertEquals(defensiv1, hufflepu1.getCharacter());
    }

    @Test
    public void testGetName()
    {
        assertEquals("Hufflepuff", hufflepu1.getName());
    }

    @Test
    public void testSetName()
    {
        hufflepu1.setName("testHufflepuff");
        assertEquals("testHufflepuff", hufflepu1.getName());
    }

    @Test
    public void testHowManycharacters()
    {
        assertEquals(2, hufflepu1.howManyCharacters());
    }

    @Test
    public void testSetCharacter()
    {
        DefensiveCharacter defensiv2 = new DefensiveCharacter("testCharacter", hollyDef2);
        hufflepu1.setCharacter(defensiv2);
        assertEquals(3, hufflepu1.howManyCharacters());
    }

    @Test
    public void testGetCharacter()
    {
        assertEquals(offensiv2, hufflepu1.getCharacter());
    }

    @Test
    public void testGetTotalEnergyPoints()
    {
        assertEquals(40, hufflepu1.getTotalEnergyPoints());
    }

    @Test
    public void testGetTotalDefensiveOffensivePoints()
    {
        assertEquals(90, hufflepu1.getTotalDefensiveOffensivePoints());
    }
}

