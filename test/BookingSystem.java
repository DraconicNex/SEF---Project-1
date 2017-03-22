import java.util.*;

/*
 * class BookingSystem
 * Modified by S9001731 Mark Randall and s3166005 Greg Pham
 * Implemented by Craig Hamilton on 18/09/2015
 * 
 * You should use this class as a starting point for your
 * assignment 3 program.
 */

public class BookingSystem
{

   // Array used to store both StandardBooking and SpecialBooking objects
   private static StandardBooking[] bookingList = new StandardBooking[100];
   private static int bookingCount = 0;

   // note - you can use this Scanner throughout this class - there
   // is no need to create another Scanner anywhere else

   private static final Scanner sc = new Scanner(System.in);
   // I know but I create new ones to avoid trailing returns. Well that is my
   // logic and
   // it seems to work.

   public static void main(String[] args)
   {
      String response;
      char selection = '\0';

      // Booking Number Exceptions

      do
      {
         // display menu options
         System.out.println("*** Ferry Ticketing system Menu ***");
         System.out.println();
         System.out.println("A   -   Add Standard Booking");
         System.out.println("B   -   Display Bookings");
         System.out.println("C   -   Add Insurance");
         System.out.println("D   -   Add Special Booking");
         System.out.println("E   -   Record RV Weight");
         System.out.println("X   -   Exit");
         System.out.println();
         System.out.print("Enter your selection: ");

         // get user's response
         response = sc.nextLine().toUpperCase();

         System.out.println();

         // response is invalid if it is not 1 character in length
         if (response.length() != 1)
         {
            System.out
                  .println("Error - you did not enter a valid menu option!");
         }
         else
         {
            selection = response.charAt(0);

            // process the user's selection
            switch (selection)
            {
            case 'A':

               // Variables used.

               Scanner answerIn = new Scanner(System.in);
               boolean enter, notYyNn;
               char val = '\0';
               String answer = "";
               enter = true;

               // Use once loop to enter details.
               // Gives Options to enter Booking details without returning to
               // main
               // menu.
               do
               {
                  if (enter)
                  {

                     // Calls method to enter details.
                     addStandardBooking();
                  }
                  // Interrogate and input for another entry.
                  notYyNn = true;
                  do
                  {
                     
                     try
                     {
                        System.out
                              .println("Do You wish to enter another STANDARD Booking?");
                        answer = interogateAnotherEntry(startWithWhiteSpace(answerIn.nextLine()));
                        notYyNn = false;
                     }
                     catch (BookingException messageL)
                     {
                        System.out.println(messageL.getMessage());
                     }
                 } while (notYyNn == true);

                  val = Character.toUpperCase(answer.charAt(0));

                  if (val == 'N')
                  {
                     enter = false;
                  }

               } while (enter == true);

               break;

            case 'B':
               displayBookings();
               break;

            case 'C':

               Scanner answerInCaseC = new Scanner(System.in);
               boolean enterCaseC, notYyNnCaseC;
               String answerCaseC = "";
               enterCaseC = true;

               // Check to see if array has any Employee details.

               if ((bookingCount == 0) && (bookingList[0] == null))
               {
                  System.out.println(
                                     "There are no bookings listed in the Array.\n" +
                                     "Please return to option A or D.");
               }
               else
               {
                  // Gives Options to search for Employees without returning to
                  // main menu.

                  do
                  {
                     if (enterCaseC)
                     {
                        // Call method to add insurance.
                        addInsurance();
                     }
                     // Interrogate and input for another entry.

                     notYyNnCaseC = true;
                     do
                     {
                        try
                        {
                           System.out
                                 .println("Do You wish to enter another Insurance?");
                           answerCaseC = interogateAnotherEntry(startWithWhiteSpace(answerInCaseC.nextLine()));
                           notYyNnCaseC = false;
                        }
                        catch (BookingException messageL)
                        {
                           System.out.println(messageL.getMessage());
                        }
                     } while (notYyNnCaseC == true);

                     val = Character.toUpperCase(answerCaseC.charAt(0));

                     if (val == 'N')
                     {
                        enterCaseC = false;
                     }

                  } while (enterCaseC == true);
               }
               break;

            case 'D':

               // Variables used.

               Scanner answerInCaseD = new Scanner(System.in);
               boolean enterCaseD, notYyNnCaseD;
               String answerCaseD = "";
               enterCaseD = true;

               // Use once loop to enter details.
               // Gives Options to enter Booking details without returning to
               // main
               // menu.
               do
               {
                  if (enterCaseD)
                  {

                     // Calls method to enter details.
                     addSpecialBooking();
                  }
                  // Interrogate and input for another entry.
                  notYyNnCaseD = true;
                  do
                  {
                     try
                     {
                          System.out
                                 .println("Do You wish to enter another SPECIAL Booking?");
                           answerCaseD = interogateAnotherEntry(startWithWhiteSpace(answerInCaseD.nextLine()));
                           notYyNnCaseD = false;
                        }
                        catch (BookingException messageL)
                        {
                           System.out.println(messageL.getMessage());
                        }
                 } while (notYyNnCaseD == true);

                  val = Character.toUpperCase(answerCaseD.charAt(0));

                  if (val == 'N')
                  {
                     enterCaseD = false;
                  }

               } while (enterCaseD == true);

               break;

            case 'E':
               
               
               
               Scanner answerInCaseE = new Scanner(System.in);
               boolean enterCaseE, notYyNnCaseE;
               String answerCaseE = "";
               enterCaseE = true;

               // Use once loop to enter details.
               // Gives Options to enter Booking details without returning to
               // main
               // menu.
               do
               {
                  if (enterCaseE)
                  {

                     // Calls method to enter details.
                     recordRVWeight();
                  }
                  // Interrogate and input for another entry.
                  notYyNnCaseE = true;
                  do
                  {
                     try
                     {
                          System.out
                                 .println("Do You wish to enter another vehicle weight?");
                           answerCaseE = interogateAnotherEntry(startWithWhiteSpace(answerInCaseE.nextLine()));
                           notYyNnCaseE = false;
                        }
                        catch (BookingException messageL)
                        {
                           System.out.println(messageL.getMessage());
                        }
                 } while (notYyNnCaseE == true);

                  val = Character.toUpperCase(answerCaseE.charAt(0));

                  if (val == 'N')
                  {
                     enterCaseE = false;
                  }

               } while (enterCaseE == true);

              
               break;
            case 'X':
               System.out.println("Programing terminating - goodbye!");
               break;

            default:
               System.out
                     .println("Error - you did not enter a valid menu option!");

            }
         }

         System.out.println();

      } while (selection != 'X');
   }

   /*---------------------------------------------------------------------------------------------*/

   // getBooking() - helper method
   //
   // Returns the booking with the specified booking ID
   // if it exists in current set of booking objects
   // stored in the array.
   //
   // Returns null if a booking object with the specified
   // booking ID was not found.
   //
   // NOTE: you can either implement your booking search
   // functionality here and then call this method whenever
   // you need to locate a specific booking in the menu
   // features or just implement the search code internally
   // within the menu features themselves.
   //

   private static StandardBooking getBooking(String targetBookingID)
   {
      return null;
   }

   // addStandardBooking() - Stage 2 requirement (i)
   //
   // Prompts the user to enter a set of booking details and
   // creates a new StandardBooking object based on the user's
   // input and stores it in the bookingList.

   /*-------------------------------- Menu Option A-------------------------------------------------------------*/

   public static void addStandardBooking()
   {
      System.out.println("Add Standard Booking Option Selected!");

      // Variables used in method.
      Scanner sStandardBooking = new Scanner(System.in);
      String inputBookingId = "";
      String inputRegistrationNo = "";
      String inputVehicleDescription = "";
      int inputPassengersNumber = 0;
      boolean notInputBookingId, notRegistrationNo, notVehicleDescription,
            notPassengers;

      // Ask for ID interrogate and then assign to variable.

      notInputBookingId = true;
      do
      {
         try
         {
            System.out.println("Enter the Standard Booking ID:");
            inputBookingId =
                  duplicateIDCheckAndWhiteSpace(sStandardBooking.nextLine());
            notInputBookingId = false;

         }
         catch (BookingException messageD)
         {
            System.out.println(messageD.getMessage());
         }

      } while (notInputBookingId == true);

      // Ask for Vehicle Registration interrogate and then assign to variable.

      notRegistrationNo = true;
      do
      {
         try
         {
            System.out.println("Enter Registration number of the Vehicle:");
            inputRegistrationNo =
                  startWithWhiteSpace(sStandardBooking.nextLine());
            notRegistrationNo = false;
         }
         catch (BookingException messageE)
         {
            System.out.println(messageE.getMessage());
         }

      } while (notRegistrationNo == true);

      // Ask for Vehicle description interrogate and then assign to variable.

      notVehicleDescription = true;
      do
      {
         try
         {
            System.out.println("Enter the description of the Veicle:");
            inputVehicleDescription =
                  startWithWhiteSpace(sStandardBooking.nextLine());
            notVehicleDescription = false;
         }
         catch (BookingException messageF)
         {
            System.out.println(messageF.getMessage());
         }

      } while (notVehicleDescription == true);

      // Ask for Number of passengers interrogate and then assign to variable.
      // Assign variables to new Standard Booking Object, generated by the
      // Standard booking
      // class, to the standard booking array
      // and iterate booking count.

      notPassengers = true;

      do
      {
         try
         {
            System.out.println("Enter the number of passengers:");
            inputPassengersNumber = sStandardBooking.nextInt();
            bookingList[bookingCount] =
                  new StandardBooking(inputBookingId, inputRegistrationNo,
                        inputVehicleDescription, inputPassengersNumber);
            bookingCount++;

            notPassengers = false;
         }
         catch (BookingException messageA)
         {
            System.out.println(messageA.getMessage());
         }
         catch (InputMismatchException messageB)
         {
            System.out.println("Invalid input please try again.");
            sStandardBooking.nextLine();
         }

      } while (notPassengers == true);
   }

   /*-------------------------------- Menu Option B-------------------------------------------------------------*/

   // displayBookings() - Stage 2 requirement (ii)
   //
   // Locates a Booking specified by the user and displays
   // the applicable booking fee to the screen.

   public static void displayBookings()
   {
      System.out.println("Display Bookings Selected!");

      // Loop to iterate through the array and 
      // print details, to stop at the last filled array element.

      for (int m = 0; m < bookingCount; m++)
      {
         bookingList[m].printDetails();
         System.out.println();
      }

   }

   // addInsurance() - Stage 2 requirement (iii)
   //
   // Locates a Booking specified by the user and attempts
   // to add insurance for that booking.

   /*-------------------------------- Menu Option C-------------------------------------------------------------*/

   public static void addInsurance()
   {
      System.out.println("Add Insurance Option Selected!");

      // Variables used.

      Scanner sBookingSearch = new Scanner(System.in);
      String inputBookingSearchId = "";
      StandardBooking tempBooking = null;
      boolean isInsuranceAdded;

      // Ask for input.

      System.out.println("Enter the Booking ID to search for:");
      inputBookingSearchId = sBookingSearch.nextLine();

      // Search array for using ID accessor from Employee class.
      // If a valid ID then rewrite temporary Employee object.

      for (int n = 0; n < bookingCount; n++)
      {

         if (bookingList[n].getBookingID().equals(inputBookingSearchId))
         {

            tempBooking = bookingList[n];
         }
      }

      // Interrogate to see if temporary object changed.
      // If true must have valid ID and then interrogate for insurance
      // and then add the option.
      // Would be more robust if a. database interrogated
      // for a unique ID in option a.
      // or b. temporary was an array to capture
      // multiple instances of.

      if (tempBooking == null)
      {

         System.out.println("There is Booking with that ID in\n" +
                            "the database. Please check ID.");
      }

      else
      {
         isInsuranceAdded = tempBooking.addInsurance();
         if (isInsuranceAdded)
         {
            System.out.println("Insurance has been added for this booking");
         }
         else
         {
            System.out.println("Insurance was already taken by this booking.");
         }
      }

   }

   // addSpecialBooking() - Stage 4 requirement (i)
   //
   // Prompts the user to enter a set of booking details and
   // creates a new SpecialBooking object based on the user's
   // input and stores it in the bookingList.

   /*-------------------------------- Menu Option D-------------------------------------------------------------*/

   public static void addSpecialBooking()
   {
      System.out.println("Add Special Booking Option Selected!");

      // Variables used in method.
      Scanner sSpecialBooking = new Scanner(System.in);
      String inputSpecialBookingId = "";
      String inputSpecialRegistrationNo = "";
      String inputSpecialVehicleDescription = "";
      int inputSpecialPassengersNumber = 0;
      boolean notSpecialInputBookingId, notSpecialRegistrationNo,
            notSpecialVehicleDescription, notSpecialPassengers;

      // Ask for ID interrogate and then assign to variable.

      notSpecialInputBookingId = true;
      do
      {
         try
         {
            System.out.println("Enter the Special Booking ID:");
            inputSpecialBookingId =
                  duplicateIDCheckAndWhiteSpace(sSpecialBooking.nextLine());
            notSpecialInputBookingId = false;

         }
         catch (BookingException messageD)
         {
            System.out.println(messageD.getMessage());
         }
      } while (notSpecialInputBookingId == true);

      // Ask for Vehicle Registration interrogate and then assign to variable.

      notSpecialRegistrationNo = true;
      do
      {
         try
         {
            System.out.println("Enter Registration number of the Vehicle:");
            inputSpecialRegistrationNo =
                  startWithWhiteSpace(sSpecialBooking.nextLine());
            notSpecialRegistrationNo = false;
         }
         catch (BookingException messageG)
         {
            System.out.println(messageG.getMessage());
         }

      } while (notSpecialRegistrationNo == true);

      // Ask for Vehicle description interrogate and then assign to variable.

      notSpecialVehicleDescription = true;
      do
      {
         try
         {
            System.out.println("Enter the description of the Veicle:");
            inputSpecialVehicleDescription =
                  startWithWhiteSpace(sSpecialBooking.nextLine());
            notSpecialVehicleDescription = false;
         }
         catch (BookingException messageH)
         {
            System.out.println(messageH.getMessage());
         }
      } while (notSpecialVehicleDescription == true);

      // Ask for Number of passengers interrogate and then assign to variable.
      // Assign variables to new Special Booking Object, generated by the
      // special booking
      // class, to the standard booking array
      // and iterate booking count.

      notSpecialPassengers = true;
      do
      {
         try
         {
            System.out.println("Enter the number of passengers:");
            inputSpecialPassengersNumber = sSpecialBooking.nextInt();
            bookingList[bookingCount] = new SpecialBooking(
                  inputSpecialBookingId, inputSpecialRegistrationNo,
                  inputSpecialVehicleDescription, inputSpecialPassengersNumber);
            bookingCount++;

            notSpecialPassengers = false;
         }
         catch (BookingException messageJ)
         {
            System.out.println(messageJ.getMessage());
         }
         catch (InputMismatchException messageK)
         {
            System.out.println("Invalid input please try again.");
            sSpecialBooking.nextLine();
         }

      } while (notSpecialPassengers == true);

   }

   // recordRVWeight() - Stage 4 requirement (ii)
   //
   // Locates an RVbooking specified by the user and
   // displays the recorded weight of the recreational vehicle.

   /*-------------------------------- Menu Option E-------------------------------------------------------------*/

   public static void recordRVWeight()
   {
      System.out.println("Record RV Weight Option Selected!");

      Scanner sRecordWeightSearch = new Scanner(System.in);
      String inputRecordWeightSearchId = "";
      StandardBooking tempBooking = null;
      double addWeight;
      boolean isRecordWeightAdded;
      boolean inputDoubleTestPass = false;

      // Ask for input.

      System.out.println("Enter the Booking ID to search for:");
      inputRecordWeightSearchId = sRecordWeightSearch.nextLine();

      // Search array for using ID accessor from Employee class.
      // If a valid ID then rewrite temporary Employee object.

      for (int n = 0; n < bookingCount; n++)
      {

         if (bookingList[n].getBookingID().equals(inputRecordWeightSearchId))
         {

            tempBooking = bookingList[n];
         }
      }

      // Interrogate to see if temporary object changed.
      // If true must have valid ID and then interrogate for insurance
      // and then add the option.
      // Would be more robust if a. database interrogated
      // for a unique ID in option a.
      // or b. temporary was an array to capture
      // multiple instances of.

      if (tempBooking == null)
      {

         System.out.println("There is no Booking with that ID in\n" +
                            "the database. Please check ID.");
         return;
      }

      else if (tempBooking instanceof SpecialBooking)
      {
         do
         {
            try
            {
               if (((SpecialBooking) tempBooking).getVehicleWeight() != 0)
               {
                  System.out.println("Vehicle Weight has already been entered");
                  return;
               }
               else
               {
                  System.out.println("Enter the Vehicle Weight:");
                  addWeight = sRecordWeightSearch.nextDouble();
                  isRecordWeightAdded =
                        ((SpecialBooking) tempBooking).recordWeight(addWeight);
                  if (isRecordWeightAdded == true)
                  {
                     System.out
                           .println("Vehicle weight has been successfully recorded");
                     inputDoubleTestPass = true;

                  }

                  else
                  {
                     System.out
                           .println("Vehicle weight that was entered is not within the required limits.");

                  }

               }
            }
            catch (InputMismatchException messageC)

            {
               System.out.println("Invalid input please try again.");
               sRecordWeightSearch.nextLine();
            }

         } while (!inputDoubleTestPass);
      }
      else
      {

         System.out
               .println("Error - cannot  record weight for a Standard booking.");

      }

   }

   /*-----------------------------------------------------------------------------------------------------------*/

   public static boolean charisNotYyNn(String testedCharacter)
   {

      boolean answerCharTest = true;

      if (((testedCharacter.charAt(0) == 'y' ||
            testedCharacter.charAt(0) == 'Y')) ||
          ((testedCharacter.charAt(0) == 'n' ||
            testedCharacter.charAt(0) == 'N')))
      {
         answerCharTest = false;
         return answerCharTest;

      }
      return answerCharTest;
   }

   /*-----------------------------------------------------------------------------------------------------------*/

   public static boolean stringIsNotAllDigits(String testedValue)
   {

      boolean answerTest = false;

      for (int testChar = 0; testChar < testedValue.length(); testChar++)
      {

         if ((Character.isDigit(testedValue.charAt(testChar))) == false)
         {
            answerTest = true;
            return answerTest;
         }

      }
      return answerTest;
   }

   /*-----------------------------------------------------------------------------------------------------------*/

   public static String duplicateIDCheckAndWhiteSpace(String ID)
         throws BookingException
   {
      for (int a = 0; a < bookingCount; a++)
      {
         if (ID.equals(bookingList[a].getBookingID()))
         {
            throw new BookingException(
                  "Error - duplicate booking ID detected!\nPlease try again.");
         }
         else if ((ID.length() == 0) || (Character.isWhitespace(ID.charAt(0))))
         {
            throw new BookingException(
                  "Error - A return or white space has been detetected!\nPlease try again.");
         }
      }
      return ID;
   }

   /*-----------------------------------------------------------------------------------------------------------*/
   public static String startWithWhiteSpace(String enteredString)
         throws BookingException
   {
      if ((enteredString.length() == 0) ||
          (Character.isWhitespace(enteredString.charAt(0))))
      {
         throw new BookingException(
               "Error - A return or white space has been detetected!\nPlease try again.");
      }

      return enteredString;
   }
 
   
   /*-----------------------------------------------------------------------------------------------------------*/
   
   
   
   
  public static String interogateAnotherEntry(String answer) throws BookingException
  {
     
     if (answer.length() != 1)
     {
        throw new BookingException("Error - More than one character detected!");
     }
     
     else if (charisNotYyNn(answer))
           {
        throw new BookingException("Error - Charecter must be either Y or y o rN or n!");
           }
     return answer;
                                       
   }

}
