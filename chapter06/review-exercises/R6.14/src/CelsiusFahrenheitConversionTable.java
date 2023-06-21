public class CelsiusFahrenheitConversionTable
{
   public static void main(String[] args)
   {
      System.out.print("Celsius | Fahrenheit\n--------+-----------\n");

      final double FAHRENHEIT_SCALING_FACTOR = 1.8;
      final int FAHRENHEIT_TRANSLATION_FACTOR = 32;
      final int LAST_VALUE = 100;
      for (int celsiusTemperature = 0; celsiusTemperature <= LAST_VALUE; celsiusTemperature = celsiusTemperature + 10)
      {
         int fahrenheitTemperature = (int) (celsiusTemperature * FAHRENHEIT_SCALING_FACTOR // cast to int is okay because 1.8 * a multiple of ten is always a whole number
               + FAHRENHEIT_TRANSLATION_FACTOR);
         System.out.printf("%7d |%11d\n", celsiusTemperature, fahrenheitTemperature);
      }
   }
}
