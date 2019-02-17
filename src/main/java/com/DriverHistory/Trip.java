package com.DriverHistory;

public class Trip {

    private int tripID;
    private String driverIdentifier;
    private double milesDriven;
    private double speed;
    private String startTime;
    private String endTime;
    private String timeTaken;

    public int getTripID(){
        return tripID;
    }

    public void setTripID(int tripID){
        this.tripID = tripID;
    }

    public void setDriverIdentifier(String driverIdentifier) {
        this.driverIdentifier = driverIdentifier;
    }

    public String getDriverIdentifier() {
        return driverIdentifier;
    }


    public double getMilesDriven() {
        return milesDriven;
    }

    public void setMilesDriven(double milesDriven) {
        this.milesDriven = milesDriven;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed){
        this.speed = speed;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(String timeTaken){
        this.timeTaken = timeTaken;
    }
}
