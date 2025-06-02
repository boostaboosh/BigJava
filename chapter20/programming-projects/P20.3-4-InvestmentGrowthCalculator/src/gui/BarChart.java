package gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BarChart extends JComponent
{
    /**
     * Constructs a bar chart with no values and no bars.
     */
    public BarChart()
    {
        // todo
        this.setOpaque(true);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
//            this.setFont();
    }

    /**
     * Constructs a bar chart with the specified bar chart values.
     * @param values the bar chart values
     */
    public BarChart(ArrayList<BarChartValue> values)
    {
        this(); // call no-arg constructor
        this.values = values;
    }

    /**
     * Sets the values of this bar chart to the ones provided.
     * @param values the bar chart values to display in this bar chart
     */
    public void setValues(ArrayList<BarChartValue> values)
    {
        // todo
        this.values = values;
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        // todo
        // todo: paintAxes() and paintBars() and paintBar() within that most likely
        // todo: use tool tips for hovering over bars, see: https://docs.oracle.com/javase/tutorial/uiswing/components/tooltip.html
    }

    private ArrayList<BarChartValue> values;
}