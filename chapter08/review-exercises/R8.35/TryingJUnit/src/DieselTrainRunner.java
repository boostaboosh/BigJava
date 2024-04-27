public class DieselTrainRunner
{
   public static void main(String[] args)
   {
      DieselTrain train = new DieselTrain();
      train.move(10);
      train.move(20.5);
      System.out.println(train.getDistanceFromTerminus());
   }
}
