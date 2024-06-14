/**
 * A manager is an employee that tells other employees what to do.
 */
public class Manager extends Employee
{
   private String department;

   /**
    * Constructs a manager
    * @param name a manager's name
    * @param salary a manager's salary
    * @param department a manager's department name
    */
   public Manager(String name, double salary, String department)
   {
      super(name, salary);
      this.department = department;
   }

   public String toString()
   {
      return super.toString()+"[department="+this.department+"]";
   }
}
