package gui;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Represents the tool tip text when hovering over a bar in a bar chart.
 */
public class BarToolTipText
{
    /**
     * Constructs a bar tool tip text object with the given format
     * @param format the format of the tool tip text specified using tokens wrapped in curly braces, e.g.
     *               <p>"There are {otherTokens} other tokens in this format string: {thing}, {other}, {token4}!"</p>
     * @param expectedTokens an array of the token names expected in the format string, e.g.
     *                       "otherTokens", "thing", "other", and "token4" in the format string in the format param
     *                       explanation above
     *
     * @throws IllegalArgumentException when the format string doesn't contain all the provided tokens, e.g. {token}
     */
    public BarToolTipText(String format, String[] expectedTokens)
    {
        this.format = format;
        this.tokens = expectedTokens;
        if (!validateFormatString(format, tokens))
        {
            throw new IllegalArgumentException(
                    String.format(
                            "The format string \"%s\" doesn't contain all the provided tokens %s",
                            format,
                            Arrays.toString(tokens))
            );
        }
    }

    public String generateText(TokenWithValue[] tokenValues)
    {
        return formatTextWithValues(tokenValues);
    }

    private boolean validateFormatString(String format, String[] expectedTokens)
    {
        ArrayList<String> tokensInFormatString = getAllTokens(format);
        return tokensInFormatString.containsAll(Arrays.asList(expectedTokens));
    }

    private ArrayList<String> getAllTokens(String formatString)
    {
        ArrayList<String> tokens = new ArrayList<>();

        boolean charIsPartOfAToken = false;
        StringBuilder currentToken = new StringBuilder();

        for (int charIndex = 0; charIndex < formatString.length(); charIndex++)
        {
            char character = formatString.charAt(charIndex);
            if (character == '{')
            {
                charIsPartOfAToken = true;
                currentToken = new StringBuilder();
            }
            else if (character == '}')
            {
                charIsPartOfAToken = false;
                tokens.add(currentToken.toString());
            }
            else if (charIsPartOfAToken)
            {
                currentToken.append(character);
            }
        }

        return tokens;
    }

    private String formatTextWithValues(TokenWithValue[] tokensWithValue)
    {
        ArrayList<String> tokenNames = new ArrayList<>();
        for (TokenWithValue tokenWithValue : tokensWithValue)
        {
            tokenNames.add(tokenWithValue.tokenName);
        }

        if (!tokenNames.containsAll(Arrays.asList(this.tokens)))
        {
            throw new IllegalArgumentException(
                    "all tokens of this tool tip text were not provided,\n"
                            + "you provided " + Arrays.toString(tokensWithValue) +",\n"
                            + "but " + Arrays.toString(this.tokens) + " were required"
            );
        }

        StringBuilder formattedString = new StringBuilder();

        boolean charIsPartOfAToken = false;
        StringBuilder currentToken = new StringBuilder();

        for (int charIndex = 0; charIndex < format.length(); charIndex++)
        {
            char character = format.charAt(charIndex);
            if (character == '{')
            {
                charIsPartOfAToken = true;
                currentToken = new StringBuilder();
            }
            else if (character == '}')
            {
                charIsPartOfAToken = false;
                String tokenName = currentToken.toString();
                currentToken = new StringBuilder();

                TokenWithValue tokenWithValue = getTokenWithName(tokenName, tokensWithValue);
                if (tokenWithValue != null)
                {
                    formattedString.append(tokenWithValue.tokenValue);
                }
            }
            else if (charIsPartOfAToken)
            {
                currentToken.append(character);
            }
            else if (!charIsPartOfAToken)
            {
                formattedString.append(character);
            }
        }

        return formattedString.toString();
    }

    public static class TokenWithValue
    {
        public TokenWithValue(String tokenName, String tokenValue)
        {
            this.tokenName = tokenName;
            this.tokenValue = tokenValue;
        }

        public final String tokenName;
        public final String tokenValue;
    }

    private TokenWithValue getTokenWithName(String tokenName, TokenWithValue[] tokensWithValue)
    {
        for (TokenWithValue tokenWithValue : tokensWithValue)
        {
            if (tokenWithValue.tokenName.equals(tokenName))
            {
                return tokenWithValue;
            }
        }
        return null;
    }

    private final String format;
    private final String[] tokens;
}
