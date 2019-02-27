package com.DriverHistory;

public class Driver  {

    private String firstName;
    private String lastName;
    private double totalMilesDriven;
    private int totalTimeTaken;
    private double speed;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getTotalMilesDriven() {
        return totalMilesDriven;
    }

    public void setTotalMilesDriven(double totalMilesDriven) {
        this.totalMilesDriven = totalMilesDriven;
    }

    public int getTotalTimeTaken() {
        return totalTimeTaken;
    }

    public void setTotalTimeTaken(int totalTimeTaken) {
        this.totalTimeTaken = totalTimeTaken;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

}
