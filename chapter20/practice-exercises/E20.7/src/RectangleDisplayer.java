import javax.swing.*;
import java.awt.*;

/**
 * Displays rectangles on screen and allows the user to halve or double them.
 */
public class RectangleDisplayer
{
    private JFrame frame;
    private RectanglesCanvas rectanglesCanvas;

    public static void main(String[] args)
    {
        RectangleDisplayer rectangleDisplayer = new RectangleDisplayer();
    }

    public RectangleDisplayer()
    {
        createLayout();
        frame.pack();
        frame.setVisible(true);
    }

    private void createLayout()
    {
        frame = new JFrame("Rectangle Displayer");
        frame.add(createButtonLayout(), BorderLayout.WEST);
        frame.add(createRectangleCanvas(), BorderLayout.CENTER);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private JPanel createRectangleCanvas()
    {
        JPanel rectangleCanvas = new JPanel();
        rectangleCanvas.add(this.rectanglesCanvas = new RectanglesCanvas());
        return rectangleCanvas;
    }

    private JPanel createButtonLayout()
    {
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1));
        JPanel buttons = new JPanel(new GridLayout(2, 1));

        JButton moreButton = new JButton("More");
        moreButton.addActionListener(event ->
                rectanglesCanvas.setNumRectangles(rectanglesCanvas.getNumRectangles() * 2));
        buttons.add(moreButton);

        JButton fewerButton = new JButton("Fewer");
        fewerButton.addActionListener(event ->
                rectanglesCanvas.setNumRectangles(rectanglesCanvas.getNumRectangles() / 2));

        buttons.add(fewerButton);
        JComponent emptyFiller = new JPanel();
        emptyFiller.setPreferredSize(new Dimension(buttons.getWidth(), buttons.getHeight()));
        buttonPanel.add(emptyFiller);
        buttonPanel.add(buttons);

        return buttonPanel;
    }

}
