import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class RectangleComponent extends JComponent
{
    public void paintComponent(Graphics g)
    {
        // Recover Graphics2D
        Graphics2D graphics2D = (Graphics2D) g;

        // Construct a rectangle
        Rectangle box = new Rectangle(5, 10, 20, 30);

        // Draw the rectangle
        graphics2D.draw(box);

        // Move rectangle 15 units to the right and 25 units down
        box.translate(15, 25);

        // Draw moved rectangle
        graphics2D.draw(box);
    }
}
