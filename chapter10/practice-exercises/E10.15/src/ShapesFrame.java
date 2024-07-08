import javax.swing.*;

public class ShapesFrame extends JFrame
{
   private static final int FRAME_WIDTH = 800;
   private static final int FRAME_HEIGHT = 700;

   private ShapesComponent shapesComponent;

   /**
    * Constructs a frame object which contains a shapes component.
    */
   public ShapesFrame()
   {
      // construct component object
      shapesComponent = new ShapesComponent();
      // add component to the frame
      this.add(shapesComponent);
      // configure frame
      this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      this.setTitle("10 random shapes");
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // make the frame visible
      this.setVisible(true);
   }
}
