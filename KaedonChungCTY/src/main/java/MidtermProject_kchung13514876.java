/*
 * File Name: MidtermProject_kchung13514876
 * Author: Kaedon Chung
 * Date: July 16th, 2021
 * Description: Collect user's payment method
 */
import java.util.Scanner;
public class MidtermProject_kchung13514876 {
    public static void main(String[] args) {
    // Set variables.

    // Main menu options.
    String inventoryActions = "enter inventory actions";
    String salesActions = "enter sales actions";
    String exit = "exit";
    // Inventory action options.
    String addProduct = "add a product";
    String viewInventory = "view inventory";
    // Sales action options.
    String viewProducts = "view products";
    String purchaseProducts = "purchase products";
    // Return to main menu.
    String goToMenu = "go back to the main menu";
    // Variable to store method "Choices" output.
    int choiceMenu = 0;
    int choiceInventory = 0;
    int choiceSales = 0;
    //Variable for while loop
    int menuOrExit = 0;
        while(menuOrExit == 0) {
            choiceMenu = Choices(inventoryActions, salesActions, exit);
            if (choiceMenu == 1) {
                choiceInventory = Choices(addProduct, viewInventory, goToMenu);
                if (choiceInventory == 1) {
                    // Place holder text.
                    System.out.println("You've chosen to add a product.");
                    menuOrExit++;
                } else if (choiceInventory == 2) {
                    // Place holder text.
                    System.out.println("You've chosen to view the inventory.");
                    menuOrExit++;
                } else {
                    System.out.println("You've chosen to return to the main menu.");
                }
            } else if (choiceMenu == 2) {
                choiceInventory = Choices(viewProducts, purchaseProducts, goToMenu);
                if (choiceSales == 1) {
                    // Place holder text.
                    System.out.println("You've chosen to view products.");
                    menuOrExit++;
                } else if (choiceInventory == 2) {
                    // Place holder text.
                    System.out.println("You've chosen to purchase products.");
                    menuOrExit++;
                } else {
                    System.out.println("You've chosen to return to the main menu.");
                }


            } else {
                System.out.println("Thanks for using our program, see you soon!");
                System.exit(-1);
            }
        }

    }
// Method takes strings, which it sets to options for the user.
// It then outputs an integer corresponding to what was inputted by the user.
// The simple method can be re-used multiple times as both the submenus and menus ask for user input; therefore requiring less code.
public static int Choices(String firstOption, String secondOption, String thirdOption){
    Scanner input = new Scanner(System.in);
    int choice = 0;
    System.out.println("Choose an option from the following. Enter 1 to " + firstOption + ", 2 to " + secondOption + " , or 3 to " + thirdOption + ".");
    choice = input.nextInt();
    return choice;
    }
}


