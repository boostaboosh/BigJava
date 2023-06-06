import java.util.Scanner;

/**
 * A program that asks the users from which unit they want to convert (fl. oz, gal, oz, lb, in, ft, mi) and to which
 * unit they want to convert (ml, l, g, kg, mm, cm, m, km).
 */
public class ImperialToMetricUnitsOfMeasurementConverter
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      System.out.println("Convert from? ");
      if (input.hasNext())
      {
         String imperialUnitToConvertFrom = input.next();
         if (imperialUnitToConvertFrom.equals("fl. oz") || imperialUnitToConvertFrom.equals("gal")
               || imperialUnitToConvertFrom.equals("oz") || imperialUnitToConvertFrom.equals("lb")
               || imperialUnitToConvertFrom.equals("in") || imperialUnitToConvertFrom.equals("ft")
               || imperialUnitToConvertFrom.equals("mi"))
         {
            System.out.print("Convert to? ");
            if (input.hasNext())
            {
               String metricUnitToConvertTo = input.next();
               if (metricUnitToConvertTo.equals("ml") || metricUnitToConvertTo.equals("l")
                     || metricUnitToConvertTo.equals("g") || metricUnitToConvertTo.equals("kg")
                     || metricUnitToConvertTo.equals("mm") || metricUnitToConvertTo.equals("cm")
                     || metricUnitToConvertTo.equals("m") || metricUnitToConvertTo.equals("km"))
               {

                  // make sure measurement types of units to convert are compatible
                  boolean compatibleMeasurementTypes = false;
                  if ((imperialUnitToConvertFrom.equals("fl. oz") || imperialUnitToConvertFrom.equals("gal"))
                        && (metricUnitToConvertTo.equals("ml") || metricUnitToConvertTo.equals("l")))
                  {
                     compatibleMeasurementTypes = true;
                  }
                  else if ((imperialUnitToConvertFrom.equals("oz") || imperialUnitToConvertFrom.equals("lb"))
                        && (metricUnitToConvertTo.equals("g") || metricUnitToConvertTo.equals("kg")))
                  {
                     compatibleMeasurementTypes = true;
                  }
                  else if ((imperialUnitToConvertFrom.equals("in") || imperialUnitToConvertFrom.equals("ft")
                        || imperialUnitToConvertFrom.equals("mi")) && (metricUnitToConvertTo.equals("mm")
                        || metricUnitToConvertTo.equals("cm") || metricUnitToConvertTo.equals("m")
                        || metricUnitToConvertTo.equals("km")))
                  {
                     compatibleMeasurementTypes = true;
                  }
                  else
                  {
                     System.out.print("Incompatible conversions. Measurement conversion types incompatible.");
                  }

                  if (compatibleMeasurementTypes)
                  {
                     System.out.print("Value? ");
                     if (input.hasNextDouble())
                     {
                        double amountOfImperialUnits = input.nextDouble();

                        BritishImperialMeasurement imperialMeasurement = new BritishImperialMeasurement(amountOfImperialUnits,
                              imperialUnitToConvertFrom);
                        double amountOfMetricUnits = imperialMeasurement.getMetricConversion(metricUnitToConvertTo);
                        System.out.println(amountOfImperialUnits + " " + imperialUnitToConvertFrom + " = "
                              + amountOfMetricUnits + " " + metricUnitToConvertTo);
                     }
                     else
                     {
                        System.out.println("Invalid input. Value must be a number.");
                     }
                  }
               }
               else
               {
                  System.out.println("Invalid input. Valid metric units of measurement are ml, l, g, kg, mm, cm, m, " +
                        "and km.");
               }
            }
         }
         else
         {
            System.out.println("Invalid input. Valid imperial units of measurement are fl. oz, gal, oz, lb, in, ft, " +
                  "and mi.");
         }
      }
   }
}
