package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Logger;

public class BarChart extends JComponent
{
    /**
     * Constructs a bar chart with the specified bar chart values.
     * @param values the bar chart values
     * @param xAxisUnitLabel the label for the x-axis of the bar chart
     * @param yAxisUnitLabel the label for the y-axis of the bar chart
     */
    public BarChart(
            ArrayList<BarChartValue> values,
            String xAxisUnitLabel,
            String yAxisUnitLabel,
            BarChartToolTipTextOptions barChartToolTipTextOptions,
            BarChartToolTipTokenValuesProvider barChartToolTipTokenValuesProvider)
    {
        this.setOpaque(true);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
        this.setFont(new Font("SansSerif", Font.PLAIN, 12));

        if (values == null || values.isEmpty())
        {
            throw new IllegalArgumentException("must set at least 1 value, provided: " + values);
        }
        this.currentValues = values;

        this.xAxisUnitLabel = xAxisUnitLabel;
        this.yAxisUnitLabel = yAxisUnitLabel;

        this.barChartToolTipTextOptions = barChartToolTipTextOptions;
        this.tokenValuesProvider = barChartToolTipTokenValuesProvider;

        // tells swing internal shared tool tip manager so that swing looks for tool tips on this component
        // by calling getToolTipText(MouseEvent e) automatically when the mouse hovers over this component,
        // Alternatively setToolTipText("") would also register this component.
        ToolTipManager.sharedInstance().registerComponent(this);
        ToolTipManager.sharedInstance().setDismissDelay(Integer.MAX_VALUE);
        ToolTipManager.sharedInstance().setInitialDelay(0);
        ToolTipManager.sharedInstance().setReshowDelay(0);

        String logMessage = "tool tip manager default settings:"
                + "\ndismiss delay: " + ToolTipManager.sharedInstance().getDismissDelay()
                + "\ninitial delay: " + ToolTipManager.sharedInstance().getInitialDelay()
                + "\nreshow delay: " + ToolTipManager.sharedInstance().getReshowDelay();
        Logger.getGlobal().info(logMessage);
    }

    public String getToolTipText(MouseEvent event) // return different tool tips based on event.getPoint()
    {
        Bars.Bar barAtPointer = this.bars.getBarAtPoint(event.getPoint()); // or maybe could do getLabelForPoint

        if (barAtPointer == null)
        {
            return barChartToolTipTextOptions.getNotOnBarText();
        }
        else
        {
            Number xValue = barAtPointer.getXAxisValue();
            Number representedValue = barAtPointer.getRepresentedValue();
            return barChartToolTipTextOptions.getBarToolTipText().generateText(
                    tokenValuesProvider.getTokenValuesFor(representedValue, xValue)
            );
        }
    }

    /**
     * Sets the values of this bar chart to the ones provided.
     * @param values the bar chart values to display in this bar chart
     */
    public void setValues(ArrayList<BarChartValue> values)
    {
        if (values == null || values.isEmpty())
        {
            throw new IllegalArgumentException("must set at least 1 value, provided: " + values);
        }
        this.currentValues = values;

        this.revalidate(); // recalculate space necessary for this component within parent component, trigger layout of components in parent
        this.repaint(); // redraw this component via schedules call to paintComponent, trigger redrawing of this component on screen
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D graphics2D = (Graphics2D) g;
        super.paintComponent(graphics2D); // redraws components in parent container

        Point origin = new Point(MARGIN_LEFT, getHeight() - MARGIN_BOTTOM);
        int chartWidth = getWidth() - MARGIN_LEFT - MARGIN_RIGHT;
        int chartHeight = getHeight() - MARGIN_BOTTOM - MARGIN_TOP;

        Axes axes = new Axes(origin, chartWidth, chartHeight, currentValues, xAxisUnitLabel, yAxisUnitLabel);
        this.bars = new Bars(origin, currentValues, chartWidth - ARROW_MARGIN, chartHeight - ARROW_MARGIN);

        axes.paintAxes(graphics2D);
        this.bars.paintBars(graphics2D);
    }

    private final String xAxisUnitLabel;
    private final String yAxisUnitLabel;
    private ArrayList<BarChartValue> currentValues;
    private Bars bars;
    private final BarChartToolTipTextOptions barChartToolTipTextOptions;
    private final BarChartToolTipTokenValuesProvider tokenValuesProvider;

    private static final int MARGIN_LEFT = 180;
    private static final int MARGIN_TOP = 50;
    private static final int MARGIN_BOTTOM = 60;
    private static final int MARGIN_RIGHT = 50;
    private static final int ARROW_MARGIN = 15;

    private static ArrayList<ChartValue> getXChartValues(ArrayList<BarChartValue> values)
    {
        ArrayList<ChartValue> chartValues = new ArrayList<>();
        for (BarChartValue value : values)
        {
            chartValues.add(value.getXAxisValue());
        }
        return chartValues;
    }

    private static ArrayList<ChartValue> getYChartValues(ArrayList<BarChartValue> values)
    {
        ArrayList<ChartValue> chartValues = new ArrayList<>();
        for (BarChartValue value : values)
        {
            chartValues.add(value.getYAxisValue());
        }
        return chartValues;
    }

    private static class Axes
    {

        public Axes(Point2D origin, int xAxisLength, int yAxisLength, ArrayList<BarChartValue> values, String xAxisUnitLabel, String yAxisUnitLabel)
        {
            if (values == null || values.isEmpty())
            {
                throw new IllegalArgumentException("must set at least 1 value, provided: " + values);
            }

            this.xAxis = new Axis(origin, xAxisLength, getXChartValues(values), ORIENTATION.LEFT_TO_RIGHT, xAxisUnitLabel);
            this.yAxis = new Axis(origin, yAxisLength, getYChartValues(values), ORIENTATION.BOTTOM_TO_TOP, yAxisUnitLabel);
        }

        public void setLabels(ArrayList<BarChartValue> values)
        {
            this.xAxis.setTickLabels(getXChartValues(values));
            this.yAxis.setTickLabels(getYChartValues(values));
        }

        public void paintAxes(Graphics2D graphics2D)
        {
            this.xAxis.paintAxis(graphics2D);
            this.yAxis.paintAxis(graphics2D);
        }

        private final Axis xAxis;
        private final Axis yAxis;

        private enum ORIENTATION{ LEFT_TO_RIGHT, BOTTOM_TO_TOP }

        private class Axis
        {
            public Axis(Point2D origin, int length, ArrayList<ChartValue> tickLabels, ORIENTATION orientation, String axisUnitLabel)
            {
                this.origin = origin;
                this.length = length;
                this.tickLabels = tickLabels;
                this.orientation = orientation;
                this.axisUnitLabel = axisUnitLabel;
            }

            public void setTickLabels(ArrayList<ChartValue> tickLabels)
            {
                this.tickLabels = tickLabels;
            }

            public void paintAxis(Graphics2D graphics2D)
            {
                final int ARROW_TIP_HEIGHT = 10;
                final int ARROW_TIP_WIDTH = 10;
                final int TICK_LENGTH = 3;
                final int TICK_LABEL_GAP = 2;

                int usableLength = length - ARROW_MARGIN;
                FontMetrics metrics = graphics2D.getFontMetrics();
                tickLabels.sort(null);

                if (orientation == ORIENTATION.LEFT_TO_RIGHT)
                {
                    int axisEndX = (int) origin.getX() + length;
                    graphics2D.drawLine((int) origin.getX(), (int) origin.getY(), axisEndX, (int) origin.getY());

                    GeneralPath arrowTipPath = new GeneralPath();
                    arrowTipPath.moveTo(axisEndX, origin.getY());
                    arrowTipPath.lineTo(axisEndX - ARROW_TIP_HEIGHT, origin.getY() - (ARROW_TIP_WIDTH / 2.0));
                    arrowTipPath.moveTo(axisEndX, origin.getY());
                    arrowTipPath.lineTo(axisEndX - ARROW_TIP_HEIGHT, origin.getY() + (ARROW_TIP_WIDTH / 2.0));
                    graphics2D.draw(arrowTipPath);

                    double barWidth = usableLength / (double) tickLabels.size();
                    int distanceFromOrigin = Math.toIntExact(Math.round(barWidth / 2));
                    for (ChartValue val : tickLabels)
                    {
                        int tickX = (int) origin.getX() + distanceFromOrigin;
                        distanceFromOrigin += Math.toIntExact(Math.round(barWidth));
                        graphics2D.drawLine(tickX, (int) origin.getY(), tickX, (int) origin.getY() + TICK_LENGTH);

                        // draw horizontal label text beneath ticks
                        String label = val.getLabel();
                        int labelWidth = metrics.stringWidth(label);
                        int labelX = tickX - labelWidth / 2;
                        int labelY = (int) origin.getY() + TICK_LENGTH + TICK_LABEL_GAP + metrics.getAscent();

                        graphics2D.drawString(label, labelX, labelY);
                    }

                    int labelWidth = metrics.stringWidth(axisUnitLabel);
                    int axisUnitLabelX = (int) origin.getX() + length / 2 - labelWidth / 2;
                    int axisUnitLabelY = (int) origin.getY() + MARGIN_BOTTOM - 5;
                    graphics2D.drawString(axisUnitLabel, axisUnitLabelX, axisUnitLabelY);
                }
                else // if orientation bottom to top
                {
                    graphics2D.drawLine((int) origin.getX(), (int) origin.getY(), (int) origin.getX(), (int) origin.getY() - length);

                    GeneralPath arrowTipPath = getBottomUpArrowTipPath(ARROW_TIP_WIDTH, ARROW_TIP_HEIGHT);
                    graphics2D.draw(arrowTipPath);

                    double scaleMultiplier = usableLength / tickLabels.get(tickLabels.size() - 1).getValue().doubleValue();
                    for (ChartValue val : tickLabels)
                    {
                        int distanceFromOrigin = Math.toIntExact(Math.round(scaleMultiplier * val.getValue().doubleValue()));
                        graphics2D.drawLine((int) origin.getX(), (int) origin.getY() - distanceFromOrigin, (int) origin.getX() - TICK_LENGTH, (int) origin.getY() - distanceFromOrigin);

                        // draw horizontal text gap to the left of ticks
                        String label = val.getLabel();
                        int labelWidth = metrics.stringWidth(label);
                        int labelX = (int) origin.getX() - TICK_LENGTH - TICK_LABEL_GAP - labelWidth;
                        int labelY = (int) origin.getY() - distanceFromOrigin + metrics.getAscent() / 2;

                        graphics2D.drawString(label, labelX, labelY);
                    }

                    int axisUnitLabelX = (int) origin.getX() - MARGIN_LEFT + 5;
                    int axisUnitLabelY = (int) origin.getY() - length / 2 + metrics.getAscent() / 2;
                    graphics2D.drawString(axisUnitLabel, axisUnitLabelX, axisUnitLabelY);
                }

            }

            private GeneralPath getBottomUpArrowTipPath(int arrowTipWidth, int arrowTipHeight) {
                double[] arrowTipXPoints = {
                        origin.getX(),
                        origin.getX(),
                        origin.getX() - arrowTipWidth,
                        origin.getX(),
                        origin.getX() + arrowTipWidth
                };
                double[] arrowTipYPoints = {
                        origin.getY(),
                        origin.getY() - length,
                        origin.getY() - length + arrowTipHeight,
                        origin.getY() - length,
                        origin.getY() - length + arrowTipHeight
                };

                GeneralPath arrowTipPath = new GeneralPath();
                arrowTipPath.moveTo(arrowTipXPoints[0], arrowTipYPoints[0]);
                for (int pointIndex = 1; pointIndex < arrowTipXPoints.length; pointIndex++)
                {
                    arrowTipPath.lineTo(arrowTipXPoints[pointIndex], arrowTipYPoints[pointIndex]);
                }
                return arrowTipPath;
            }

            private final Point2D origin;
            private final int length;
            private ArrayList<ChartValue> tickLabels;
            private final ORIENTATION orientation;
            private final String axisUnitLabel;
        }
    }

    private class Bars
    {
        public Bars(Point origin, ArrayList<BarChartValue> values, int barAreaWidth, int barAreaHeight)
        {
            this.origin = origin;
            this.barAreaWidth = barAreaWidth;
            this.barAreaHeight = barAreaHeight;

            this.bars = new ArrayList<>();
            setValues(values);
        }

        public void setValues(ArrayList<BarChartValue> values)
        {
            if (values == null || values.isEmpty())
            {
                throw new IllegalArgumentException("must set at least 1 value, provided: " + values);
            }

            this.bars.clear();

            values.sort((a, b) -> a.getYAxisValue().compareTo(b.getYAxisValue()));
            final double barHeightMultiplier = barAreaHeight / values.get(values.size() - 1).getYAxisValue().getValue().doubleValue();
            final int barWidth = barAreaWidth / values.size();

            for (int barValueCounter = 0; barValueCounter < values.size(); barValueCounter++)
            {
                BarChartValue value = values.get(barValueCounter);
                int barHeight = Math.toIntExact(Math.round(barHeightMultiplier * value.getYAxisValue().getValue().doubleValue()));
                int barBottomLeftX = origin.x + (barValueCounter * barWidth);
                int barBottomLeftY = origin.y;
                Point bottomLeftBar = new Point(barBottomLeftX, barBottomLeftY);
                Color randomColor = new Color(getRandomColorValue(), getRandomColorValue(), getRandomColorValue());
                this.bars.add(new Bar(bottomLeftBar, barWidth, barHeight, randomColor, value));
            }
        }

        public void paintBars(Graphics2D graphics2D)
        {
            for (Bar bar : bars)
            {
                bar.paintBar(graphics2D);
            }
        }

        public Bar getBarAtPoint(Point point)
        {
            for (Bar bar : bars)
            {
                if (bar.contains(point))
                {
                    return bar;
                }
            }
            // otherwise, if no bars contain the point, return null
            return null;
        }

        private int getRandomColorValue()
        {
            final int NUMBER_OF_COLOR_VALUES = 255;
            return randomNumberGenerator.nextInt(NUMBER_OF_COLOR_VALUES + 1);
        }

        private final ArrayList<Bar> bars;
        private final Point origin;
        private final int barAreaWidth;
        private final int barAreaHeight;

        private final Random randomNumberGenerator = new Random();

        private class Bar
        {
            public Bar(Point bottomLeftCorner, int width, int height, Color fillColor, BarChartValue representedValue)
            {
                this.rectangle = new Rectangle(bottomLeftCorner.x, bottomLeftCorner.y - height, width, height);
                this.representedValue = representedValue;
                this.fillColor = fillColor;
            }

            public void paintBar(Graphics2D graphics2D)
            {
                // draw the outline
                graphics2D.setColor(Color.BLACK);
                graphics2D.draw(rectangle);

                // set the fill color
                graphics2D.setColor(fillColor);

                // fill the shape
                graphics2D.fill(rectangle);
            }

            public boolean contains(Point point)
            {
                return this.rectangle.contains(point);
            }

            public Number getRepresentedValue()
            {
                return this.representedValue.getYAxisValue().getValue();
            }

            public Number getXAxisValue()
            {
                return this.representedValue.getXAxisValue().getValue();
            }

            private final Rectangle rectangle;
            private final BarChartValue representedValue;
            private final Color fillColor;
        }
    }

}