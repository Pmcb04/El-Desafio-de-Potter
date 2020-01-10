

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class HogwartsTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class HogwartsTest
{
    private Hogwarts hogwarts;
    private HollyDefensive hollyDef1;
    private OffensiveHawthron offensiv1;
    private OffensiveCharacter offensiv2;
    private OffensiveCharacter offensiv3;
    private Gryffindor gryffind1;
    private Hufflepuff hufflepu1;
    private Slytherin slytheri1;

    
    /**
     * Default constructor for test class HogwartsTest
     */
    public HogwartsTest()
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
        hogwarts = hogwarts.getInstance();
        hollyDef1 = new HollyDefensive("testDef1");
        offensiv1 = new OffensiveHawthron("testOff2");
        offensiv2 = new OffensiveCharacter("Char1", offensiv1);
        offensiv3 = new OffensiveCharacter("Char2", offensiv1);
        gryffind1 = new Gryffindor("Gryffindor");
        hufflepu1 = new Hufflepuff("Hufflepuff");
        slytheri1 = new Slytherin("Slytherin");
        hogwarts.insertHouse(gryffind1);
        hogwarts.insertHouse(hufflepu1);
        hogwarts.insertHouse(slytheri1);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
        hogwarts.deleteAllHouses();
    }

    @Test
    public void testCheckDifferentDefensiveOffensivePoints()
    {
        hufflepu1.setCharacter(offensiv3);
        gryffind1.setCharacter(offensiv2);
        assertFalse(hogwarts.checkDifferentDefensiveOffensivePoints());
        DefensiveCharacter defensiv1 = new DefensiveCharacter("testDef1", hollyDef1);
        gryffind1.setCharacter(defensiv1);
        assertTrue(hogwarts.checkDifferentDefensiveOffensivePoints());
    }

    @Test
    public void testMinDefensiveOffensivePoints()
    {
        hufflepu1.setCharacter(offensiv3);
        gryffind1.setCharacter(offensiv2);
        slytheri1.setCharacter(offensiv2);
        DefensiveCharacter defensiv1 = new DefensiveCharacter("testChar", hollyDef1);
        gryffind1.setCharacter(defensiv1);
        slytheri1.setCharacter(defensiv1);
        assertEquals(hufflepu1, hogwarts.minDefensiveOffensivePoints());
    }

    @Test
    public void testCheckWinnerHouse()
    {
        gryffind1.setCharacter(offensiv2);
        assertEquals(gryffind1,hogwarts.winnerHouse());
    }
    
    
    @Test
    public void testInsertHouse()
    {
        Gryffindor gryffind2 = new Gryffindor("prueba");
        assertEquals(3, hogwarts.numHouses());
        hogwarts.insertHouse(gryffind2);
        assertEquals(4, hogwarts.numHouses());
    }
  
    @Test
    public void testMaxNumberCharacters()
    {
        DefensiveCharacter defensiv1 = new DefensiveCharacter("g", hollyDef1);
        gryffind1.setCharacter(defensiv1);
        gryffind1.setCharacter(offensiv2);
        hogwarts.insertHouse(gryffind1);
        assertSame(gryffind1, hogwarts.maxNumberCharacters());
    }

 
    @Test
    public void testCheckDifferentNumberCharacters()
    {  
        DefensiveCharacter defensiv1 = new DefensiveCharacter("g", hollyDef1);
        gryffind1.setCharacter(defensiv1);
        hufflepu1.setCharacter(offensiv3); 
        gryffind1.setCharacter(offensiv2);
        assertTrue(hogwarts.checkDifferentNumberCharacters());
        hufflepu1.setCharacter(offensiv2);
        assertFalse(hogwarts.checkDifferentNumberCharacters());
    }

    @Test
    public void testGetWinnerHouse()
    {
        gryffind1.setCharacter(offensiv3);
        assertEquals(gryffind1, hogwarts.getWinnerHouse());
        hufflepu1.setCharacter(offensiv3);
        hufflepu1.setCharacter(offensiv2);
        assertEquals(hufflepu1, hogwarts.getWinnerHouse());
        OffensiveCharacter offensiv4 = new OffensiveCharacter("testVida", 40, 20, 20, offensiv1);
        gryffind1.setCharacter(offensiv4);
        assertEquals(gryffind1, hogwarts.getWinnerHouse());
        slytheri1.setCharacter(offensiv3);
        OffensiveCharacter offensiv5 = new OffensiveCharacter("testLow", 40, 10, 10, offensiv1);
        slytheri1.setCharacter(offensiv5);
        assertEquals(slytheri1, hogwarts.getWinnerHouse());
    }

    @Test
    public void testCheckDifferentEnergyPoints()
    {
        gryffind1.setCharacter(offensiv2);
        hufflepu1.setCharacter(offensiv2);
        slytheri1.setCharacter(offensiv2);
        assertFalse(hogwarts.checkDifferentEnergyPoints());
        gryffind1.setCharacter(offensiv3);
        hufflepu1.setCharacter(offensiv3); 
        DefensiveCharacter defensiv1 = new DefensiveCharacter("testChar", hollyDef1);
        gryffind1.setCharacter(defensiv1);
        assertTrue(hogwarts.checkDifferentEnergyPoints());
    }

    @Test
    public void testEndSimulation()
    {
        assertTrue(hogwarts.endSimulation());
        gryffind1.setCharacter(offensiv2);
        assertTrue(hogwarts.endSimulation());
        hufflepu1.setCharacter(offensiv3);
        assertFalse(hogwarts.endSimulation());
    }

    @Test
    public void checkMaxEnergyPoints()
    {
        gryffind1.setCharacter(offensiv2);
        assertEquals(gryffind1, hogwarts.maxEnergyPoints());
        hufflepu1.setCharacter(offensiv3);
        hufflepu1.setCharacter(offensiv2);
        assertEquals(hufflepu1, hogwarts.maxEnergyPoints());
    }
}












