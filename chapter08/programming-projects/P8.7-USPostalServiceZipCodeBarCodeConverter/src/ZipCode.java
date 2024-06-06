import java.util.Arrays;

/**
 * A zip code is a United States Postal Service 5-digit postal routing code.
 */
public class ZipCode
{
   private int[] zipCode;
   private int currentSize;
   public static final int ZIP_CODE_LENGTH = 5;
   
   /**
    * Constructs a new ZipCode with no digits.
    */
   public ZipCode()
   {
      this.zipCode = new int[ZIP_CODE_LENGTH];
      this.currentSize = 0;
   }

   /**
    * Constructs a zip code from a given zip code
    * @param zipCode the given zip code
    */
   public ZipCode(int zipCode)
   {
      this.zipCode = new int[ZIP_CODE_LENGTH];
      this.currentSize = 0;
      int numberOfDigits = NumberUtilities.getNumberOfDigits(zipCode);
      if (numberOfDigits == 5)
      {
         this.zipCode = NumberUtilities.getArrayOfDigits(zipCode);
         this.currentSize = 5;
      }
   }

   /**
    * Adds a digit to an incomplete zip code.
    * A zip code digit must be a positive integer between 0 and 9, 
    * with upper and lower bounds (0 & 9) included.
    * If the zip code already has the maximum number of digits then no digit is added.
    * @param digit the digit to add to the zip code
    */
   public void addDigit(int digit)
   {
      if (this.currentSize < ZIP_CODE_LENGTH && digit >= 0 && digit < 10)
      {
         this.zipCode[currentSize] = digit;
         this.currentSize = this.currentSize + 1;
      }
   }

   /**
    * Gets a digit from a zip code.
    * The digit is retrieved if a value has been provided for the specified index.
    * @param index the index of the digit to retrieve
    * @return the retrieved digit, or -1 if the index is invalid or the element at that index has not been assigned
    */
   public int getDigit(int index)
   {
      if (index >= 0 && index < this.currentSize)
      {
         return this.zipCode[index];
      }
      else
      {
         return -1;
      }
   }

   /**
    * Gets this zip code as an array of digits.
    * @return this zip code as an array of digits, or an empty array if this zip code doesn't have 5 digits yet
    */
   public int[] getZipCodeAsArray()
   {
      int[] zipCode = new int[0];
      if (this.currentSize == ZIP_CODE_LENGTH)
      {
         zipCode = Arrays.copyOf(this.zipCode, this.zipCode.length);
      }
      return zipCode;
   }

   /**
    * Gets this zip code as an integer or -1 if this zip code isn't complete yet.
    * @return this zip code as an integer or -1 if this zip code isn't complete yet.
    */
   public int getZipCode()
   {
      int zipCode = -1;
      if (this.currentSize == ZIP_CODE_LENGTH)
      {
         String zipCodeString = "";
         for (int digit : this.zipCode)
         {
            zipCodeString = zipCodeString.concat(String.valueOf(digit));
         }
         zipCode = Integer.parseInt(zipCodeString);
      }
      return zipCode;
   }
}
