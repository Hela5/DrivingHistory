package com.DriverHistory;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class HistoryHelper {

    private final static String DELIMITER = " ";
    private ArrayList<Trip> bulkTrip = new ArrayList<>();
    private ArrayList<Driver> bulkDrivers = new ArrayList<>();

    //read input file, store data appropriately
    public void loadTripInfo() throws FileNotFoundException {
        Scanner scanner = new Scanner(new BufferedReader(new FileReader("TripsToRead.txt")));
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
            thisTrip.setStartTime(currentTokens[2]);
            thisTrip.setEndTime(currentTokens[3]);
            thisTrip.setMilesDriven(Double.valueOf(currentTokens[4]));
            bulkTrip.add(thisTrip);
            }
        }
        scanner.close();
    }

    //report trips and ensure they are sorted by miles driven
    public void createOutput() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter("Trip_Downstream.txt"));

        List<Driver> sortedDrivers = bulkDrivers.stream()
                .sorted(Comparator.comparing(Driver::getTotalMilesDriven).reversed())
                .collect(Collectors.toList());

        for(Driver driver : sortedDrivers){
            if (driver.getTotalMilesDriven() !=0 ){
                out.println(driver.getFirstName() + ": " + driver.getTotalMilesDriven() + " miles @ " + driver.getSpeed() + " mph");
            } else {
                out.println(driver.getFirstName() + ": 0 miles");
            }
            out.flush();
        }
        out.close();
    }

    //only set driver details when trips qualify
    public void findAndSetDriverDetails() {
        for(Driver currDriver : bulkDrivers) {
           doesTripQualifyForReporting(currDriver);
        }
    }

    //ensure all trips reported qualify and set Driver details accordingly
    public void doesTripQualifyForReporting(Driver thisDriver){
        double thisTripsMiles = 0;
        Date startTime;
        Date endTime;
        int totalTime = 0;
        double thisSpeed = 0;
        boolean qualify;
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        try {
            for (Trip trip : bulkTrip) {
                        if (trip.getDriverIdentifier().equalsIgnoreCase(thisDriver.getFirstName())) {
                            //find miles travelled
                            thisTripsMiles += trip.getMilesDriven();
                            thisTripsMiles = Math.round(thisTripsMiles);
                            //find time taken
                            String tempStart = trip.getStartTime();
                            String tempEnd = trip.getEndTime();
                            startTime = dateFormat.parse(tempStart);
                            endTime = dateFormat.parse(tempEnd);
                            totalTime += (endTime.getTime() - startTime.getTime()) / (60 * 1000);
                            //find speed and determine if trip is worth keeping
                            thisSpeed = determineSpeed(thisTripsMiles, totalTime);
                            qualify = findSpeedAndFilterTrips(thisSpeed);
                            trip.setQualifyToReport(qualify);
                        }
                        //set details on specific driver
                        if (trip.isQualifyToReport()) {
                            thisDriver.setTotalMilesDriven(thisTripsMiles);
                            thisDriver.setTotalTimeTaken(totalTime);
                            thisDriver.setSpeed(thisSpeed);
                        }
                    }
            } catch(ParseException pE){
            pE.getStackTrace();
        }
    }

    public double determineSpeed(double distance, int time) {
        double speed;
        speed = (distance/time) * 60;
        speed = Math.round(speed);
        return speed;
    }

    //filter out those going too slow or too fast
    public boolean findSpeedAndFilterTrips(double speed) {
        boolean doesThisTripQualify = true;
        if(speed < 5 || speed >100){
            doesThisTripQualify = false;
        }
        return doesThisTripQualify;
    }

}

