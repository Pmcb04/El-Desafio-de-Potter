

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DefensiveCharacterTest.
 *
 * @author Pedro Miguel Carmona Broncano & Rubén Marín Lucas & Adrián Ruiz Parra
 * @version 26/11/2019
 */
public class DefensiveCharacterTest
{
    private HollyDefensive hollyDef1;
    /**
     * Default constructor for test class DefensiveCharacterTest
     */
    public DefensiveCharacterTest()
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
        DefensiveCharacter defensiv2 = new DefensiveCharacter("testName", hollyDef1);
        assertEquals("testName", defensiv2.getName());
        assertEquals(20, defensiv2.getEnergyPoints(), 0.1);
        assertEquals(20, defensiv2.getOffensivePoints(), 0.1);
        assertEquals(25, defensiv2.getDefensivePoints(), 0.1);
        assertEquals("defensiveWand", defensiv2.getWandName());
        assertEquals("HollyDefensive", defensiv2.getWandType());
    }

    @Test
    public void testCustomCharacter()
    {
        DefensiveCharacter defensiv1 = new DefensiveCharacter("testName", 10, 10, 10, hollyDef1);
        assertEquals("testName", defensiv1.getName());
        assertEquals(10, defensiv1.getOffensivePoints(), 0.1);
        assertEquals(15, defensiv1.getDefensivePoints(), 0.1);
        assertEquals(10, defensiv1.getEnergyPoints(), 0.1);
        assertEquals("defensiveWand", defensiv1.getWandName());
        assertEquals("HollyDefensive", defensiv1.getWandType());
    }

    @Test
    public void testChangeWand()
    {
        OffensiveHawthron defensiv1 = new OffensiveHawthron("newWand");
        DefensiveCharacter defensiv2 = new DefensiveCharacter("testName", hollyDef1);
        assertEquals("defensiveWand", defensiv2.getWandName());
        assertEquals("HollyDefensive", defensiv2.getWandType());
        defensiv2.changeWand(defensiv1);
        assertEquals("newWand", defensiv2.getWandName());
        assertEquals("OffensiveHawthron", defensiv2.getWandType());
    }

    @Test
    public void testSetMethods()
    {
        DefensiveCharacter defensiv1 = new DefensiveCharacter("test", hollyDef1);
        defensiv1.setDefensivePoints(25);
        defensiv1.setEnergyPoints(30);
        defensiv1.setOffensivePoints(35);
        assertEquals(25, defensiv1.getDefensivePoints(), 0.1);
        assertEquals(30, defensiv1.getEnergyPoints(), 0.1);
        assertEquals(35, defensiv1.getOffensivePoints(), 0.1);
    }

    @Test
    public void testGetAttackPoints()
    {
        DefensiveCharacter defensiv1 = new DefensiveCharacter("testName", hollyDef1);
        assertEquals(20, defensiv1.getAttackPoints(), 0.1);
        defensiv1.setOffensivePoints(30);
        assertEquals(23, defensiv1.getAttackPoints(), 0.1);
    }

    @Test
    public void getResistancePoints()
    {
        DefensiveCharacter defensiv1 = new DefensiveCharacter("testName", hollyDef1);
        assertEquals(45.5, defensiv1.getResistancePoints(), 0.1);
        defensiv1.setDefensivePoints(10);
        assertEquals(29, defensiv1.getResistancePoints(), 0.1);
    }
}
