

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class FelixFelicisPotionTest.
 *
 * @author  Pedro Miguel Carmona Broncano & Rubén Marín Lucas & Adrián Ruiz Parra
 * @version 26/11/2019
 */
public class FelixFelicisPotionTest
{
    private OffensiveHawthron offensiv1;
    private OffensiveCharacter offensiv2;
    private FelixFelicisPotion felixFel1;

    /**
     * Default constructor for test class FelixFelicisPotionTest
     */
    public FelixFelicisPotionTest()
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
        offensiv1 = new OffensiveHawthron("");
        offensiv2 = new OffensiveCharacter("", offensiv1);
        felixFel1 = new FelixFelicisPotion(offensiv2);
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
    public void testGetOffensivePoints()
    {
        assertEquals(32.5, felixFel1.getOffensivePoints(), 0.1);
    }

    @Test
    public void testGetDefensivePoints()
    {
        assertEquals(20, felixFel1.getDefensivePoints(), 0.1);
    }
}


