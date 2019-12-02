

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class HollyDefensiveTest.
  *
 * @author  Pedro Miguel Carmona Broncano & Rubén Marín Lucas & Adrián Ruiz Parra
 * @version 26/11/2019
 */
public class HollyDefensiveTest
{
     private HollyDefensive defensiv1;
    /**
     * Default constructor for test class HollyDefensiveTest
     */
    public HollyDefensiveTest()
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
        defensiv1 = new HollyDefensive("testName");
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
        assertEquals("testName", defensiv1.getName());
        assertEquals("HollyDefensive", defensiv1.getType());
    }

    @Test
    public void testOffensiveUse()
    {
        assertEquals(10, defensiv1.offensiveUse(10, 10), 0.1);
    }

    @Test
    public void testDefensiveUse()
    {
        assertEquals(20, defensiv1.defensiveUse(10, 10), 0.1);
    }
}
