public class Manager extends Employee
{
   private double bonus;

   /**
    * Constructs a manager object.
    */
   public Manager()
   {
      this.bonus = 0;
   }

   /**
    * Constructs a manager object.
    * @param name the manager's name
    * @param baseSalary the manager's base salary
    * @param bonus the manager's bonus salary
    */
   public Manager(String name, double baseSalary, double bonus)
   {
      super(name, baseSalary);
      this.bonus = bonus;
   }

   /**
    * Sets a manager's bonus salary.
    * @param bonus a manager's bonus salary
    */
   public void setBonusSalary(double bonus)
   {
      this.bonus = bonus;
   }

   /**
    * Gets a manager's salary, including bonus pay.
    * @return a manager's salary
    */
   public double getSalary()
   {
      return super.getSalary() + this.bonus;
   }
}
