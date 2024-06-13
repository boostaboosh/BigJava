import static org.junit.Assert.*;
import org.junit.Test;

public class EmployeeTest
{
   private static final double EPSILON = 1E-14;

   @Test public void settingAndGettingAnEmployeesSalary()
   {
      Employee employee = new Employee("James", 28_000);
      employee.setBaseSalary(37_000);
      double expected = 37_000;
      assertEquals(expected, employee.getSalary(), EPSILON);
   }
}