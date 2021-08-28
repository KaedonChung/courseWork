/*
 * File Name: Assignment13_kchung1351487
 * Author: Kaedon Chung
 * Date: August 27, 2021
 * Description: Print out company logo
 */

public class Assignment13_kchung1351487 {
    public static void main(String[] args) {
        System.out.println("-------------------------------------------------------");
        System.out.println("|  ━━━━━━  │    │   ━━━━━━   ━━━━━━  ━━━━━━   ━━━━━━  |");
        System.out.println("|  │       │    │   │       │        │        │       |");
        System.out.println("|  │       │━━━━│   │━━━━   │━━━━    ━━━━━━   │━━━━   |");
        System.out.println("|  │       │    │   │       │             │   │       |");
        System.out.println("|  ━━━━━━  │    │   ━━━━━━   ━━━━━━  ━━━━━━   ━━━━━━  |");
        System.out.println("-------------------------------------------------------");
        double cheesePrice = 207.23;
        int cheeseAmmount = 4;
        String cheeseName = " Swiss";
        System.out.println("Thanks for visiting Pierre's Fine Wine and Aged Cheeses! We are preparing your order of:");
        System.out.println(cheeseAmmount + cheeseName + " cheese plates.");
        System.out.println("Your total price is $" + cheesePrice);
    }
}
