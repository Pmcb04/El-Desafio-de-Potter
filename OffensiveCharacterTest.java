
import java.io.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class OffensiveCharacterTest.
 *
 * @author Pedro Miguel Carmona Broncano & Rubén Marín Lucas & Adrián Ruiz Parra
 * @version 26/11/2019
 */
public class OffensiveCharacterTest
{
    private HollyDefensive hollyDef1;

    /**
     * Default constructor for test class OffensiveCharacterTest
     */
    public OffensiveCharacterTest()
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
        hollyDef1 = new HollyDefensive("defensiveWand");
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
    public void testDefaultConstructor()
    {
        OffensiveCharacter offensiv2 = new OffensiveCharacter("testName", hollyDef1);
        assertEquals("testName", offensiv2.getName());
        assertEquals(20, offensiv2.getEnergyPoints(), 0.1);
        assertEquals(25, offensiv2.getOffensivePoints(), 0.1);
        assertEquals(20, offensiv2.getDefensivePoints(), 0.1);
        assertEquals("defensiveWand", offensiv2.getWandName());
        assertEquals("HollyDefensive", offensiv2.getWandType());
    }

    @Test
    public void testCustomCharacter()
    {
        OffensiveCharacter offensiv1 = new OffensiveCharacter("testName", 10, 10, 10, hollyDef1);
        assertEquals("testName", offensiv1.getName());
        assertEquals(15, offensiv1.getOffensivePoints(), 0.1);
        assertEquals(10, offensiv1.getDefensivePoints(), 0.1);
        assertEquals(10, offensiv1.getEnergyPoints(), 0.1);
        assertEquals("defensiveWand", offensiv1.getWandName());
        assertEquals("HollyDefensive", offensiv1.getWandType());
    }

    @Test
    public void testChangeWand()
    {
        OffensiveHawthron offensiv1 = new OffensiveHawthron("newWand");
        OffensiveCharacter offensiv2 = new OffensiveCharacter("testName", hollyDef1);
        assertEquals("defensiveWand", offensiv2.getWandName());
        assertEquals("HollyDefensive", offensiv2.getWandType());
        offensiv2.changeWand(offensiv1);
        assertEquals("newWand", offensiv2.getWandName());
        assertEquals("OffensiveHawthron", offensiv2.getWandType());
    }

    @Test
    public void testSetMethods()
    {
        OffensiveCharacter offensiv1 = new OffensiveCharacter("test", hollyDef1);
        offensiv1.setDefensivePoints(25);
        offensiv1.setEnergyPoints(30);
        offensiv1.setOffensivePoints(35);
        assertEquals(25, offensiv1.getDefensivePoints(), 0.1);
        assertEquals(30, offensiv1.getEnergyPoints(), 0.1);
        assertEquals(35, offensiv1.getOffensivePoints(), 0.1);
    }

    @Test
    public void testGetAttackPoints()
    {
        OffensiveCharacter offensiv1 = new OffensiveCharacter("testName", hollyDef1);
        assertEquals(21.5, offensiv1.getAttackPoints(), 0.1);
        offensiv1.setOffensivePoints(30);
        assertEquals(23, offensiv1.getAttackPoints(), 0.1);
    }

    @Test
    public void getResistancePoints()
    {
        OffensiveCharacter offensiv1 = new OffensiveCharacter("testName", hollyDef1);
        assertEquals(40, offensiv1.getResistancePoints(), 0.1);
        offensiv1.setDefensivePoints(10);
        assertEquals(29, offensiv1.getResistancePoints(), 0.1);
    }
}







