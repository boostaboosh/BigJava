import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * A class for experimenting with methods I learn about so that I can learn about it.
 * Then I can see with my own eyes what a method does and run experiments with it.
 * I will keep this program open in the background as I learn so that I can make this kind of
 * experimentation easy and natural.
 */
public class MethodDemonstration
{
    /**
     * The main method where the Java program begins execution.
     * @param args the program starting arguments
     */
    public static void main(String[] args) throws FileNotFoundException
    {
        double num = 12534.2355435;
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(6);
        numberFormat.setMaximumIntegerDigits(2);
        numberFormat.setRoundingMode(RoundingMode.HALF_UP);
        System.out.println(numberFormat.format(num));
        System.out.println(numberFormat.format(num));
        NumberFormat moneyFormat = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println(moneyFormat.format(num));
        NumberFormat integerFormat = NumberFormat.getIntegerInstance();
        System.out.println(integerFormat.format(num));
        NumberFormat percentageFormat = NumberFormat.getPercentInstance();
        System.out.println(percentageFormat.format(num));
        
        System.out.println(3/10);
    }
}
