

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
        hufflepu1.setCharacter(offensiv3);
        gryffind1.setCharacter(offensiv2);
        hogwarts.insertHouse("gryf", gryffind1);
        hogwarts.insertHouse("huf", hufflepu1);
        hogwarts.insertHouse("slh", slytheri1);
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
    public void testCheckDifferentDefensiveOffensivePoints()
    {
        hufflepu1.setCharacter(offensiv3);
        gryffind1.setCharacter(offensiv2);
        hogwarts.insertHouse("gryf", gryffind1);
        hogwarts.insertHouse("huf", hufflepu1);
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
        DefensiveCharacter defensiv1 = new DefensiveCharacter("testChar", hollyDef1);
        gryffind1.setCharacter(defensiv1);
        hogwarts.insertHouse("g", gryffind1);
        hogwarts.insertHouse("h", hufflepu1);
        assertNotEquals(gryffind1, hogwarts.minDefensiveOffensivePoints());
    }

    @Test
    public void testCheckWinnerHouse()
    {
        gryffind1.setCharacter(offensiv2);
        hogwarts.insertHouse("s", slytheri1);
        hogwarts.insertHouse("h", hufflepu1);
        hogwarts.insertHouse("g", gryffind1);
        assertEquals(gryffind1,hogwarts.winnerHouse());
    }
    
    
    @Test
    public void testInsertHouse()
    {
        Gryffindor gryffind2 = new Gryffindor("prueba");
        assertEquals(3, hogwarts.numHouses());
        hogwarts.insertHouse("prueba", gryffind2);
        assertEquals(4, hogwarts.numHouses());
    }
  
    @Test
    public void testMaxNumberCharacters()
    {
        DefensiveCharacter defensiv1 = new DefensiveCharacter("g", hollyDef1);
        gryffind1.setCharacter(defensiv1);
        gryffind1.setCharacter(offensiv2);
        hogwarts.insertHouse("maxg", gryffind1);
        assertSame(gryffind1, hogwarts.maxNumberCharacters());
    }

    @Test
    public void testGetWinnerHouse()
    {
        assertNotNull(hogwarts.getWinnerHouse());
        assertNotSame(gryffind1, hogwarts.getWinnerHouse());
    }

    @Test
    public void testCheckDifferentNumberCharacters()
    {
        assertTrue( hogwarts.checkDifferentNumberCharacters());
    }
}








