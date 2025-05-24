import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * A frame with red, green, and blue buttons which change the colour of the background.
 */
public class ColorFrame extends JFrame
{
    private final int FRAME_WIDTH = 500;
    private final int FRAME_HEIGHT = 500;
    private JPanel backgroundPanel;

    /**
     * Constructs a color frame.
     */
    public ColorFrame()
    {
        super("Color Frame");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        createLayout();
        this.pack();
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

    /**
     * Lays out the buttons in the button panel
     * @return the button panel
     */
    private JPanel getButtonPanel()
    {
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1));
        buttonPanel.setBorder(new TitledBorder(new EtchedBorder(), "colors"));
        try {
            ImageIcon redIcon = loadScaledImageIcon("https://imgs.search.brave.com/YGSVSe0o8R7c4P4NKAI2MR-UlWly-dR2WGPvTAUQXKE/rs:fit:500:0:0:0/g:ce/aHR0cHM6Ly9pbWdz/LnNlYXJjaC5icmF2/ZS5jb20vUEpXcDdF/NFhacG8wcDFtd3BJ/UXY2MjlrazU4LURn/ZGxQNzlxV3AxbUFw/SS9yczpmaXQ6NTAw/OjA6MDowL2c6Y2Uv/YUhSMGNITTZMeTkz/ZDNjdS9ZMjlzYjNK/d2MzbGphRzlzL2Iy/ZDVMbTl5Wnk5M2ND/MWovYjI1MFpXNTBM/M1Z3Ykc5aC9aSE12/TWpBeU15OHdOQzlI/L1lYcGhibWxoTFZK/bFpDMVQvYUdGa1pY/TXRWSEpsWVhOMS9j/bVV0Um14dmQyVnlN/eTVxL2NHYw.jpeg");
            buttonPanel.add(getIconColorButton("Red", new Color(255, 0, 0), redIcon));

            ImageIcon greenIcon = loadScaledImageIcon("https://imgs.search.brave.com/UWjtyzqppZ7nGoRO_7omCI3lxJp4NbYGsggNHBlbeF0/rs:fit:500:0:0:0/g:ce/aHR0cHM6Ly9pbWdz/LnNlYXJjaC5icmF2/ZS5jb20vOGJ2a09h/Y3N4MzlrNi13dXVw/cGRlS2NiVEJ3dkJx/S1VNMTFvVnVXdmEz/VS9yczpmaXQ6NTAw/OjA6MDowL2c6Y2Uv/YUhSMGNITTZMeTlw/TG5CcC9ibWx0Wnk1/amIyMHZiM0pwL1oy/bHVZV3h6THpZNUx6/RXovTHpjMUx6WTVN/VE0zTlRsay9abUUw/WWprek5HWXlaVEkz/L1ltTTBZekptTVRV/M1kySXcvTG1wd1p3.jpeg");
            buttonPanel.add(getIconColorButton("Green", new Color(0, 255, 0), greenIcon));

            ImageIcon blueIcon = loadScaledImageIcon("https://imgs.search.brave.com/6B4hbT3BKhq9tsuCE4L_FeYraesfMdLU_AgvJ_rOqFw/rs:fit:500:0:0:0/g:ce/aHR0cHM6Ly9pbWdz/LnNlYXJjaC5icmF2/ZS5jb20veENrSUpE/d3RQekpIZ2ZEN2ha/Mk5lWC1WOGFiVVRp/eHBUbXIwTEdJUFJD/VS9yczpmaXQ6NTAw/OjA6MDowL2c6Y2Uv/YUhSMGNITTZMeTl0/WldScC9ZUzVwYzNS/dlkydHdhRzkwL2J5/NWpiMjB2YVdRdk1U/RXovTURZeU9EYzRO/eTl3YUc5MC9ieTl6/ZFdsMFkyRnpaUzF0/L2FXNXBiV0ZzTFhS/eVlYWmwvYkMxamIy/NWpaWEIwTFhkcC9k/R2d0WW14MVpTMWlZ/V05yL1ozSnZkVzVr/TG1wd1p6OXovUFRZ/eE1uZzJNVEltZHow/dy9KbXM5TWpBbVl6/MXVSVTFPL1RXMXhl/azFwZHpSZmJHdG0v/Y0UxWE5tUk5WQzFz/YTJ3NS9VMGxyTFc1/Qk1uQTRZbmRXL1Rp/MVpQUQ.jpeg");
            buttonPanel.add(getIconColorButton("Blue", new Color(0, 0, 255), blueIcon));
        } catch (MalformedURLException e) {
            buttonPanel.add(getColorButton(
                    "Red",
                    new Color(255, 0, 0)
            ));
            buttonPanel.add(getColorButton(
                    "Green",
                    new Color(0, 255, 0)
            ));
            buttonPanel.add(getColorButton(
                    "Blue",
                    new Color(0, 0, 255)
            ));
        }
        buttonPanel.setPreferredSize(new Dimension(150, 250));
        return buttonPanel;
    }

    private JButton getIconColorButton(String name, Color color, Icon icon)
    {
        JButton colorButton = new JButton(name, icon);

        class ChangeColorListener implements ActionListener
        {
            private final Color color;

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

    private JButton getColorButton(String name, Color color)
    {
        JButton colorButton = new JButton(name);

        class ChangeColorListener implements ActionListener
        {
            private final Color color;

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

    /**
     * Gets a 32 x 32 sized image icon from a given image URL.
     * @param imageUrl the image url
     * @return a 32 x 32 sized image icon of the image at the provided URL
     * @throws MalformedURLException if the imageUrl is of a bad format
     */
    private ImageIcon loadScaledImageIcon(String imageUrl) throws MalformedURLException
    {
        ImageIcon icon = new ImageIcon(new URL(imageUrl));
        Image scaledImage = icon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }

    private JPanel getColorPanel()
    {
        this.backgroundPanel = new JPanel();
        this.backgroundPanel.setPreferredSize(new Dimension(200, 200));
        return this.backgroundPanel;
    }

    private void setBackgroundColor(Color color)
    {
        this.backgroundPanel.setBackground(color);
    }

}
