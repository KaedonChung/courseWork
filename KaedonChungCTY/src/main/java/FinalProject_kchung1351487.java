import java.text.DecimalFormat;
import java.util.Scanner;


public class FinalProject_kchung1351487 {
    /*
     * File Name: FinalProject_kchung1351487
     * Author: Kaedon Chung
     * Date: August 19, 2021
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
            int rowCount = 0;
            int productNumber = 0;
            String name = null;
            Product[] products = new Product[productNumber];
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
                    product.addProduct(product);
                    System.out.println(product.getProducts());
                } else if (choice1 == 2) {
                    System.out.println("You've chosen to view the inventory.");
                    for (rowCount=0; rowCount<productNumber; rowCount++) {
                        System.out.println("You're viewing our " + products[rowCount].getName() + " product.");
                        System.out.println("We have " + products[rowCount].getStock() + " in stock " + products[rowCount].getName());
                    }
                } else if (choice1 == 3) {
                    System.out.println("You've chosen to modify a product.");


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

                } else if (choice2 == 2) {

                } else if (choice2 == 3) {

                } else {
                    System.out.println("Please enter valid inputs.");
                    //Customer has supplied invalid inputs. 1
                    System.exit(-1);
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    private int stock;
    private int price;
    private int productNumber = 0;
    private String name;
    private int amount;
    private Product[] products;

    public String toString() {
        return name;
    }


    public int getPrice() {
        return price;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void buyProduct(int amountWanted) {
        if (amount < amountWanted) {
            System.out.println("We don't have this product in stock");
            return;
        } else {
            stock--;
        }
        this.amount = amount - amountWanted;

    }

    public int removeProduct(int amountRemoved) {
        stock++;
        return amount - amountRemoved;
    }

    public int addStock(int amountWanted) {
        return stock + amountWanted;
    }

    public int removeStock(int amountRemoved) {
        return stock + amountRemoved;
    }

    public Product[] getProducts() {
        return products;
    }


    public void setProducts(Product[] team) {
        this.products = products;
    }

    public void addProduct(Product newProduct) {
        for (int arraySlot = 0; arraySlot < products.length; arraySlot++) {
            if (products[arraySlot] == null) {
                products[arraySlot] = newProduct;
                System.out.println("Product added.");
                break;
            }
        }
    }
    public Product() {
            this.name = null;
            this.stock = 0;
            this.price = 0;
            this.amount = 0;
            this.productNumber = 0;
            products = new Product[productNumber];
        }
    public Product(String name, int stock, int price){
            this.name = name;
            this.stock = stock;
            this.amount = amount;
            this.price = price;
            this.productNumber = productNumber;
            products = new Product[productNumber];
        }

}