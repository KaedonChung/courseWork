/*
 * File Name: Assignment11_kchung13514876
 * Author: Kaedon Chung
 * Date: August 4th, 2021
 * Description: Track employee data including sick days, name, dates of termination and hire etc.
 */
import java.util.Scanner;
public class Assignment11_kchung1351487 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Set up variables.
        int employeeCreate = 0;
        String firstName = null;
        String lastName = null;
        String fullName = null;
        String review = null;
        String terminationDate = null;
        String hireDate = null;
        int enterOrContinue = 0;
        int vacationDaysLeft = 0;
        int vacationDaysCanceled = 0;
        int vacationDaysCanceledInput = 0;
        int terminateMonth = 0;
        int terminateDay = 0;
        int terminateYear = 0;
        int hireMonth = 0;
        int hireDay = 0;
        int hireYear = 0;
        int wantedVacationDays = 0;

        // While loop to create 3 employees.
        while (employeeCreate < 3) {
            EmployeeInfo employees = new EmployeeInfo();
            System.out.println("Please enter an employee first name.");
            firstName = input.next();
            employees.setFirstName(firstName);
            System.out.println("Please enter an employee last name.");
            lastName = input.next();
            employees.setLastName(lastName);
            fullName = employees.setFullName();
            review = employees.getLastAnnualReview();
            System.out.println("How many vacation days would you like to schedule?");
            wantedVacationDays = input.nextInt();
            employees.setScheduledVacationDay(wantedVacationDays);
            System.out.println("How many vacation days would you like to cancel?");
            vacationDaysCanceledInput = input.nextInt();
            employees.setVacationDaysCanceled(vacationDaysCanceledInput);
            vacationDaysLeft = employees.getVacationDaysLeft();
            Date employeeDates = new Date();
            System.out.println("Would you like to terminate an employee? Enter 1 to continue and 2 to terminate.");
            enterOrContinue = input.nextInt();
            if (enterOrContinue == 2){
                System.out.println("What month was the employee terminated?");
                terminateMonth = input.nextInt();
                System.out.println("What day was the employee terminated?");
                terminateDay = input.nextInt();
                System.out.println("What year was the employee terminated?");
                terminateYear = input.nextInt();
                terminationDate = employeeDates.setDate(terminateMonth,terminateDay,terminateYear);
            }
            System.out.println("What month was the employee hired?");
            hireMonth = input.nextInt();
            System.out.println("What day was the employee hired?");
            hireDay = input.nextInt();
            System.out.println("What year was the employee hired?");
            hireYear = input.nextInt();
            hireDate = employeeDates.setDate(hireMonth,hireDay,hireYear);
            // Prints out all employee data.
            System.out.println("The employee's name is: " + employees.getFullName() + ".");
            System.out.println("The employee's last annual review is: " + employees.getLastAnnualReview() + ".");
            System.out.println("Scheduled vacation days: " + employees.getVacationDaysScheduled());;
            System.out.println("Employee has " + (employees.getVacationDaysLeft()) + " vacation days left.");
            System.out.println("The employee's date of hire is " + hireDate + ".");
            System.out.println("The employee's date of termination is " + terminationDate + ".");
            // Resets termination date.
            terminationDate = null;

            employeeCreate++;
        }
    }
}
class EmployeeInfo {
    Scanner input = new Scanner(System.in);
    String firstName;
    String lastName;
    String fullName;
    // Assume that all employees meet expectations.
    String lastAnnualReview = "meets expectations";
    // Assume that all employees start with 10 vacation days per year.
    int vacationDaysLeft = 10;
    int vacationDaysScheduled;
    int vacationDaysCanceled;
    int daysWantedScheduled;
    int daysWantedCanceled;
    // Returns first name of employee.
    public String getFirstName() {
        return firstName;
    }
    // Takes in the user-entered first name and sets first name of employee to what the user entered.
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    // Takes in the user-entered last name and sets last name of employee to what the user entered.
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    // Returns the last name of the employee.
    public String getLastName() {
        return lastName;
    }
    // Combines first and last name; returns employee's full name.
    public String setFullName() {
        fullName = firstName + " " + lastName;
        return fullName;
    }
    // Returns employee's full name.
    public String getFullName(){return fullName;}
    // Returns employee's last annual review.
    public String getLastAnnualReview() {return lastAnnualReview;}
    // Returns the amount of vacation days the employee has left.
    public int getVacationDaysLeft() {
        return vacationDaysLeft;
    }
    // Returns the amount of vacation days the employee has scheduled.
    public int getVacationDaysScheduled() {
        return vacationDaysScheduled;
    }
    // Takes in the amount of days the employee wants to schedule as vacation days.
    // Adds and subtracts from vacation days scheduled and left respectively each time the loop iterates.
    // Logic to check if employee has vacation days left to schedule.
    public void setScheduledVacationDay(int daysWantedScheduled) {
        while (daysWantedScheduled > 0) {
            if (vacationDaysLeft >= 1) {
                vacationDaysScheduled++;
                vacationDaysLeft--;
            } else {
                System.out.println(" You have no vacations days left, could not schedule more vacation days. ");
                return;
            }
            daysWantedScheduled--;
        }
    }
    // Takes in the amount of days the employee wants to cancel from their vacation days.
    // Adds and subtracts from vacation days left and scheduled respectively each time the loop iterates.
    public void setVacationDaysCanceled(int daysWantedCanceled) {
        while (daysWantedCanceled > 0) {
            if (vacationDaysScheduled >= 1) {
                vacationDaysScheduled--;
                vacationDaysLeft++;
            } else {
                System.out.println(" You have no scheduled days left to cancel, could not schedule more vacation days. ");
                return;
            }
            daysWantedCanceled--;
        }
    }
    }


class Date {
    Scanner input = new Scanner(System.in);
    int month;
    int day;
    int year;
    String date;

    // Takes in month, day, and year.
    // Combines month, day, and year and out puts the resulting date.
    // Can be used to set a hire or termination date.
    public String setDate(int month, int day, int year) {
        date = month + "/" + day + "/" + year;
        return date;
    }
    // Returns date.
    public String getDate() {
        return date;
    }
}