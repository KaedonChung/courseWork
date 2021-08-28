import java.util.Scanner;

public class Assignment3v2_kchung1251487 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // collect input
        System.out.println("Enter an amount invested.");//Amount invested (typically a percentage of current valuation equal to percent ownership given)
        double amountInvested = input.nextDouble();
        System.out.println("Enter a current company valuation in millions.");//Current company valuation (in millions)
        double currentCompanyValuation = input.nextDouble()*1000000;
        System.out.println("Enter the estimated rate of growth as a percentage between 60 & 100.");
        double estimatedRateOfGrowth = input.nextDouble()/100;//Estimated rate of growth as a percentage (use a value between 60-100%)
        System.out.println("Enter your percentage of the company given for investment.");
        double investorPercentage = input.nextDouble()/100;//Percentage of company given for investment (usually 20-40%)
        System.out.println("Enter a number of investment years between 5 & 10.");
        int investmentYears = input.nextInt();

        //output the values inputted
        System.out.println("Your amount invested was " + amountInvested + ".");
        System.out.println("Your current company valuation is " + currentCompanyValuation + ".");
        System.out.println("Your estimated rate of growth is " + estimatedRateOfGrowth + ".");
        System.out.println("Your percentage of company given for investment is " + investorPercentage + ".");
        System.out.println("Your number of investment years is " + investmentYears + ".");
        System.out.println("\n");

        // calculate the total future value of the company
        double companyFutureValue = currentCompanyValuation * (Math.pow(1 + estimatedRateOfGrowth, investmentYears));

        // solve for future value of investor's percentage
        double investorFutureValue = investorPercentage*companyFutureValue;

        // calculate the owner's future value
        double totalFutureValueOfOwner = companyFutureValue - (amountInvested + investorFutureValue);
        System.out.println("Your investment's total future value is $" +(String.format("%,.2f", totalFutureValueOfOwner)) + ".");
        System.out.println("\n");

        //ending message
        System.out.println("Thank you for using Nathaniel's future investment value calculator!");

    }
}

