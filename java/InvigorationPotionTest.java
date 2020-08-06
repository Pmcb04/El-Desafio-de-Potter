

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class InvigorationPotionTest.
 *
 * @author  Pedro Miguel Carmona Broncano & Rubén Marín Lucas & Adrián Ruiz Parra
 * @version 26/11/2019
 */
public class InvigorationPotionTest
{
    private OffensiveHawthron offensiv1;
    private OffensiveCharacter offensiv2;
    private InvigorationPotion invigora1;

    
    

    /**
     * Default constructor for test class InvigorationPotionTest
     */
    public InvigorationPotionTest()
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
        invigora1 = new InvigorationPotion(offensiv2);
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
        assertEquals(25, invigora1.getOffensivePoints(), 0.1);
    }

    @Test
    public void testGetDefensivePoints()
    {
        assertEquals(28, invigora1.getDefensivePoints(), 0.1);
    }
}



