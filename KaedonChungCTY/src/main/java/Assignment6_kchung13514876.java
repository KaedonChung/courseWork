/*
 * File Name: Assignment6_kchung1351487
 * Author: Kaedon Chung
 * Date: July 5th, 2021
 * Description: Help the user find available delivery dates
 */

import java.util.Scanner;
public class Assignment6_kchung13514876 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Setup variables.
        int productChoice = 0;
        int deliveryDay = 0;
        int deliveryYear = 0;
        int deliveryMonth = 0;
        int anotherDate = 0;
        // Strings are placeholders for later in the program.
        String product = "word";
        String month = "phrase";
        System.out.println("Choose your product out of the four options. Enter 1 for Swiss Cheese, 2 for Provolone Cheese 3 for Red Wine, and 4 for White Wine.");
        productChoice = input.nextInt();
        while(anotherDate < 2) {
            System.out.println("Please enter a delivery month.");
            deliveryMonth = input.nextInt();
            // Check for valid month input and prompt the user to either exit or enter a new date. (1)
            if (deliveryMonth > 12 || deliveryMonth < 0) {
                System.out.println("You've entered an invalid input.");
                System.out.println("Would you like to enter another date? Press 1 to enter another date and 2 to exit.");
                anotherDate = input.nextInt();
                if(anotherDate == 1){
                    continue;
                }
                else{
                    System.out.println("Thanks for using our program, see you soon!");
                    System.exit(-1);
                }
            }
            System.out.println("Please enter a delivery day.");
            deliveryDay = input.nextInt();
            System.out.println("Please enter a delivery year.");
            deliveryYear = input.nextInt();

            //Check if date entered by user is unavailable
            if((deliveryMonth == 1 && deliveryDay == 1) ||
                    (deliveryMonth == 3 && deliveryDay == 20) ||
                    (deliveryMonth == 4 && deliveryDay == 22) ||
                    (deliveryMonth == 5 && deliveryDay == 1) ||
                    (deliveryMonth == 6 && deliveryDay == 5) ||
                    (deliveryMonth == 8 && deliveryDay == 2) ||
                    (deliveryMonth == 12 && deliveryDay == 31)) {
                System.out.println("Sorry, this date of delivery is unavailable");
                System.out.println("Would you like to enter another date? Press 1 to enter another date and 2 to exit.");
                anotherDate = input.nextInt();
                if (anotherDate == 1) {
                    continue;
                } else {
                    System.out.println("Thanks for using our program, see you soon!");
                    System.exit(-3);
                }
            }

            // Set product choice to a string.
            if(productChoice == 1){
                product = "Swiss Cheese";
            } else if (productChoice == 2) {
                product = "Provolone Cheese";
            } else if (productChoice == 3) {
                product = "Red Wine";
            } else if (productChoice == 4) {
                product = "White Wine";
            } else{
                product = "Unknown";
            }

            // Print summary
            System.out.println("Your order of " + product + "'s delivery date is " + deliveryMonth + "/" + deliveryDay + "/" + deliveryYear + ".");
            System.out.println("Would you like to enter another date? Press 1 to enter another date and 2 to proceed.");
            anotherDate = input.nextInt();
            if(anotherDate == 1){
                // User wants to enter another date; iterating the while-loop.
                continue;
            }
            // If-else statement for unavailable dates.

            if(deliveryMonth == 1) {
                month = "January";
            }
            else if(deliveryMonth == 2){
               month = "February";
            }
            else if(deliveryMonth == 3){
               month = "March";
            }
            else if(deliveryMonth == 4){
                month = "April";
            }
            else if(deliveryMonth == 5){
                month = "May";
            }
            else if(deliveryMonth == 6){
                month = "June";
            }
            else if(deliveryMonth == 7){
                month = "July";
            }
            else if(deliveryMonth == 8){
                month = "August";
            }
            else if(deliveryMonth == 9){
                month = "September";
            }
            else if(deliveryMonth == 10){
                month = "October";
            }
            else if(deliveryMonth == 11){
                month = "November";
            }
            else if(deliveryMonth == 12){
                month = "December";
            }
            System.out.println("Congrats! Your order of " + product + " is scheduled to arrive on " + month + " " + deliveryDay + ", " + deliveryYear + ".");
        }
    }


}

