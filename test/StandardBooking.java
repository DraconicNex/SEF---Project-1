import java.io.*;
import java.util.*;

/*
 * class StandardBooking
 * 
 * Implemented by Craig Hamilton on 18/09/2015
 * Modified by S9001731 Mark Randall and s3166005 Greg Pham
 * This is a sample code for the StandardBooking class - you must
 * work off this sample implementation in your Assignmkent 3 program.
 * 
 */
// extension  to the java library exception class


public class StandardBooking
{
   // instance variables - Ass 3 Stage A requirement (i)
   private String bookingID;
   private String registrationNo;
   private String vehicleDescription;
   private int passengers;
   private boolean hasInsurance;

   // class constants - Ass 3 Stage A requirement (ii)
   private static final double BASIC_BOOKING_FEE = 100;
   private static final double PASSENGER_SURCHARGE = 50;
   private static final double INSURANCE_SURCHARGE = 50;

   // constructor - Ass 3 Stage A requirement (iii)
   public StandardBooking(String bookingID, String registrationNumber,
                          String vehicleDescription, int passengers) throws BookingException
   {
      // if user tries to enter zero or negative number for passengers
      if (passengers <= 0){
         throw new BookingException (" Error - invalid passenger count!");
      }
      
      this.bookingID = bookingID;
      this.registrationNo = registrationNumber;
      this.vehicleDescription = vehicleDescription;
      this.passengers = passengers;

      hasInsurance = false;
   }

   // addInsurance() - Ass 3 Stage A requirement (v)
   public boolean addInsurance()
   {
      // check if insurance has not already been added
      if (hasInsurance == false)
      {
         this.hasInsurance = true;
         return true;
      }
      else
      {
         // insurance has already been added
         return false;
      }
   }

   // accessors - Ass 2 Stage A requirement (iv)
   public String getBookingID()
   {
      return bookingID;
   }

   public String getRegistrationNo()
   {
      return registrationNo;
   }

   public String getVehicleDescription()
   {
      return vehicleDescription;
   }

   public int getPassengers()
   {
      return passengers;
   }

   public boolean isInsuranceIncluded()
   {
      return hasInsurance;
   }

   // getBookingFee() - Ass 2 Stage A requirement (vi)
   public double getBookingFee()
   {
      double bookingFee = BASIC_BOOKING_FEE;

      // check if passenger surcharge applies
      if (passengers > 1)
      {
         bookingFee += (passengers - 1) * PASSENGER_SURCHARGE;
      }

      // check if insurance surcharge applies
      if (hasInsurance == true)
      {
         bookingFee = bookingFee + INSURANCE_SURCHARGE;
      }

      return bookingFee;
   }

   // printBookingSummary() - Ass 2 Stage A requirement (vii)
   public void printDetails()
   {
      System.out.printf("%-25s%s\n", "Booking ID:", this.bookingID);
      System.out.printf("%-25s%s\n", "Registration Number:",
                        this.registrationNo);
      System.out.printf("%-25s%s\n", "Vehicle Make/Model:",
                        this.vehicleDescription);
      System.out.printf("%-25s%d\n", "Passengers:", this.passengers);
      System.out.printf("%-25s%b\n", "Insurance included:", hasInsurance);
      System.out.printf("%-25s$%.2f\n", "Booking Fee:", this.getBookingFee());
   }

}
