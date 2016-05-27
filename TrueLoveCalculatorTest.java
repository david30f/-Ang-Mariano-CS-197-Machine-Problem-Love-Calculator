import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TrueLoveCalculatorTest {
  
  TrueLoveCalculator tlc;
  
  
  public TrueLoveCalculatorTest() {
  }
  
  @BeforeClass
  public static void setUpClass() {
  }
  
  @AfterClass
  public static void tearDownClass() {
  }
  
  @Before
  public void setUp() {
    tlc = new TrueLoveCalculator();
  }
  
  @After
  public void tearDown() {
  }

  /**
   * Test of compute method, of class TrueLoveCalculator.
   */
  @Test
  public void testDigitsInBoth() {
    assertEquals(tlc.compute("tomthompson", "shellysmith"), "46%");
  }
  
  public void testDigitsInTrueOnly() {
    assertEquals(tlc.compute("tttt", "rrrr"), "80%");
  }
  /**
   * Test of compute method, of class TrueLoveCalculator.
   */
  @Test
  public void testDigitsInLoveOnly() {
    assertEquals(tlc.compute("lll", "vvv"), "06%");
  }
  
}
