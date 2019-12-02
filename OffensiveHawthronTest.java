

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class OffensiveHawthronTest.
 *
 * @author  Pedro Miguel Carmona Broncano & Rubén Marín Lucas & Adrián Ruiz Parra
 * @version 26/11/2019
 */
public class OffensiveHawthronTest
{
    private OffensiveHawthron offensiv1;

    /**
     * Default constructor for test class OffensiveHawthronTest
     */
    public OffensiveHawthronTest()
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
        offensiv1 = new OffensiveHawthron("testName");
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
    public void testConstructor()
    {
        assertEquals("testName", offensiv1.getName());
        assertEquals("OffensiveHawthron", offensiv1.getType());
    }

    @Test
    public void testOffensiveUse()
    {
        assertEquals(20, offensiv1.offensiveUse(10, 10), 0.1);
    }

    @Test
    public void testDefensiveUse()
    {
        assertEquals(10, offensiv1.defensiveUse(10, 10), 0.1);
    }
}



