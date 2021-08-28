/*
 * File Name: Assignment5_kchung1351487
 * Author: Kaedon Chung
 * Date: July 3rd, 2021
 * Description: Create a Menu for Customers
 */
import java.text.DecimalFormat;
import java.util.Scanner;

public class Assignment5_kchung1351487 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Set up variables.
        int firstProductChoice = 0;
        int secondProductChoice = 0;
        int firstUnitPrice = 0;
        int secondUnitPrice = 0;
        int firstProductQuantity = 0;
        int secondProductQuantity = 0;
        int discount1 = 0;
        int discount2 = 0;
        int proceedOrExit = 0;
        // Set up money format.
        DecimalFormat decFormat = new DecimalFormat("$#,###.00");
        // Ask customer for first product choice and first product quantity.
        System.out.println("Choose your first product out of the four options. Enter 1 for Swiss Cheese, 2 for Provolone Cheese 3 for Red Wine, and 4 for White Wine.");
        firstProductChoice = input.nextInt();
        if (firstProductChoice == 1) {
            firstUnitPrice = 20;
            discount1 = 1; // More compartmentalized variables.
        } else if (firstProductChoice == 2) {
            firstUnitPrice = 30;
            discount2 = 2; // More compartmentalized variables.
        } else if (firstProductChoice == 3) {
            firstUnitPrice = 40;
        } else if (firstProductChoice == 4) {
            firstUnitPrice = 50;
        } else {
            System.out.println("Please enter valid inputs.");
            //Customer has supplied invalid inputs. 1
            System.exit(-1);
        }
        // Ask customer for second product choice and second product quantity.
        System.out.println("How much of option " + firstProductChoice + " do you want?");
        firstProductQuantity = input.nextInt();
        System.out.println("Choose your second product out of the four options. Enter 1 for Swiss Cheese, 2 for Provolone Cheese 3 for Red Wine, and 4 for White Wine.");
        secondProductChoice = input.nextInt();
        if (secondProductChoice == 1) {
            secondUnitPrice = 20;
            discount1 = 1;
        } else if (secondProductChoice == 2) {
            secondUnitPrice = 30;
            discount2 = 2;
        } else if (secondProductChoice == 3) {
            secondUnitPrice = 40;
        } else if (secondProductChoice == 4) {
            secondUnitPrice = 50;
        } else {
            System.out.println("Please enter valid inputs.");
            // Customer has supplied invalid inputs. 2
            System.exit(-2);
        }
        System.out.println("How much of option " + secondProductChoice + " do you want?");
        secondProductQuantity = input.nextInt();
        // Calculate and print initial prices and customer inputs.
        int firstInitialPrice = (firstProductQuantity * firstUnitPrice);
        int secondInitialPrice = (secondProductQuantity * secondUnitPrice);
        System.out.println("Your first input, " + firstProductQuantity + " units of option " + firstProductChoice + " had an initial price of " +decFormat.format (firstInitialPrice) + ".");
        System.out.println("Your second input, " + secondProductQuantity + " units of option " + secondProductChoice + " had an initial price of " +decFormat.format (secondInitialPrice) + ".");
        // Calculate and print prices with discounts.
        if (firstProductQuantity > 10 && secondProductQuantity > 10 && discount1 == 1 && discount2 == 2) {
            System.out.println("Your total price after a 10% and 5% discount is " + decFormat.format((firstInitialPrice + secondInitialPrice) * 0.9 * 0.95) + ".");
        } else if (firstProductQuantity > 10 && secondProductQuantity > 10) {
            System.out.println("Your total price after a 5% discount is " + (firstInitialPrice + secondInitialPrice) * 0.95 + ".");
        } else if (discount1 == 1 && discount2 == 2) {
            System.out.println("Your total price is after a 10% discount is " + (firstInitialPrice + secondInitialPrice) * 0.9 + ".");
        } else {
            System.out.println("Your total price after a 0% discount is " + decFormat.format (firstInitialPrice + secondInitialPrice) + ".");
        }
        System.out.println("Press 1 to proceed with transaction and pay. Press 2 to cancel transaction.");
        proceedOrExit = input.nextInt();
        if (proceedOrExit == 2){
            // User has cancelled transaction.
            System.out.println("We're sorry we couldn't supply you any products today. Come back when you're ready to purchase!");
            System.exit(-3);
        }
        else{
            System.out.println("\n");
        }
        // Customer has completed transaction and paid.
        System.out.println("Your order has been processed. Thank you for shopping at Pierre's Fine Wine and Aged Cheeses. Please come again!");
    }
}