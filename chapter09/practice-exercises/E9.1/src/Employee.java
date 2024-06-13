public class Employee
{
   private String name;
   private double baseSalary;

   /**
    * Constructs an employee object.
    */
   public Employee()
   {
      this.name = "";
      this.baseSalary = 0;
   }

   /**
    * Constructs an employee object.
    * @param name the employees name
    * @param baseSalary the employee's base salary
    */
   public Employee(String name, double baseSalary)
   {
      this.name = name;
      this.baseSalary = baseSalary;
   }

   /**
    * Sets an employee's name.
    * @param newName the employee's new name
    */
   public void setName(String newName)
   {
      this.name = newName;
   }

   /**
    * Sets an employee's base salary.
    * @param newSalary the employee's base salary
    */
   public void setBaseSalary(double newSalary)
   {
      this.baseSalary = newSalary;
   }

   /**
    * Gets an employee's name.
    * @return the employees name
    */
   public String getName()
   {
      return this.name;
   }

   /**
    * Gets an employee's  salary.
    * @return the employee's salary
    */
   public double getSalary()
   {
      return this.baseSalary;
   }
}
