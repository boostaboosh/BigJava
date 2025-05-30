import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;

public class BarChartDesignerFrame extends JFrame
{
    private BarChartCanvas barChart;
    private JTextField lengthField;
    private JTextField labelField;
    private Color selectedColor;

    public static void main(String[] args)
    {
        BarChartDesignerFrame frame = new BarChartDesignerFrame();
    }

    public BarChartDesignerFrame()
    {
        this.add(createAddBarMenu(), BorderLayout.WEST);
        this.add(createBarChartCanvas(), BorderLayout.CENTER);
        this.pack();
        this.setVisible(true);
    }

    private JPanel createAddBarMenu()
    {
        JPanel addBarPanel = new JPanel();
        addBarPanel.setLayout(new GridLayout(4, 1));

        // set length
        addBarPanel.add(createSetLengthPanel());

        // set label
        addBarPanel.add(createSetBarLabelPanel());

        // set colour
        addBarPanel.add(createSetBarColorPanel());

        // add item button
        addBarPanel.add(createAddItemButtonPanel());

        addBarPanel.setBorder(new TitledBorder(new EtchedBorder(), "Add Bar Menu"));
        return addBarPanel;
    }

    private JPanel createSetLengthPanel()
    {
        JPanel setLengthPanel = new JPanel();

        setLengthPanel.add(new JLabel("Length: "));
        final int FIELD_WIDTH = 10;
        lengthField = new JTextField(FIELD_WIDTH);
        lengthField.setHorizontalAlignment(JTextField.CENTER);
        setLengthPanel.add(lengthField);

        return setLengthPanel;
    }

    private JPanel createSetBarLabelPanel()
    {
        JPanel setLabelPanel = new JPanel();

        setLabelPanel.add(new JLabel("Label: "));
        final int FIELD_WIDTH = 25;
        labelField = new JTextField(FIELD_WIDTH);
        labelField.setHorizontalAlignment(JTextField.LEADING);
        setLabelPanel.add(labelField);

        return setLabelPanel;
    }

    private JPanel createSetBarColorPanel()
    {
        JPanel setColorPanel = new JPanel();

        selectedColor = new Color(255, 255, 255);

        // construct new color chooser
        JColorChooser cc = new JColorChooser(selectedColor);

        // get notified when user chooses color
        cc.getSelectionModel().addChangeListener(changeEvent ->
        {
            // get user selected value
            selectedColor = cc.getColor();
        });

        setColorPanel.add(cc);
        return setColorPanel;
    }

    private JPanel createAddItemButtonPanel()
    {
        JPanel addItemButtonPanel = new JPanel();

        JButton addItemButton = new JButton("Add Item");
        addItemButton.addActionListener(actionEvent -> addBarToChart());

        addItemButtonPanel.add(addItemButton);
        return addItemButtonPanel;
    }

    private void addBarToChart()
    {
        BarChartValue bar = new BarChartValue(
                Integer.parseInt(lengthField.getText()),
                labelField.getText(),
                selectedColor
        );
        barChart.addValue(bar);
    }

    private JPanel createBarChartCanvas()
    {
        JPanel barChartPanel = new JPanel(new BorderLayout());
        barChart = new BarChartCanvas();
        JScrollPane scrollPane = new JScrollPane(barChart);
        barChartPanel.add(scrollPane);
        return barChartPanel;
    }

    private class BarChartCanvas extends JComponent
    {
        private int maxValue;
        private final ArrayList<BarChartValue> bars;
        private final int BAR_GAP = 10;
        private final int BAR_HEIGHT = 30;
        private final int BAR_TEXT_X_OFFSET = 5;
        private final int BAR_TEXT_Y_OFFSET = 5;
        private final int BAR_X_OFFSET = 5;
        private final int BAR_Y_OFFSET = BAR_GAP;

        public BarChartCanvas()
        {
            maxValue = 0;
            bars = new ArrayList<>();
        }

        public Dimension getPreferredSize()
        {
            int height = bars.size() * (BAR_GAP + BAR_HEIGHT);
            return new Dimension(400, height);
        }

        public void paintComponent(Graphics g)
        {
            int topLeftNextBarYCoordinate = BAR_Y_OFFSET;
            Graphics2D g2D = (Graphics2D) g;
            for (BarChartValue barVal : bars)
            {
                drawBar(g2D, barVal, BAR_X_OFFSET, topLeftNextBarYCoordinate);
                topLeftNextBarYCoordinate += BAR_GAP + BAR_HEIGHT;
            }
        }

        private void drawBar(Graphics2D graphics2D, BarChartValue val, int xCoor, int yCoor)
        {
            int width = (int) ((getWidth() - (BAR_X_OFFSET * 2)) / (double) maxValue * val.value);
            Rectangle bar = new Rectangle(xCoor, yCoor, width, BAR_HEIGHT);

            graphics2D.setStroke(new BasicStroke(2.0f));
            graphics2D.setColor(val.color);
            graphics2D.draw(bar);

            graphics2D.drawString(val.label, xCoor + BAR_TEXT_X_OFFSET, yCoor + BAR_HEIGHT - BAR_TEXT_Y_OFFSET);
        }

        public void addValue(BarChartValue val)
        {
            this.bars.add(val);
            if (val.value > this.maxValue)
            {
                maxValue = val.value;
            }
            this.revalidate();
            this.repaint();
        }
    }

    private class BarChartValue
    {
        public int value;
        public String label;
        public Color color;

        public BarChartValue(int val, String lab, Color col)
        {
            value = val;
            label = lab;
            color = col;
        }
    }
}
