import static org.junit.Assert.*;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import java.io.InputStream;

public class NumericQuestionTest
{
   @Test public void askANumericQuestion()
   {
      NumericQuestion question = new NumericQuestion();
      question.setText("What is 10 / 3?");
      question.setAnswer("3.333333333");
      String response = "3.333";
      boolean expectedResult = true;
      assertEquals(expectedResult, question.checkAnswer(response));
   }
}