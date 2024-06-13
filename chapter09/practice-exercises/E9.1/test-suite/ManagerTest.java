import static org.junit.Assert.*;
import org.junit.Test;

public class ManagerTest
{
   private static final double EPSILON = 1E-14;

   @Test public void constructingAManagerObject()
   {
      Manager manager = new Manager("Robert", 60_000, 10_000);
   }

   @Test public void gettingAManagerSalary()
   {
      Manager manager = new Manager("Jimmy", 70_000, 5_000);
      manager.setBaseSalary(90_000);
      manager.setBonusSalary(10_000);
      double expected = 100_000;
      assertEquals(expected, manager.getSalary(), EPSILON);
   }
}