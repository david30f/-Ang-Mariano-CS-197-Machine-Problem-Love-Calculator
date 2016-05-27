import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class InputValidatorTest {
  
  InputValidator iv;
  
  public InputValidatorTest() {
  }
  
  @BeforeClass
  public static void setUpClass() {
  }
  
  @AfterClass
  public static void tearDownClass() {
  }
  
  @Before
  public void setUp() {
    iv = new InputValidator();
  }
  
  @After
  public void tearDown() {
  }

  @Test
  public void testTwoValidNames() {
    assertTrue(iv.isValid("alice alice,bob bob"));
  }
  
  @Test
  public void testSameNames() {
    assertFalse(iv.isValid("alex,alex"));
  }
  
  @Test
  public void testFirstNameWithNumber() {
    assertFalse(iv.isValid("alice4,bob"));
  }
  
  @Test
  public void testFirstNameWithSymbol() {
    assertFalse(iv.isValid("al!ce,bob"));
  }
  
  @Test
  public void testFirstNameWithLeadingWhitespace() {
    assertFalse(iv.isValid(" alice,bob"));
  }
  
  @Test
  public void testFirstNameWithTrailingWhitespace() {
    assertFalse(iv.isValid("alice ,bob"));
  }
  
  @Test
  public void testFirstNameAllWhitespace() {
    assertFalse(iv.isValid("  ,bob"));
  }
  
  @Test
  public void testFirstNameBlank() {
    assertFalse(iv.isValid(",bob"));
  }
  
  @Test
  public void testSecondNameWithNumber() {
    assertFalse(iv.isValid("alice,b0b"));
  }
  
  @Test
  public void testSecondNameWithSymbol() {
    assertFalse(iv.isValid("alice,b#b"));
  }
  
  @Test
  public void testSecondNameWithLeadingWhitespace() {
    assertFalse(iv.isValid("alice, bob"));
  }
  
  @Test
  public void testSecondNameWithTrailingWhitespace() {
    assertFalse(iv.isValid("alice,bob "));
  }
  
  @Test
  public void testSecondNameAllWhitespace() {
    assertFalse(iv.isValid("alice,   "));
  }
  
  @Test
  public void testSecondNameBlank() {
    assertFalse(iv.isValid("alice,"));
  }
  
}
