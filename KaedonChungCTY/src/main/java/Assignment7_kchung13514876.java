/*
 * File Name: Assignment7_kchung1351487
 * Author: Kaedon Chung
 * Date: July 10th, 2021
 * Description: Collect user's payment method
 */
import java.util.Scanner;
public class Assignment7_kchung13514876 {
    // Constant strings for credit card brands.
    public static final String AMERICAN_EXPRESS = "American Express";
    public static final String MASTERCARD = "Mastercard";
    public static final String VISA = "Visa";
    public static final String DISCOVER = "Discover";
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Set variables.
        int paymentMethod = 0;
        String paymentMethodString = null;
        String creditCardNumber = null;
        String creditCardBrandString = null;
        int continueOrExit = 1;
        boolean lengthCheck = false;

        // Ask user for payment method.
        System.out.println("How will you be paying today? Press 1 for credit card, 2 for cash, and 3 for check.");
        paymentMethod = input.nextInt();
        if (paymentMethod == 1) {
            while (continueOrExit == 1) {
                System.out.println("What is your credit card number?");
                creditCardNumber = input.next();
                // Calls checkBrand method and sets the output to variable creditCardBrandString.
                creditCardBrandString = checkBrand(creditCardNumber);
                lengthCheck = checkLength(creditCardNumber,creditCardBrandString);
                if (creditCardBrandString.equalsIgnoreCase("invalid") || lengthCheck == false) {
                    System.out.println("You've entered an invalid input.");
                    System.out.println("Would you like to enter another credit card number? Press 1 to enter another credit card number and 2 to exit.");
                    continueOrExit = input.nextInt();
                    if (continueOrExit == 1) {
                        continue;
                    } else {
                        System.out.println("Thanks for using our program, see you soon!");
                        System.exit(-1);
                    }
                }
                continueOrExit++;
            }
        }

        // Set payment method to a string.
        if (paymentMethod == 1) {
            paymentMethodString = "credit card";
        } else if (paymentMethod == 2) {
            paymentMethodString = "cash";
        } else if (paymentMethod == 3) {
            paymentMethodString = "check";
        } else {
            paymentMethodString = "Unknown";
        }

        if (paymentMethod == 1) {
            System.out.println("Your payment method was a/n " + creditCardBrandString + " credit card.");
        } else {
            System.out.println("Your payment method was " + paymentMethodString + ".");
        }
    }

    // Method takes credit card number and outputs corresponding credit card brand.
    public static String checkBrand(String creditCardNumber) {
        String creditCardBrandString = null;
        int firstNumber = creditCardNumber.charAt(0);
        if (firstNumber == '3') {
            creditCardBrandString = AMERICAN_EXPRESS;
        } else if (firstNumber == '4') {
            creditCardBrandString = VISA;
        } else if (firstNumber == '5') {
            creditCardBrandString = MASTERCARD;
        } else if (firstNumber == '6') {
            creditCardBrandString = DISCOVER;
        } else {
            creditCardBrandString = "invalid";
        }
        return creditCardBrandString;
        }

    // Method checks whether the credit card number length is valid by inputting credit card number and brand.
    // The method then outputs a boolean dependant on if the credit card number length is valid.
    public static boolean checkLength(String creditCardNumber, String creditCardBrand) {
        int creditCardNumberLength = creditCardNumber.length();
        if (creditCardNumberLength == 15 && creditCardBrand.equalsIgnoreCase(AMERICAN_EXPRESS)) {
            return true;
        } else if (creditCardNumberLength == 16 && (creditCardBrand.equalsIgnoreCase(VISA)||
                creditCardBrand.equalsIgnoreCase(DISCOVER)||
                creditCardBrand.equalsIgnoreCase(MASTERCARD))) {
            return true;
        } else return false;
    }
}


