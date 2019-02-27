package com.DriverHistory;

public class Trip {

    private String driverIdentifier;
    private double milesDriven;
    private String startTime;
    private String endTime;
    private boolean qualifyToReport;

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

    public boolean isQualifyToReport() {
        return qualifyToReport;
    }

    public void setQualifyToReport(boolean qualifyToReport) {
        this.qualifyToReport = qualifyToReport;
    }
}
