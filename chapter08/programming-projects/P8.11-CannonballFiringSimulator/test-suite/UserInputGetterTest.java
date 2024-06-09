import org.junit.Test;
import org.junit.Assert;
import java.io.ByteArrayInputStream;

public class UserInputGetterTest
{
   private static final double EPSILON = 1E-14;
   
   @Test public void gettingABooleanValueFromTheUser()
   {
      String simulatedInput = "wrong format\n" 
            + "yes\n";
      ByteArrayInputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
      System.setIn(inputStream);
      boolean expected = true;
      UserInputGetter.initializeScanner();
      Assert.assertEquals(expected, UserInputGetter.getBooleanValue());
   }
   
   @Test public void gettingADoubleValueFromTheUser()
   {
      String simulatedInput = "wrong format\n"
            + "yes\n"
            + "8.329843\n";
      ByteArrayInputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
      System.setIn(inputStream);
      double expected = 8.329843;
      UserInputGetter.initializeScanner();
      Assert.assertEquals(expected, UserInputGetter.getDoubleValue(), EPSILON);
   }
   
   @Test public void gettingTwoBooleanValues()
   {
      String simulatedInput = "wrong format\n"
            + "yes\n"
            + "no\n";
      ByteArrayInputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
      System.setIn(inputStream);
      boolean expected = true;
      UserInputGetter.initializeScanner();
      Assert.assertEquals(expected, UserInputGetter.getBooleanValue());
      expected = false;
      Assert.assertEquals(expected, UserInputGetter.getBooleanValue());
   }
}