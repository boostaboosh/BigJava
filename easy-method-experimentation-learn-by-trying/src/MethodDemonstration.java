import javax.swing.*;
import java.awt.*;
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
        double val = Math.pow(2, 2000) / Math.pow(2, 1000);
        System.out.println(val);
        System.out.println(val * 5);
        System.out.println();

        final int BIG = 1000;
        System.out.println("sqrt " + BIG + "+: " + Math.sqrt(BIG));
        System.out.println("log " + BIG + ": " + Math.log(BIG));
        System.out.println("sqrt 10: " + Math.sqrt(10));
        System.out.println("log 10: " + Math.log(10));
        System.out.println("10 ** 10 : " + NumberFormat.getInstance().format((Math.pow(10, 10))));
        System.out.println("2 ** 10: " + Math.pow(2, 10));
        System.out.println();

        JFrame frame = new JFrame();

        JPanel panel = new JPanel(new BorderLayout());
        JSlider slider = new JSlider();
        panel.add(slider, BorderLayout.CENTER);
        JLabel label = new JLabel("slider label: ");
        panel.add(label, BorderLayout.WEST);

        frame.add(panel);

        frame.setSize(800, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        double num = 12534.2355435;
        doThing(num);
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

    public static void doThing(double num)
    {
        num = 2.0;
        System.out.println("num is " + num);
    }
}
