import java.util.HashSet;
import java.util.Set;

public class Student
{
   private String firstName;
   private String lastName;
   private int ID;

   public Student(String fName, String lName, int id)
   {
      firstName = fName;
      lastName = lName;
      ID = id;
   }

   public String getFirstName()
   {
      return firstName;
   }

   public String getLastName()
   {
      return lastName;
   }

   public int getId()
   {
      return ID;
   }

   public boolean equals(Object other)
   {
      if (other == null || other.getClass() != (this.getClass()))
      {
         return false;
      }
      Student student = (Student) other;

      return firstName.equals(student.firstName)
            && lastName.equals(student.lastName)
            && ID == student.ID;
   }

   public int hashCode()
   {
      int fnHash = firstName.hashCode();
      int lnHash = lastName.hashCode();
      int idHash = ((Integer) ID).hashCode();

      final int HASH_MULTIPLIER = 31;
      int hashCode = 0;
      Set<Integer> hashCodes = new HashSet<>(Set.of(fnHash, lnHash, idHash));
      for (int varHashCode : hashCodes)
      {
         hashCode = HASH_MULTIPLIER * hashCode + varHashCode;
      }

      return hashCode;
   }

   public String toString()
   {
      return getClass().getName()
            + "[firstName=" + firstName
            + ",lastName=" + lastName
            + ",ID=" + ID + "]";
   }
}
