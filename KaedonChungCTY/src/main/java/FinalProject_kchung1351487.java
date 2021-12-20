import java.text.DecimalFormat;
import java.util.Scanner;


public class FinalProject_kchung1351487 {
    /*
     * File Name: FinalProject_kchung1351487
     * Author: Kaedon Chung
     * Date: December 20, 2021
     * Description: Create Business Management System.
     */


        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            // Set up variables.
            int choice = 0;
            int choice1 = 0;
            int choice2 = 0;
            int menuLoop = 0;
            int stock = 0;
            int price = 0;
            int productBought = 0;
            int amountBought = 0;
            int productReturned = 0;
            int amountReturned = 0;
            int modifiedProduct;
            int modifiedField;
            String name = null;
            Inventory productInventory = new Inventory(10);

            // Set up money format.
            DecimalFormat decFormat = new DecimalFormat("$#,###.00");
            while(menuLoop == 0){
            System.out.println("Enter 1 to manage inventory, 2 to manage sales actions, or 3 to exit.");
            choice = input.nextInt();
            if(choice == 1) {
                System.out.println("Enter 1 for adding a product, 2 for viewing you inventory or 3 to modify a product.");
                choice1 = input.nextInt();
                if (choice1 == 1) {
                    System.out.println("You've chosen to add a product");
                    System.out.println("What is the product's name?");
                    name = input.next();
                    System.out.println("How much of this product in stock?");
                    stock = input.nextInt();
                    System.out.println("What is the product's price?");
                    price = input.nextInt();
                    Product product = new Product(name, stock, price);
                    productInventory.addProduct(product);
                } else if (choice1 == 2) {
                    System.out.println("You've chosen to view the inventory.");
                    productInventory.printInventory();
                } else if (choice1 == 3) {
                    System.out.println("You've chosen to modify a product.");
                    productInventory.printInventory();
                    System.out.println("Please enter a product number from the list above");
                    modifiedProduct = input.nextInt();
                    System.out.println("Which field would you like to edit? Enter 1 for name, 2 for stock, or 3 for price.");
                    modifiedField = input.nextInt();
                    productInventory.modifyProduct(modifiedProduct, modifiedField);
                } else {
                    System.out.println("Please enter valid inputs.");
                    //Customer has supplied invalid inputs. 1
                    System.exit(-1);
                }
            }
            if (choice == 2) {
                System.out.println("Enter 1 for viewing products, 2 for buying products or 3 returning a product.");
                choice2 = input.nextInt();
                if (choice2 == 1) {
                    System.out.println("You've chosen to view products. ");
                    productInventory.printInventory();
                } else if (choice2 == 2) {
                    System.out.println("You've chosen to buy products.");
                    productInventory.printInventory();
                    System.out.println("Please enter a product number from the options above.");
                    productBought = input.nextInt();
                    System.out.println("How much of this product do you want to buy?");
                    amountBought = input.nextInt();
                    productInventory.buyProduct(productBought, amountBought);
                } else if (choice2 == 3) {
                    System.out.println("You've chosen to return a product.");
                    productInventory.printInventory();
                    System.out.println("Please enter a product number from the options above.");
                    productReturned = input.nextInt();
                    System.out.println("How much of this product do you want to return?");
                    amountReturned = input.nextInt();
                    productInventory.returnProduct(productReturned, amountReturned);
                } else {
                    System.out.println("Please enter valid inputs.");
                    //Customer has supplied invalid inputs. 1
                    System.exit(-2);
                }
            }

            if (choice == 3){
                menuLoop++;
            }
            }

        }
    }
class Product {
    Scanner input = new Scanner(System.in);
    private int price;
    private int productNumber = 0;
    private String name;
    private int stock;


    public String toString() {
        return name;
    }


    public int getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product() {
            this.name = null;
            this.stock = 0;
            this.price = 0;
            this.productNumber = 0;
    }
    public Product(String name, int stock, int price){
            this.name = name;
            this.stock = stock;
            this.price = price;
    }
    public void printProduct() {
        System.out.println("Name: " + getName() + "\nStock: "
                + getStock() + "\nPrice: " + getPrice());
        System.out.println();
    }


}
class Inventory{
    private Product[] products = null;
    //keep track of current number of products.
    private int productCount;
    private int inventoryStock;
    public Inventory(int maxProducts){
        products = new Product[maxProducts];
        this.inventoryStock = 0;
        this.productCount = 0;
    }
    public int getInventoryStock() {
        return inventoryStock;
    }

    public void setInventoryStock(int inventoryStock) {
        this.inventoryStock = inventoryStock;
    }


    public void buyProduct(int productWanted, int amountWanted) {
        if(productCount >= productWanted && productWanted >= 0 && inventoryStock >= amountWanted){
            inventoryStock = inventoryStock - amountWanted;
            products[productWanted].setStock(products[productWanted].getStock() - amountWanted);
            //confirmation message
            System.out.println("You've bought " + amountWanted + " units of " + products[productWanted].getName() + ".");
            System.out.println();
        }
    }

    public void returnProduct(int productNotWanted, int amountNotWanted) {
       if(productNotWanted >= 0 && productCount >= productNotWanted){
           System.out.println("You've returned " + amountNotWanted + " units of " + products[productNotWanted].getName() + ".");
           inventoryStock = inventoryStock + amountNotWanted;
           products[productNotWanted].setStock(products[productNotWanted].getStock() + amountNotWanted);
       }
    }

    public int addStock(int amountWanted) {
        return inventoryStock + amountWanted;
    }

    public int removeStock(int amountRemoved) {
        return inventoryStock + amountRemoved;
    }

    public Product[] getProducts() {
        return products;
    }


    public void setProducts(Product[] team) {
        this.products = products;
    }

    public void addProduct(Product newProduct) {
        products[productCount] = newProduct;
        productCount++;
        inventoryStock = inventoryStock + newProduct.getStock();
    }
    public void printInventory() {
        for (int rowCount=0; rowCount<productCount; rowCount++) {
            System.out.println("Index Number: " + rowCount);
            products[rowCount].printProduct();
        }
    }
    public void modifyProduct(int editedProduct, int editedField) {
        Scanner input = new Scanner(System.in);
        String newName = null;
        int newStock;
        int newPrice;
        if(editedField == 1){
            System.out.println("What would you like to change this product's name to?");
            newName = input.next();
            products[editedProduct].setName(newName);
        }else if(editedField == 2){
            System.out.println("What would you like to change this product's stock to?");
            newStock = input.nextInt();
            products[editedProduct].setStock(newStock);
        }else if(editedField == 3){
            System.out.println("What would you like to change this product's Price to?");
            newPrice = input.nextInt();
            products[editedProduct].setPrice(newPrice);
        }else{
            System.exit(-3);
        }
        System.out.println("New product info:");
        products[editedProduct].printProduct();
    }
}
