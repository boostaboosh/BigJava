public class NumericQuestion extends Question
{
   public boolean checkAnswer(String aResponse)
   {
      double response = Double.parseDouble(aResponse);
      double answer = Double.parseDouble(getAnswer());
      final double VALID_RESPONSE_RANGE = 1E-2;
      boolean isCorrect = Math.abs(response - answer) < VALID_RESPONSE_RANGE;
      return isCorrect;
   }
}
