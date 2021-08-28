/*
 * File Name: Assignment12_kchung13514876
 * Author: Kaedon Chung
 * Date: August 14th, 2021
 * Description: Add on to unit 10's project. Put in employee, manager, and branch classes as well as some administrative actions.
 */
import java.util.Scanner;
public class Assignment12_kchung1351487 {
    public static void main(String[] args) {
        // Set variables
        int branchID = 0;
        int assignOrRemove = 0;
        Scanner input = new Scanner(System.in);
        Employee employeeInfo = new Employee();
        Manager managerInfo = new Manager();
        // Initialized Branches
        Branch[] branches = new Branch[3];
        branches[0] = new Branch(1000,
                "Baltimore",
                "29237, 4th Street, Baltimore, MD");
        branches[1] = new Branch(2000,
                "Boston",
                "73325, 17th Street, Boston, MA");
        branches[2] = new Branch(3000,
                "New York",
                "82536, 9th Street, New York, NY");
        int managerID = 0;
        int slot = 0;
        int menuChoice = 0;
        boolean exitProgram = false;
        int employeeID = 0;
        Branch selectedBranch = null;
        while (exitProgram == false) {
            // Prompts a user to choose betweeen admin, reports, and exiting
            System.out.println("To enter administrative actions, enter 1. To enter reporting actions, enter 2. If you want to exit, enter 3.");
            menuChoice = input.nextInt();
            if (menuChoice == 1) {
                selectedBranch = selectBranch(branches);
                // Lets the user choose between assigning a manager, assigning an employee, and removing an employee.
                System.out.println("Please enter 1 to assign a manager to a branch, " +
                        "2 to assign an employee to the branch team, " +
                        "or 3 to remove an employee from the branch team.");
                assignOrRemove = input.nextInt();
                // Assign manager to branch.
                if (assignOrRemove == 1) {

                    String first1 = createFirstName();
                    String last1 = createLastName();
                    Manager manager1 = new Manager(first1,
                            last1,
                            first1 + " " + last1,
                            branchID);
                    selectedBranch.setSupervisor(manager1);
                    // Conformation that the manager has been added to the branch.
                    System.out.println("Manager has been added to the branch");

                    // Assign employee to branch.
                } else if (assignOrRemove == 2) {
                    System.out.println("Please enter an employee ID. (Must be unique)");
                    employeeID = input.nextInt();
                    String firstName = createFirstName();
                    String lastName = createLastName();
                    Employee employee = new Employee(firstName,
                            lastName,
                            firstName + " " + lastName, employeeID);
                    selectedBranch.addToTeam(employee);
                    // Remove employee from branch.
                } else if (assignOrRemove == 3) {
                    System.out.println("Please enter the employee you want to remove's ID.");
                    employeeID = input.nextInt();
                    selectedBranch.removeFromTeam(employeeID);
                }
            } else if (menuChoice == 2) {
                // Lets user choose between branch and cumulative report.
                System.out.println("Enter 1 for a branch report, or 2 for a cumulative report.");
                int branchOrCumulative = input.nextInt();
                if (branchOrCumulative == 1) {
                    // Branch report.
                    // LET USER SELECT BRANCH
                    selectedBranch = selectBranch(branches);
                    selectedBranch.displayBranchInfo();
                } else if (branchOrCumulative == 2) {
                    //Cumulative report.
                    System.out.println("There are " + branches.length + " managers in our company.");
                    System.out.println("There are " + Employee.totalNumberOfEmployees + " employees in our company.");
                    for (slot = 0; slot < branches.length; slot++) {
                        branches[slot].displayBranchInfo();
                    }
                } else {
                    // User has entered an invalid input.
                    System.out.println("Please enter a valid option.");
                    System.exit(-2);
                }
            }else if (menuChoice == 3){
                // User has chosen to exit the program.
                System.out.println("Thank you for using our program. Come again!");
                exitProgram = true;
            } else {
                System.out.println("Please try again and enter a valid action");
            }


        }
    }
    // Method takes in the Branch array called branches.
    // It then asks the user to choose between 3 branch ID's
    // After checking for mistakes, it outputs the part of the array corresponding with the ID entered.
    public static Branch selectBranch(Branch[] branches){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a branch ID. Choose from 1000(Baltimore), " +
                "2000(Boston), and 3000(New York)");
        int branchID = input.nextInt();
        if (branchID != 1000 && branchID != 2000 && branchID != 3000) {
            System.out.println("Please enter a valid branch ID.");
            System.exit(-3);
        }
        for (int slot = 0; slot < branches.length; slot++) {
            if (branchID == branches[slot].getBranchID()) {
                return branches[slot];
            }
        }
        return null;
    }
    // Method generates random integer between 0 and 15.
    // The Method then takes the random number generated and
    // sets the first name to the corresponding slot in the array
    public static String createFirstName() {
        String[] firstNames = {"Raphael",
                "Bob",
                "Pedro",
                "Joe",
                "Jennifer",
                "Samuel",
                "Jasmine",
                "Natalie",
                "Elliot",
                "Amelie",
                "Ethan",
                "Mia",
                "Dakota",
                "Allie",
                "Elsie"};
        int randomNumberFirst = (int)(Math.random() * (firstNames.length));
        String first = firstNames[randomNumberFirst];
        return first;
    }
    // Method generates random integer between 0 and 15.
    // The Method then takes the random number generated and
    // sets the last name to the corresponding slot in the array
    public static String createLastName(){
        String[] lastNames = {"Jones",
                "Manor",
                "Simons",
                "Smith",
                "Wright",
                "Johnson",
                "Reyes",
                "Robinson",
                "Ross",
                "Livingston",
                "Jarvis",
                "Anderson",
                "Richardson",
                "Caroll",
                "Steiner"};
        int randomNumberLast = (int)(Math.random() * (lastNames.length));
        String last = lastNames[randomNumberLast];
        return last;
    }

}
class Employee{
    String firstName;
    String lastName;
    String fullName;
    int employeeID = 0;
    // Assume all employees met expectations.
    String employeeReport = "employee met expectations";
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
    public String employeeReports(){return employeeReport;}



    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
    public static int totalNumberOfEmployees = 0;
    public Employee (){
        firstName = null;
        lastName = null;
        fullName = null;
        employeeID = 0;
    }
    public Employee (String firstName, String lastName, String fullName, int employeeID){
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = fullName;
        this.employeeID = employeeID;
    }
}
class Manager {
    private String firstName;
    private String lastName;
    private String fullName;
    private int branchID;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getBranchID() {
        return branchID;
    }

    public void setBranchID(int branchID) {
        this.branchID = branchID;
    }
    public Manager(){
        firstName = null;
        lastName = null;
        fullName = null;
        branchID = 9999;
    }
    public Manager(String firstName, String lastName, String fullName, int branchID){
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = fullName;
        this.branchID = branchID;
    }
}
class Branch {
    private int branchID;
    private String locationName;
    private String address;
    private Manager supervisor;
    private Employee[] team;
    private int employeesInBranch;

    public int getBranchID() {
        return branchID;
    }

    public String getLocationName() {
        return locationName;
    }

    public String getAddress() {
        return address;
    }

    public Manager getSupervisor() {
        return supervisor;
    }

    public Employee[] getTeam() {
        return team;
    }

    public void setBranchID(int branchID) {
        this.branchID = branchID;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
    // Takes in the location and sets locationName to locationName in the class
    public void setAddress(String address) {
        this.address = address;
    }
    // Takes in a Manager type called supervisor and sets supervisor to supervisor in the class.
    public void setSupervisor(Manager supervisor) {
        this.supervisor = supervisor;
        this.supervisor.setBranchID(branchID);
    }
    // Sets team to array team.
    public void setTeam(Employee[] team) {
        this.team = team;
    }
    // Takes in the employee you want to add amd finds an empty spot to input the employee into.
    public void addToTeam(Employee newEmployee){
        //ADD EMPLOYEE - ADD TO NUMBER OF EMPLOYEES
        for(int arraySlot = 0; arraySlot < team.length; arraySlot++ ){
            if(team[arraySlot] == null){
                team[arraySlot] = newEmployee;
                System.out.println("Employee added.");
                Employee.totalNumberOfEmployees++;
                employeesInBranch++;
                break;
            }
        }
    }
    // Takes in a user-entered employee ID and sets the slot taken up by the employee to null, therefore removing it.
    public void removeFromTeam(int ID){
        // Loop checks if the slot you are checking is smaller than the length of the "team" array.
        for(int arraySlot = 0; arraySlot < team.length; arraySlot++) {
            // Loop checks if the slot you are checking doesn't equal null
            if (team[arraySlot] != null) {
                // Loop Checks if the ID entered by the user equals the ID required.
                if (team[arraySlot].getEmployeeID() == ID){
                    team[arraySlot] = null;
                    System.out.println("Employee number " + ID + " has been Removed.");
                    Employee.totalNumberOfEmployees--;
                    employeesInBranch--;

                }
            }
        }
    }
    public void displayBranchInfo(){
        int rowCount = 0;
        if(supervisor == null){
            System.out.println("Our location in " + getLocationName() + " is supervised by no one.");
        }else{
            System.out.println("Our location in " + getLocationName() + " is supervised by " + getSupervisor() + ".");
        }
        System.out.println("Branch number " + getBranchID() + " has " + employeesInBranch + " employees in their team.");
        System.out.println("Those employees are:");
        for (rowCount=0; rowCount<employeesInBranch; rowCount++) {
            System.out.println(team[rowCount].getEmployeeID()+ " " + team[rowCount].fullName);
        }
    }
    public Branch(){
        this.branchID = 0;
        this.locationName = null;
        this.address = null;
        this.supervisor = null;
        team = new Employee[4];
        this.employeesInBranch = 0;
    }
    public Branch (int branchID, String locationName, String address){
        this.branchID = branchID;
        this.locationName = locationName;
        this.address = address;
        team = new Employee[4];
        employeesInBranch = 0;
    }

}