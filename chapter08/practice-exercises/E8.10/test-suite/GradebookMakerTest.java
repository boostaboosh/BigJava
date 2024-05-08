import org.junit.Test;
import org.junit.Assert;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import java.util.Scanner;

public class GradebookMakerTest
{
   @Test public void addStudentScoresFromInput()
   {
      GradebookMaker gradebookMaker = new GradebookMaker();
      Gradebook gradebook = new Gradebook();
      gradebook.addStudent(new Student("John Doe"));
      gradebook.addStudent(new Student("Jane Doe"));
      String input = "70\n75\n60\nS\n60\n65\n85\ns\n";
      InputStream inputStream = new ByteArrayInputStream(input.getBytes());
      Scanner inputStreamReader = new Scanner(inputStream);
      gradebookMaker.addStudentScoresFromInput(gradebook, inputStreamReader);
      double expected = 210;
      final double EPSILON = 1E-14;
      Assert.assertEquals(gradebook.getStudents().get(1).getSumOfScores(), expected, EPSILON);
   }
}