/*
 * File Name: Assignment8_kchung13514876
 * Author: Kaedon Chung
 * Date: July 25th, 2021
 * Description: Enter and sort employees by salaried and hourly.
 */
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
public class Assignment8_kchung1351487 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Set variables.
        int rowCount = 0;
        int numOfEmployees = 0;
        int employeeID = 0;
        int arraySlot = 0;
        int numOfDigits = 0;
        int hourlyOrSalary = 0;
        // Welcome message.
        System.out.println("This program will sort Employees based on whether they are paid hourly or by salary.");
        System.out.println("How many employee ID's will you be entering today?");
        numOfEmployees = input.nextInt();
        // Checks if the user's input is valid.
        if (numOfEmployees < 10) {
            System.out.println("Please enter 10 or more employees.");
            System.exit(-1);
        }
        int numberOfEmployees1 = numOfEmployees;
        // Establish the array.
        int[] employeeList = new int[numOfEmployees];
        while (numOfEmployees > 0) {
            System.out.println("Please enter an employee ID.");
            employeeID = input.nextInt();
            numOfDigits = String.valueOf(employeeID).length();
            if (numOfDigits != 6) {
                System.out.println("Please enter a 6 digit employee ID.");
                continue;
            }
            employeeList[arraySlot] = employeeID;
            numOfEmployees--;
            arraySlot++;
        }
        Arrays.sort(employeeList);
        System.out.println("The Employee ID's you've entered in numerical order are " + Arrays.toString(employeeList) + ".");
        // Establish the two- dimensional array.
        // Uses length of the one- dimensional array.
        int[][] employeeListTwoDimensional = new int[employeeList.length][2];
        for(rowCount = 0; rowCount<employeeList.length; rowCount++) {
            // Prompts user to enter whether the employee is paid hourly or by salary.
            System.out.println("Please enter hourly or salary for employee ID "+ employeeList[rowCount] + " Press 1 for salaried and 2 for hourly.");
            hourlyOrSalary = input.nextInt();
            // Takes the one- dimensional array and inputs it into the two- dimensional array
            employeeListTwoDimensional[rowCount][0] = Array.getInt(employeeList,rowCount);
            // Takes input from the user and sets it into the two- dimensional array
            employeeListTwoDimensional[rowCount][1] = hourlyOrSalary;
        }
        // For loop that keeps running until rowCount is less than numberOfEmployees1.
        //Prints out individual lines of the array.
        System.out.println("The employees that are paid by salary are: ");
        for (rowCount=0; rowCount<numberOfEmployees1; rowCount++) {
            if (employeeListTwoDimensional[rowCount][1] == 1) {
                System.out.println(employeeListTwoDimensional[rowCount][0]);
            }
        }
        // For loop that keeps running until rowCount is less than numberOfEmployees1.
        //Prints out individual lines of the array.
        System.out.println("The employees that are paid hourly are: ");
        for (rowCount=0; rowCount<numberOfEmployees1; rowCount++) {
            if (employeeListTwoDimensional[rowCount][1] == 2) {
                System.out.println(employeeListTwoDimensional[rowCount][0]);
            }
        }
    }
}
