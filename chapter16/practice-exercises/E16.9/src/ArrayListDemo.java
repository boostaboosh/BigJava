/**
   This program demonstrates the array list implementation.
*/
public class ArrayListDemo
{
   public static void main(String[] args)
   {
      ArrayList staff = new ArrayList();
      staff.addLast("Diana");
      staff.addLast("Harry");

      System.out.println("printing with enhanced for loop");
      for (Object staffMember : staff)
      {
         System.out.println((String) staffMember);
      }
      System.out.println("done printing with enhanced for loop");

      for (int i = 1; i <= 10; i++)
      {
         staff.addLast("Tom" + i);      
      }
      staff.add(0, "Juliet");
      staff.remove(1);
      for (int i = 0; i < staff.size(); i++)
      {
         System.out.println(staff.get(i));
      }
   }
}

