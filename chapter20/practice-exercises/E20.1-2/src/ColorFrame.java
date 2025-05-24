import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A frame with red, green, and blue buttons which change the colour of the background.
 */
public class ColorFrame extends JFrame
{
    private final int FRAME_WIDTH = 500;
    private final int FRAME_HEIGHT = 500;
    private JPanel backgroundPanel;
//    private JButton redButton;
//    private JButton greenButton;
//    private JButton blueButton;

    /**
     * Constructs a color frame.
     */
    public ColorFrame()
    {
        super("Color Frame");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        createLayout();
        this.setVisible(true);
    }

    /**
     * Lays out the components of this frame.
     */
    private void createLayout()
    {
        this.getContentPane().setLayout(new BorderLayout());
        this.add(getButtonPanel(), BorderLayout.NORTH);
        this.add(getColorPanel(), BorderLayout.CENTER);
    }

    private JPanel getButtonPanel()
    {
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1));
        buttonPanel.setBorder(new TitledBorder(new EtchedBorder(), "colors"));
        buttonPanel.add(getColorButton("Red", new Color(255, 0, 0)));
        buttonPanel.add(getColorButton("Green", new Color(0, 255, 0)));
        buttonPanel.add(getColorButton("Blue", new Color(0, 0, 255)));
        return buttonPanel;
    }

    private JButton getColorButton(String name, Color color)
    {
        JButton colorButton = new JButton(name);

        class ChangeColorListener implements ActionListener
        {
            private Color color;

            public ChangeColorListener(Color color)
            {
                this.color = color;
            }

            public void actionPerformed(ActionEvent e)
            {
                ColorFrame.this.setBackgroundColor(color);
            }
        }

        colorButton.addActionListener(new ChangeColorListener(color));
        return colorButton;
    }

    private JPanel getColorPanel()
    {
        this.backgroundPanel = new JPanel();
        return this.backgroundPanel;
    }

    private void setBackgroundColor(Color color)
    {
        this.backgroundPanel.setBackground(color);
    }

}
