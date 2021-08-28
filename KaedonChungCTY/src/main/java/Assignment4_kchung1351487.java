import java.text.DecimalFormat;
import java.util.Scanner;

public class Assignment4_kchung1351487 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //get input from user
        System.out.println("Please enter a product name.");
        String productName = input.next();
        System.out.println("How much " + productName + " do you want?");
        int PQ = input.nextInt();
        DecimalFormat decFormat = new DecimalFormat("$#,###.00");
        //outputs
        if (PQ > 10) {
            System.out.println("The number of units requested, " + PQ + ", is not currently in stock. Please try ordering your " + productName + " when supplies are in stock.");
        } else if (PQ==10) {
            System.out.println("We have 10 units of " + productName + " available in stock. Your total cost is " +decFormat.format (PQ * 7.00) + ".");
        } else {
            System.out.println("You have requested " + PQ + " units of " + productName + ". Your total cost is " + decFormat.format (7.00 * PQ) + ". There are " + (10 - PQ) + " units remaining in stock.");
        }
    }
}
