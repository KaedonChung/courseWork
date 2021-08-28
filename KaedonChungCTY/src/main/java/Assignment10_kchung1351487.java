/*
 * File Name: Assignment10_kchung13514876
 * Author: Kaedon Chung
 * Date: July 29th, 2021
 * Description: Identify possible offices and rank their viability.
 */
import java.util.Scanner;
public class Assignment10_kchung1351487 {
    public static void main(String[] args) {
        // Set variables.
        boolean retry = false;
        int distanceFromCentral = 0;
        int locationAndDistanceLoop = 0;
        String location = null;
        System.out.println("Welcome! This program will help you determine four possible office locations and rank their viability.");
        System.out.println("For each input below, please first enter a location, (Chicago, New York, etc.) then enter how far away (in miles) the office locations are from the central office.");
        Scanner input = new Scanner(System.in);
        // Set up the arrays.
        StringBuilder[] locations = new StringBuilder[4];
        int[] distances = new int[4];
        for (locationAndDistanceLoop = 0; locationAndDistanceLoop < 4; locationAndDistanceLoop++) {
            StringBuilder locationStringBuilder = null;
            // Do while loop in order for user to only repeat entering distance; not location
            do{
            retry = false;
            System.out.println("Please enter a location with no spaces (Chicago, NewYork, etc.) ");
            location = input.next();
            locationStringBuilder = new StringBuilder(location);
            // Invoke the method.

                if (checkStringLength(locationStringBuilder, 15) == false) {
                    System.out.println("Please enter a valid string. The location you entered \"" + location + "\" was " + location.length() + " characters long. The strings entered must be no more than 15 characters long.");
                    retry = true;
                }
            } while(retry);
            do {
                retry = false;
                System.out.println("How far away from the central office is your location? (in miles)");
                distanceFromCentral = input.nextInt();
                if(distanceFromCentral < 100 || distanceFromCentral > 800){
                    System.out.println("Please enter a valid distance. Your location is either within 100 miles or farther than 800 miles from central. You will be prompted to enter your location and distance again.");
                    retry = true;
                }
            } while (retry);
            locations [locationAndDistanceLoop] = locationStringBuilder;
            distances [locationAndDistanceLoop] = distanceFromCentral;
        }
        System.out.println("The distance of the possible office locations from central are:");
        for (locationAndDistanceLoop=0; locationAndDistanceLoop<4; locationAndDistanceLoop++) {
                System.out.println(distances[locationAndDistanceLoop]);
        }
        System.out.println("The locations of the possible office locations are:");
        for (locationAndDistanceLoop=0; locationAndDistanceLoop<4; locationAndDistanceLoop++) {
            System.out.println(locations[locationAndDistanceLoop]);
        }
    }
// Method asks for the string to be measured and an integer for how long the string can be.
// Method outputs boolean depending on whether the string meets the length requirements.
    public static boolean checkStringLength(StringBuilder measuredString, int neededLength) {
        if(measuredString.length()>neededLength){
            return false;
        }
        return true;
    }
}
