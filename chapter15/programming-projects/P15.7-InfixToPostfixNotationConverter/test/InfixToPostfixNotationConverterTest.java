import static org.junit.Assert.*;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class InfixToPostfixNotationConverterTest
{
    @Test
    public void validTwoOperandsOneOperatorExpressionConvertedCorrectly()
    {
        String input = "2 + 5";
        String actualOutput = InfixToPostfixNotationConverter.toPostfix(input);

        String expectedOutput = "25+";
        assertEquals("conversion successful", expectedOutput, actualOutput);
    }

    @Test
    public void validThreeOperandsTwoOperatorExpressionConvertedCorrectly()
    {
        String input = "2 + 8 / 2";
        String actualOutput = InfixToPostfixNotationConverter.toPostfix(input);

        String expectedOutput = "282/+";
        assertEquals("conversion successful", expectedOutput, actualOutput);
    }

    @Test
    public void threeArgExpressionWithoutBracketsConvertedCorrectly()
    {
        String input = "3 * 5 + 2";
        String actualOutput = InfixToPostfixNotationConverter.toPostfix(input);
        String expectedOutput = "235*+";
        String alternativeExpectedOutput = "35*2+";
        List<String> expectedPossibleSolutions = List.of(expectedOutput, alternativeExpectedOutput);
        assertTrue(expectedPossibleSolutions.contains(actualOutput));
    }

    @Test
    public void validFourArgExpressionWithoutBracketsConvertedCorrectly()
    {
        String input = "3 * 5 + 2 / 2";
        String actualOutput = InfixToPostfixNotationConverter.toPostfix(input);
        String expectedOutput = "35*22/+";
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void validFourArgExpressionWithTwoParisOfParenthesesAtStartAndEndConvertedCorrectly()
    {
        String input = "(3 * 5) + (2 / 2)";
        String actualOutput = InfixToPostfixNotationConverter.toPostfix(input);
        String expectedOutput = "35*22/+";
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void threeArgExpressionWithBracketsAfterMultiplicationConversion()
    {
        String input = "3 * (4 + 2)";
        String actualOutput = InfixToPostfixNotationConverter.toPostfix(input);
        String expectedOutput = "342+*";
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void threeArgExpressionWithBracketsBeforeMultiplicationConversion()
    {
        String input = "(4 + 2) * 3";
        String actualOutput = InfixToPostfixNotationConverter.toPostfix(input);
        String expectedOutput = "342+*";
        String alternativeExpectedOutput = "42+3*";
        assertTrue(expectedOutput.equals(actualOutput) || alternativeExpectedOutput.equals(actualOutput));
    }

    @Test
    public void threeArgExpressionWithBracketsBeforeSubtractionConversion()
    {
        String input = "(4 + 2) - 3";
        String actualOutput = InfixToPostfixNotationConverter.toPostfix(input);
        String expectedOutput = "42+3-";
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void threeArgExpressionWithBracketsAfterMinusConversion()
    {
        String input = "3 - (4 + 2)";
        String actualOutput = InfixToPostfixNotationConverter.toPostfix(input);
        String expectedOutput = "342+-";
        assertTrue(expectedOutput.equals(actualOutput));
    }

    @Test
    public void validFourArgExpressionWithBracketsAfterMinusAndMultiplicationBeforeMinusInsideBracketsConvertedCorrectly()
    {
        String input = "3 - (4 * 2 - 1)";
        String actualOutput = InfixToPostfixNotationConverter.toPostfix(input);
        String expectedOutput = "342*1--";
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void ManyArgsExpressionsWithBracketsAndMultiplicationAndDivisionConversion()
    {
        String input = "3 * 4 + 2 * (1 + 1 / 2)";
        String actualOutput = InfixToPostfixNotationConverter.toPostfix(input);
        String expectedOutput = "34*2112/+*+";
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void ManyArgsExpressionsWithMultipleGroupsOfParenthesesAndMultiplicationAndDivisionConversion()
    {
        String input = "1 - 1 + 3 * 2 / (1 * 1 + 2) / (3 / 3)";
        String output = InfixToPostfixNotationConverter.toPostfix(input);
        int expectedResult = 2;
        int actualResult = ReversePolishNotationCalculator.evaluate(output);
        assertEquals(expectedResult, actualResult);
    }
}