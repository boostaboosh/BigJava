package util;

import gui.BarChartValue;
import investmentCalculator.ProjectedBalance;

import java.util.ArrayList;

public class BarChartValueMapper
{
    public static ArrayList<BarChartValue> getBarChartValuesFromProjectedNominalBalances(ArrayList<ProjectedBalance> projectedBalances)
    {
        ArrayList<BarChartValue> barChartValues = new ArrayList<>();

        for (ProjectedBalance balance : projectedBalances)
        {
            barChartValues.add(new BarChartValue(balance.getYear(), balance.getNominalBalance()));
        }

        return barChartValues;
    }

    public static ArrayList<BarChartValue> getBarChartValuesFromProjectedInflationAdjustedBalances(ArrayList<ProjectedBalance> projectedBalances)
    {
        ArrayList<BarChartValue> barChartValues = new ArrayList<>();

        for (ProjectedBalance balance : projectedBalances)
        {
            barChartValues.add(new BarChartValue(balance.getYear(), balance.getInflationAdjustedBalance()));
        }

        return barChartValues;
    }

}
