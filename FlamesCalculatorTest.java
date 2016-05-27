import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FlamesCalculatorTest {
  
  FlamesCalculator fc;
  
  public FlamesCalculatorTest() {
  }
  
  @BeforeClass
  public static void setUpClass() {
  }
  
  @AfterClass
  public static void tearDownClass() {
  }
  
  @Before
  public void setUp() {
    fc = new FlamesCalculator();
  }
  
  @After
  public void tearDown() {
  }

  /**
   * Test of compute method, of class FlamesCalculator.
   */
  @Test
  public void testSomeCommonLetters() {
    //System.out.println("asd");
    //System.out.println("abcd");
    System.out.println(fc.compute("asd", "abcd"));
    assertTrue(fc.compute("asd", "abcd").charAt(0) == 'F');
  }
  
  @Test
  public void testNoCommonLetters() {
    //System.out.println("wanda");
    //System.out.println("vision");
    System.out.println(fc.compute("wanda", "vision"));
    assertTrue(fc.compute("wanda", "vision").charAt(0) == 'E');
  }
  
}
