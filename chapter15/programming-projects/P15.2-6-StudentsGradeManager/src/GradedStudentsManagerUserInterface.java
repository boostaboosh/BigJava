import com.sun.source.tree.Tree;

import java.io.PrintStream;
import java.util.*;

/**
 * A text-based UI for interacting with a students grade manager.
 * Allows the user to add graded students, remove students, modify grades,
 * and print the current graded students list.
 *
 * @author boostaboosh
 * @version 1.0
 */
public class GradedStudentsManagerUserInterface
{
   /**
    * major tasks:
    * get user inputs for students and grade to add to manager,
    * students to remove from the manager
    * ability to change student grades
    * and also prints out all graded students
    */

   public static void main(String[] args)
   {
      GradedStudentsManagerUserInterface ui = new GradedStudentsManagerUserInterface(
              System.out,
              new StudentsGradeManager(
                      new GradedStudent(new Student("John", "Doe"), "A+"),
                      new GradedStudent(new Student("Joe", "Doe"), "A+"),
                      new GradedStudent(new Student("Joe", "Doe"), "A+"),
                      new GradedStudent(new Student("Joe", "Shmoe"), "B-"),
                      new GradedStudent(new Student("Giuseppe", "Cerva"), "B-"),
                      new GradedStudent(new Student("Lionel", "Messi"), "F"),
                      new GradedStudent(new Student("Cristiano", "Ronaldo"), "F")
              ),
              new Scanner(System.in)
      );
      ui.runMenuSequence();
   }

   private final PrintStream printStream;
   private StudentsGradeManager gradeManager;
   private final Scanner inputReader;

   public GradedStudentsManagerUserInterface(
           PrintStream printStream,
           StudentsGradeManager gradeManager,
           Scanner inputReader
   )
   {
      this.printStream = printStream;
      this.gradeManager = gradeManager;
      this.inputReader = inputReader;
   }

   public void runMenuSequence()
   {
      boolean done = false;
      while (!done)
      {
         printMenuOptions();
         MenuChoice userChoice = getChoice();
         switch (userChoice)
         {
            case ADD_STUDENTS:
            {
               runAddGradedStudentsSequence();
               break;
            }
            case REMOVE_STUDENTS:
            {
               runRemoveGradedStudentsSequence();
               break;
            }
            case CHANGE_GRADE:
            {
               runChangeStudentsGradeSequence();
               break;
            }
            case PRINT_STUDENTS:
            {
               printAllGradedStudents();
               break;
            }
            case QUIT:
            {
               done = true;
               break;
            }
            default:
            {
               throw new IllegalStateException("user choice must match a menu choice.");
            }
         }
      }
   }

   private enum MenuChoice {
      ADD_STUDENTS("A"),
      REMOVE_STUDENTS("R"),
      CHANGE_GRADE("C"),
      PRINT_STUDENTS("P"),
      QUIT("Q");

      private final String symbol;
      private MenuChoice(String symbol) { this.symbol = symbol; }
      public String getSymbol() { return this.symbol; }
   }

   /**
    * Prints the grade manager menu options
    */
   public void printMenuOptions()
   {
      printStream.println("options:");
      for (MenuChoice option : MenuChoice.values())
      {
         printStream.println(
                 option.getSymbol() + ") "
                 + option.name().toLowerCase().replace("_", " ")
         );
      }
   }

   private MenuChoice getChoice()
   {
      this.printStream.print("Enter choice: ");
      while (true)
      {
         String choice = inputReader.nextLine().trim().toUpperCase();
         if (choice.equals(MenuChoice.ADD_STUDENTS.symbol)) { return MenuChoice.ADD_STUDENTS; }
         if (choice.equals(MenuChoice.REMOVE_STUDENTS.symbol)) { return MenuChoice.REMOVE_STUDENTS; }
         if (choice.equals(MenuChoice.CHANGE_GRADE.symbol)) { return MenuChoice.CHANGE_GRADE; }
         if (choice.equals(MenuChoice.PRINT_STUDENTS.symbol)) { return MenuChoice.PRINT_STUDENTS; }
         if (choice.equals(MenuChoice.QUIT.symbol)) { return MenuChoice.QUIT; }
         printStream.print("Invalid choice. Enter choice: ");
      }
   }

   /**
    * Runs the sequence which lets users add graded students until they're done.
    */
   private void runAddGradedStudentsSequence()
   {
      boolean done = false;
      while (!done)
      {
         try {
            askForGradedStudentToAdd();
         } catch (InvalidInputException e) {
            this.printStream.println(e.getMessage());
         }

         this.printStream.print("Enter 's' to stop adding students, anything else to continue: ");
         if (this.inputReader.nextLine().trim().equalsIgnoreCase("s"))
         {
            done = true;
         }
      }
   }

   /**
    * Prompts the user for a student and grade to add to the grade manager
    * , and adds the graded student.
    */
   private void askForGradedStudentToAdd() throws InvalidInputException
   {
      String fName = getStudentFirstName();
      String lName = getStudentLastName();
      String grade = getStudentGrade();

      try
      {
         this.gradeManager.addGradedStudent(new GradedStudent(new Student(fName, lName), grade));
      } catch (IllegalArgumentException e)
      {
         throw new InvalidInputException(e.getMessage());
      }
   }

   private String getStudentGrade()
   {
      this.printStream.print("Enter student's grade: ");
       return this.inputReader.nextLine().trim();
   }

   private String getStudentLastName()
   {
      this.printStream.print("Enter student last name: ");
       return this.inputReader.nextLine().trim();
   }

   private String getStudentFirstName()
   {
      this.printStream.print("Enter student first name: ");
      return this.inputReader.nextLine().trim();
   }

   private int getStudentId() throws InvalidInputException {
      return getSingleIntUserInput(
              "Enter ID of student: ",
              "ID cannot be empty",
              "Enter a single integer ID followed by nothing",
              "Input must be an integer."
      );
   }

   /**
    * Runs the sequence which lets users remove graded students until they're done.
    */
   private void runRemoveGradedStudentsSequence()
   {
      boolean done = false;
      while (!done)
      {
         try {
            askForGradedStudentToRemove();
         } catch (NoSuchStudentException | InvalidInputException e) {
            this.printStream.println(e.getMessage());
         }

         this.printStream.print("Enter 's' to stop removing students, anything else to continue: ");
         if (this.inputReader.nextLine().trim().equalsIgnoreCase("s"))
         {
            done = true;
         }
      }
   }

   /**
    * Asks the user for a graded student to remove from the grade manager.
    * @throws InvalidInputException if the user enters an invalid student id
    * @throws NoSuchStudentException if the user tries to remove a student that doesn't exist in the system
    */
   private void askForGradedStudentToRemove() throws InvalidInputException, NoSuchStudentException
   {
      String lastName = getStudentLastName();
      try
      {
         this.gradeManager.removeGradedStudent(this.gradeManager.getStudentByLastName(lastName));
      } catch (DuplicateLastNameException e)
      {
         this.printStream.print("More than 1 student with surname " + lastName + ". ");
         String firstName = getStudentFirstName();
         try
         {
            this.gradeManager.removeGradedStudent(this.gradeManager.getStudentByFirstAndLastName(firstName, lastName));
         } catch (DuplicateFirstAndLastNamesException dupFAndLNameExcep)
         {
            this.printStream.printf("More than 1 student called %s %s\n", firstName, lastName);
            this.gradeManager.removeGradedStudent(this.gradeManager.getStudentById(getStudentId()));
         }
      }
   }

   /**
    * Runs the sequence which lets users changes the grades of pre-existing students.
    */
   private void runChangeStudentsGradeSequence()
   {
      boolean done = false;
      do
      {
         try {
            askForStudentToChangeGradeOf();
         } catch (InvalidInputException | NoSuchStudentException e)
         {
            this.printStream.println(e.getMessage());
         }

          this.printStream.print("Enter 's' to stop editing student grades, anything else to continue: ");
         if (this.inputReader.nextLine().trim().equalsIgnoreCase("s"))
         {
            done = true;
         }
      } while (!done);
   }

   /**
    * Prompts the user for a new grade to assign a pre-existing student.
    * @throws InvalidInputException if the user enters as invalid input
    * @throws NoSuchStudentException if no students exists with the given ID
    */
   private void askForStudentToChangeGradeOf() throws InvalidInputException, NoSuchStudentException
   {
      int id = getStudentId();
      Student student = this.gradeManager.getStudentById(id);
      String newGrade = getStudentGrade();
      this.gradeManager.modifyStudentGrade(student, newGrade);
   }

   /**
    * Gets a single integer input from a user.
    * @param entryPrompt message to prompt user for input with
    * @param blankInputMessage the message for when the user provides a blank input
    * @param multipleInputMessage the message for when the user enters more than 1 message
    * @param nonIntMessage the message if the user enters a non integer
    * @throws InvalidInputException if the user enters an invalid input
    */
   private int getSingleIntUserInput(
           String entryPrompt,
           String blankInputMessage,
           String multipleInputMessage,
           String nonIntMessage)
           throws InvalidInputException
   {
      this.printStream.print(entryPrompt);
      Scanner lineReader = new Scanner(this.inputReader.nextLine().trim());

      if (!lineReader.hasNext()) throw new InvalidInputException(blankInputMessage);
      if (!lineReader.hasNextInt()) throw new InvalidInputException(nonIntMessage);
      int value = lineReader.nextInt();
      if (lineReader.hasNext()) throw new InvalidInputException(multipleInputMessage);
      return value;
   }

   /**
    * Prints out all students and their grade.
    * Sorted by last name.
    * If two students have the same last name, the student with the first name
    * that comes first in lexicographic (dictionary) order comes first.
    * If two students have the same first and last name, the student with the
    * smaller ID comes first.
    */
   public void printAllGradedStudents()
   {
      final int ID_WIDTH = 5;
      final int FIRST_NAME_WIDTH = 20;
      final int LAST_NAME_WIDTH = 20;
      final int GRADE_WIDTH = 5;

      this.printStream.println("ID    " + "last name           " + "first name          " + "  grade");

      Collection<GradedStudent> gradedStudents = this.gradeManager.getAllGradedStudents();
      Map<Student, String> sortedStudents = new TreeMap<>(
              (s1, s2) -> {
                 int lastNameComparison = s1.getLastName().compareTo(s2.getLastName());
                 if (lastNameComparison != 0) return lastNameComparison;

                 int firstNameComparison = s1.getFirstName().compareTo(s2.getFirstName());
                 if (firstNameComparison != 0) return firstNameComparison;

                 return s1.getId() - s2.getId();
              }
      );
      gradedStudents.forEach((gradedStudent -> sortedStudents.put(gradedStudent.getStudent(), gradedStudent.getGrade())));

      for (Student student : sortedStudents.keySet())
      {
         String idPart = String.format("%-" + ID_WIDTH + "d ", student.getId());
         String lNamePart = String.format("%-" + LAST_NAME_WIDTH + "s", student.getLastName());
         String fNamePart = String.format("%-" + FIRST_NAME_WIDTH + "s", student.getFirstName());
         String gradePart = String.format(": %" + GRADE_WIDTH + "s", sortedStudents.get(student));
         this.printStream.println(idPart + lNamePart + fNamePart + gradePart);
      }
   }

   private static class InvalidInputException extends Exception
   {
      public InvalidInputException(String checkedExceptionMessage)
      {
         super(checkedExceptionMessage);
      }
   }
}
