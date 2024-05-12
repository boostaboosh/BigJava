import org.junit.Assert;
import org.junit.Test;

public class ComboLockTest
{

   @Test
   public void reset()
   {
      ComboLock lock = new ComboLock(1, 2, 3);
      lock.turnLeft(30);
      lock.turnRight(2);
      lock.reset();
      lock.turnRight(39);
      lock.turnLeft(1);
      lock.turnRight(39);
      boolean expected = true;
      Assert.assertEquals(expected, lock.open());
   }

   @Test
   public void turnLeft()
   {
      ComboLock lock = new ComboLock(1, 2, 3);
      lock.turnLeft(30);
      lock.turnLeft(41);
      int expected = 31;
      Assert.assertEquals(expected, lock.getSelectedDialValue());
   }

   @Test
   public void turnRight()
   {
      ComboLock lock = new ComboLock(1, 2, 3);
      lock.turnRight(2);
      lock.turnRight(5);
      lock.turnRight(43);
      int expected = 30;
      Assert.assertEquals(expected, lock.getSelectedDialValue());
   }

   @Test
   public void open()
   {
      ComboLock lock = new ComboLock(1, 2, 3);
      lock.turnRight(39);
      lock.turnLeft(1);
      lock.turnRight(39);
      boolean expected = true;
      Assert.assertEquals(expected, lock.open());
   }

   @Test
   public void failOpenAttempt()
   {
      ComboLock lock = new ComboLock(1, 2, 3);
      lock.turnRight(1);
      lock.turnLeft(1);
      lock.turnRight(39);
      lock.turnLeft(1);
      lock.turnRight(39);
      boolean expected = false;
      Assert.assertEquals(expected, lock.open());
   }
   
   @Test 
   public void failOpenAttemptFromWrongDirection()
   {
      ComboLock lock = new ComboLock(1, 2, 3);
      lock.turnLeft(1);
      lock.turnRight(39);
      lock.turnLeft(1);
      boolean expected = false;
      Assert.assertEquals(expected, lock.open());
   }
}