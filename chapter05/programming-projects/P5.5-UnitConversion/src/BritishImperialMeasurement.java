/**
 * A British Imperial measurement has a unit of measurement and an amount.
 */
public class BritishImperialMeasurement
{
   public enum BritishImperialUnitsOfMeasurement { FL_OZ, GAL, OZ, LB, IN, FT, MI };
   public enum MetricUnitsOfMeasurement { ML, L, G, KG, MM, CM, M, KM };
   public enum MeasurementType { VOLUME, WEIGHT, DISTANCE };
   private double amountOfUnits;
   private BritishImperialUnitsOfMeasurement britishImperialUnitOfMeasurement;

   /**
    * Constructs a measurement with a British Imperial unit of measurement.
    * @param amount the amount of measurement units
    * @param imperialUnitOfMeasurement the British Imperial unit of measurement
    */
   public BritishImperialMeasurement(double amount, String imperialUnitOfMeasurement)
   {
      this.amountOfUnits = amount;

      switch (imperialUnitOfMeasurement)
      {
         case "fl. oz": britishImperialUnitOfMeasurement = BritishImperialUnitsOfMeasurement.FL_OZ; break;
         case "gal": britishImperialUnitOfMeasurement = BritishImperialUnitsOfMeasurement.GAL; break;
         case "oz": britishImperialUnitOfMeasurement = BritishImperialUnitsOfMeasurement.OZ; break;
         case "lb": britishImperialUnitOfMeasurement = BritishImperialUnitsOfMeasurement.LB; break;
         case "in": britishImperialUnitOfMeasurement = BritishImperialUnitsOfMeasurement.IN; break;
         case "ft": britishImperialUnitOfMeasurement = BritishImperialUnitsOfMeasurement.FT; break;
         case "mi": britishImperialUnitOfMeasurement = BritishImperialUnitsOfMeasurement.MI; break;
         default: break;
      }
   }

   /**
    * Converts a measurement in British Imperial units to Metric units.
    * @param metricUnitOfMeasurement the metric unit of measurement to convert the imperial measurement to
    * @return the amount of the selected metric unit of measurement this imperial measurement converts to
    */
   public double getMetricConversion(String metricUnitOfMeasurement)
   {
      // imperial to metric conversion multipliers
      final double LITRES_IN_ONE_FLUID_OUNCE = 0.02841306;
      final double LITRES_IN_ONE_GALLON = 4.54609;
      final double GRAMS_IN_ONE_OUNCE = 28.34952;
      final double GRAMS_IN_ONE_POUND = 453.5924;
      final double METRES_IN_ONE_INCH = 0.0254;
      final double METRES_IN_ONE_FOOT = 0.3048;
      final double METRES_IN_ONE_MILE = 1609.344;
      // metric to metric conversion multipliers
      final double MILLILITRES_IN_ONE_LITRE = 1000.0;
      final double GRAMS_IN_ONE_KILOGRAM = 1000.0;
      final double MILLIMETRES_IN_ONE_METRE = 1000.0;
      final double CENTIMETRES_IN_ONE_METRE = 100.0;
      final double METRES_IN_ONE_KILOMETRE = 1000.0;

      BritishImperialUnitsOfMeasurement imperialUnitOfMeasurementToConvertFrom = britishImperialUnitOfMeasurement;
      MetricUnitsOfMeasurement metricUnitOfMeasurementToConvertTo = null;
      MeasurementType imperialMeasurementType;
      MeasurementType metricMeasurementType = null;

      double metricConversionMultiplier = 0;

      double amountOfImperialUnitsToConvert = this.amountOfUnits;
      double amountOfConvertedMetricUnitsOfMeasurement = 0;

      if (britishImperialUnitOfMeasurement == BritishImperialUnitsOfMeasurement.FL_OZ
            || britishImperialUnitOfMeasurement == BritishImperialUnitsOfMeasurement.GAL)
      {
         imperialMeasurementType = MeasurementType.VOLUME;
      }
      else if (britishImperialUnitOfMeasurement == BritishImperialUnitsOfMeasurement.OZ
            || britishImperialUnitOfMeasurement == BritishImperialUnitsOfMeasurement.LB)
      {
         imperialMeasurementType = MeasurementType.WEIGHT;
      }
      else // imperialMeasurementType is equal to mm, cm, m, or km
      {
         imperialMeasurementType = MeasurementType.DISTANCE;
      }

      switch (metricUnitOfMeasurement) {
         case "ml":
         case "l":
            metricMeasurementType = MeasurementType.VOLUME;
            break;
         case "g":
         case "kg":
            metricMeasurementType = MeasurementType.WEIGHT;
            break;
         case "mm":
         case "cm":
         case "m":
         case "km":
            metricMeasurementType = MeasurementType.DISTANCE;
            break;
         default:
            break;
      }

      switch (metricUnitOfMeasurement) {
         case "ml":
            metricUnitOfMeasurementToConvertTo = MetricUnitsOfMeasurement.ML;
            break;
         case "l":
            metricUnitOfMeasurementToConvertTo = MetricUnitsOfMeasurement.L;
            break;
         case "g":
            metricUnitOfMeasurementToConvertTo = MetricUnitsOfMeasurement.G;
            break;
         case "kg":
            metricUnitOfMeasurementToConvertTo = MetricUnitsOfMeasurement.KG;
            break;
         case "mm":
            metricUnitOfMeasurementToConvertTo = MetricUnitsOfMeasurement.MM;
            break;
         case "cm":
            metricUnitOfMeasurementToConvertTo = MetricUnitsOfMeasurement.CM;
            break;
         case "m":
            metricUnitOfMeasurementToConvertTo = MetricUnitsOfMeasurement.M;
            break;
         case "km":
            metricUnitOfMeasurementToConvertTo = MetricUnitsOfMeasurement.KM;
            break;
         default:
            break;
      }

      if (imperialMeasurementType == metricMeasurementType)
      {
         // conversion is valid
         if (imperialMeasurementType == MeasurementType.VOLUME)
         {
            switch (imperialUnitOfMeasurementToConvertFrom)
            {
               case FL_OZ: metricConversionMultiplier = LITRES_IN_ONE_FLUID_OUNCE;
               case GAL: metricConversionMultiplier = LITRES_IN_ONE_GALLON;
               default: break;
            }

            if (metricUnitOfMeasurementToConvertTo == MetricUnitsOfMeasurement.ML)
            {
               amountOfConvertedMetricUnitsOfMeasurement = amountOfImperialUnitsToConvert * metricConversionMultiplier
                     * MILLILITRES_IN_ONE_LITRE;
            }
            else // converting to litres
            {
               amountOfConvertedMetricUnitsOfMeasurement = amountOfImperialUnitsToConvert * metricConversionMultiplier;
            }
         }
         else if (imperialMeasurementType == MeasurementType.WEIGHT)
         {
            if (imperialUnitOfMeasurementToConvertFrom == BritishImperialUnitsOfMeasurement.OZ)
            {
               metricConversionMultiplier = GRAMS_IN_ONE_OUNCE;
            }
            else if (imperialUnitOfMeasurementToConvertFrom == BritishImperialUnitsOfMeasurement.LB)
            {
               metricConversionMultiplier = GRAMS_IN_ONE_POUND;
            }

            if (metricUnitOfMeasurementToConvertTo == MetricUnitsOfMeasurement.KG)
            {
               amountOfConvertedMetricUnitsOfMeasurement = amountOfImperialUnitsToConvert * metricConversionMultiplier
                     / GRAMS_IN_ONE_KILOGRAM;
            }
            else // converting to grams
            {
               amountOfConvertedMetricUnitsOfMeasurement = amountOfImperialUnitsToConvert * metricConversionMultiplier;
            }
         }
         else if (imperialMeasurementType == MeasurementType.DISTANCE)
         {
            if (imperialUnitOfMeasurementToConvertFrom == BritishImperialUnitsOfMeasurement.IN)
            {
               metricConversionMultiplier = METRES_IN_ONE_INCH;
            }
            else if (imperialUnitOfMeasurementToConvertFrom == BritishImperialUnitsOfMeasurement.FT)
            {
               metricConversionMultiplier = METRES_IN_ONE_FOOT;
            }
            else if (imperialUnitOfMeasurementToConvertFrom == BritishImperialUnitsOfMeasurement.MI)
            {
               metricConversionMultiplier = METRES_IN_ONE_MILE;
            }

            if (metricUnitOfMeasurementToConvertTo == MetricUnitsOfMeasurement.MM)
            {
               amountOfConvertedMetricUnitsOfMeasurement = amountOfImperialUnitsToConvert * metricConversionMultiplier
                     * MILLIMETRES_IN_ONE_METRE;
            }
            else if (metricUnitOfMeasurementToConvertTo == MetricUnitsOfMeasurement.CM)
            {
               amountOfConvertedMetricUnitsOfMeasurement = amountOfImperialUnitsToConvert * metricConversionMultiplier
                     * CENTIMETRES_IN_ONE_METRE;
            }
            else if (metricUnitOfMeasurementToConvertTo == MetricUnitsOfMeasurement.KM)
            {
               amountOfConvertedMetricUnitsOfMeasurement = amountOfImperialUnitsToConvert * metricConversionMultiplier
                     / METRES_IN_ONE_KILOMETRE;
            }
            else // converting to metres
            {
               amountOfConvertedMetricUnitsOfMeasurement = amountOfImperialUnitsToConvert * metricConversionMultiplier;
            }
         }
      }

      return amountOfConvertedMetricUnitsOfMeasurement;
   }
}
