import static org.junit.Assert.*;
import org.junit.Test;

public class PolymorphismTest
{
   private static final double EPSILON = 1E-14;

   @Test public void getSalaryFromEmployeeAndManagerObjects()
   {
      Employee employee = new Employee("Anne", 33_000);
      Manager manager = new Manager("Cay", 58_000, 7_400);

      Employee[] employees = {employee, manager};

      double firstExpectedSalary = 33_000;
      assertEquals(firstExpectedSalary, employees[0].getSalary(), EPSILON);
      double secondExpectedSalary = 65_400;
      assertEquals(secondExpectedSalary, employees[1].getSalary(), EPSILON);
   }
}
