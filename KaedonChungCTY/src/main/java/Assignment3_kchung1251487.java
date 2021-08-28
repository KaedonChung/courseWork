import java.util.Scanner;

public class Assignment3_kchung1251487 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // collect input
        System.out.println("Enter a yearly interest rate as a percentage.");
        double yearlyInterestRate = input.nextDouble()/100;
        System.out.println("Enter the number of loan years.");
        int loanYears = input.nextInt();
        System.out.println("Enter a loan amount.");
        double loanAmount = input.nextDouble();// this is A in the formula.

        //output the values inputted
        System.out.println("The yearly interest rate you entered was: " + yearlyInterestRate + ".");
        System.out.println("The number of loan years you entered were: " + loanYears + ".");
        System.out.println("The loan amount you entered was: " + loanAmount + ".");
        System.out.println("\n");

        // calculate monthly interest rate
        double monthlyRate = yearlyInterestRate / 12;
        System.out.println("Your monthly interest rate is " +monthlyRate+".");
        System.out.println("\n");

        // Solving for monthly loan payment
        // solve for monthly payment periods
        double monthlyPaymentPeriods = loanYears*12; // this is n in the formula.
        double periodicInterestRate = yearlyInterestRate/12;// this is r in the formula.
        // this is D in the formula
        double discountFactor = ((Math.pow(1+periodicInterestRate, monthlyPaymentPeriods))-1)/
                (periodicInterestRate*(Math.pow(1+periodicInterestRate, monthlyPaymentPeriods)));
        // this is P in the formula
        double monthlyLoanPayment = loanAmount / discountFactor;
        System.out.println("Your monthly loan payment is " +monthlyLoanPayment+".");
        System.out.println("\n");

        // calculate the total payment
        double totalPayment = monthlyLoanPayment*monthlyPaymentPeriods;
        System.out.println("Your total payment is " + totalPayment + ".");
        System.out.println("\n");

        //ending message
        System.out.println("Thanks for using Clifford's business loan payment calculator!");

    }
}
