import static org.junit.Assert.*;
import org.junit.Test;

public class ToStringTest
{
   @Test public void invokingToStringOnEmployeeClassHierarchy()
   {
      Employee employee = new Employee("Popeye", 22_300);
      Manager manager = new Manager(
            "Jack Sparrow",
            23_500,
            "Caribbean");
      Executive executive = new Executive(
            "Batman",
            340_000,
            "Gotham");
      Employee[] employees = {employee, manager, executive};

      String expectedEmployee = "Employee[name=Popeye,salary=22300.0]";
      assertEquals(expectedEmployee, employees[0].toString());
      String expectedManager = "Manager[name=Jack Sparrow,salary=23500.0][department=Caribbean]";
      assertEquals(expectedManager, employees[1].toString());
      String expectedExecutive = "Executive[name=Batman,salary=340000.0][department=Gotham]";
      assertEquals(expectedExecutive, employees[2].toString());
   }
}
