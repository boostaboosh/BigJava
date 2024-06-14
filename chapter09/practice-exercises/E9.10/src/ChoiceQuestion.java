import java.util.ArrayList;

/**
   A question with multiple choices.
*/
public class ChoiceQuestion extends Question
{
   private int numberOfChoices;

   public ChoiceQuestion()
   {
      numberOfChoices = 0;
   }

   /**
      Adds an answer choice to this question.
      @param choice the choice to add
      @param correct true if this is the correct choice, false otherwise
   */
   public void addChoice(String choice, boolean correct)
   {
      this.numberOfChoices = this.numberOfChoices + 1;
      this.addText("\n" + this.numberOfChoices + ": " + choice);
      if (correct) 
      {
         setAnswer("" + this.numberOfChoices);
      }
   }
   
   public void display()
   {
      // Display the question text
      super.display();
   }
}

