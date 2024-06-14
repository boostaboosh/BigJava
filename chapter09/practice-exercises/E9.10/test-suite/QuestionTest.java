import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Scanner;

import java.io.ByteArrayInputStream;

public class QuestionTest
{
   @Test public void addTextToAQuestion()
   {
      Question q = new Question();
      q.setText("This question is about maths.");
      q.addText("\nWhat is the square root of 25?");
      q.display();
   }

   @Test public void displayAChoiceQuestion()
   {
      ChoiceQuestion first = new ChoiceQuestion();
      first.setText("What was the original name of the Java language?");
      first.addChoice("*7", false);
      first.addChoice("Duke", false);
      first.addChoice("Oak", true);
      first.addChoice("Gosling", false);

      ChoiceQuestion second = new ChoiceQuestion();
      second.setText("In which country was the inventor of Java born?");
      second.addChoice("Australia", false);
      second.addChoice("Canada", true);
      second.addChoice("Denmark", false);
      second.addChoice("United States", false);

      Question[] questions = {first, second};

      String sampleInput = "*7\n2\n";
      byte[] inputBytes = sampleInput.getBytes();
      ByteArrayInputStream inputStream = new ByteArrayInputStream(inputBytes);
      Scanner scanner = new Scanner(inputStream);

      for (Question question : questions)
      {
         question.display();
         System.out.println(question.checkAnswer(scanner.nextLine().trim()));
      }
   }
}