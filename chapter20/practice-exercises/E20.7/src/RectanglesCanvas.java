import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class RectanglesCanvas extends JComponent
{

    private final int MAX_COORDINATE = 1000;
    private final Random randomNumberGenerator;
    private int numRectangles;

    public RectanglesCanvas()
    {
        randomNumberGenerator = new Random();
        numRectangles = randomNumberGenerator.nextInt(100);
        setPreferredSize(new Dimension(MAX_COORDINATE, MAX_COORDINATE));
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        for (int counter = 0; counter < numRectangles; counter++)
        {
            int MAX_SIDE_LENGTH = 100;
            int width = randomNumberGenerator.nextInt(MAX_SIDE_LENGTH);
            int height = randomNumberGenerator.nextInt(MAX_SIDE_LENGTH);

            Rectangle outline = new Rectangle(
                    randomNumberGenerator.nextInt(MAX_COORDINATE - width),
                    randomNumberGenerator.nextInt(MAX_COORDINATE - height),
                    width,
                    height
            );
            g2.draw(outline);
        }
    }

    public int getNumRectangles()
    {
        return this.numRectangles;
    }

    public void setNumRectangles(int numRectangles)
    {
        if (numRectangles < 1)
        {
            numRectangles = 1;
        }
        this.numRectangles = numRectangles;
        this.repaint();
    }

}
