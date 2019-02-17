package com.DriverHistory;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class HistoryHelper implements History {

    private final static String DELIMITER = " ";
    public ArrayList<Trip> bulkTrip = new ArrayList<>();
    public ArrayList<Driver> bulkDrivers = new ArrayList<>();

    //read input file, store data appropriately
    public void loadTripInfo() throws FileNotFoundException {
        Scanner scanner = new Scanner(new BufferedReader(new FileReader("Trips.txt")));
        String currentLine;
        String[] currentTokens;
        String driverCommand = "Driver";
        String tripCommand = "Trip";

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            if(currentLine.startsWith(driverCommand)) {
            Driver currDriver = new Driver();
            currDriver.setFirstName(currentTokens[1]);
            bulkDrivers.add(currDriver);
            } else if(currentLine.startsWith(tripCommand)){
            Trip thisTrip = new Trip();
            thisTrip.setDriverIdentifier(currentTokens[1]);
            thisTrip.setStartTime(currentTokens[3]);
            thisTrip.setEndTime(currentTokens[4]);
            thisTrip.setMilesDriven(Double.parseDouble(currentTokens[5]));
            bulkTrip.add(thisTrip);
            }
        }
        scanner.close();
    }
    //filter out those going too slow or too fast

    //create output file
    public void createOutput() {

        }


    // round where needed
    @Override
    public int getTotalMilesDriven() {
        return 0;
    }

    // round where needed
    @Override
    public int getAverageSpeed() {
        return 0;
    }

    @Override
    public void getTotalDriverHistory() {

    }

}
