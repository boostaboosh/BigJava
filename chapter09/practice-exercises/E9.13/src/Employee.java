/**
 * An employee works for a certain amount of time in exchange for a salary.
 */
public class Employee
{
   private String name;
   private double salary;

   /**
    * Constructs an employee.
    */
   public Employee(String name, double salary)
   {
      this.name = name;
      this.salary = salary;
   }

   public String toString()
   {
      return this.getClass().getName()+"[name="+this.name+",salary="+this.salary+"]";
   }
}
