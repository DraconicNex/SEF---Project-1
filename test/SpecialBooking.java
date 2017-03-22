import java.util.*;
/* class that extends the Standard Booking System by adding vehicle weight in the instance of
 *  the booked vehicle being a recreational vehicle.
 *Added by S9001731 Mark Randall and s3166005 Greg Pham 18 October 2015 as part of Assignment 3 specifications.
 */

public class SpecialBooking extends StandardBooking
{
   // instance variable
   private double vehicleWeight;

   // Constants
   private static final double RECREATIONAL_VEHICLE_RATE = 0.10;

   public SpecialBooking(String bookingID, String registrationNumber,
                         String vehicleDescription,
                         int passengers) throws BookingException

   {
      super(bookingID, registrationNumber, vehicleDescription, passengers);

      this.vehicleWeight = 0.00;
   }

   // accessors
   public double getVehicleWeight()
   {

      return vehicleWeight;
   }

   public boolean recordWeight(double weight)
   {

      if ((weight < 1000.00) || (weight > 6000))
      {
         return false;
      }
      else
      {
         this.vehicleWeight = weight;
         return true;
      }
   }

   public double getBookingFee()
   {

      double newBookingFee = super.getBookingFee();

      if (vehicleWeight > 2000.00)
      {
         newBookingFee +=
               ((vehicleWeight - 2000.00) * RECREATIONAL_VEHICLE_RATE);
      }
      return newBookingFee;
   }

   public void printDetails()
   {
      super.printDetails();
      if (vehicleWeight == 0.00)
      {
         System.out
               .println("The vehicle weight is recorded as 0.00 as it has not been entered.");
      }
      else
      {
         System.out.printf("%-25s%.2f\n", "Vehilcle Weight:",
                           this.vehicleWeight);
      }

   }
}