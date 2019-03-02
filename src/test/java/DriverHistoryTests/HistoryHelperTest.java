package DriverHistoryTests;

import com.DriverHistory.Driver;
import com.DriverHistory.HistoryHelper;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.PrintWriter;

public class HistoryHelperTest {

    HistoryHelper histUtil = new HistoryHelper();


    @BeforeClass
    public void setUp() throws IOException{
        HistoryHelper histUtil = new HistoryHelper();
        histUtil.loadTripInfo();
    }

    @Test
    public void doesTripQualifyForReportingTest()throws IOException {
        histUtil.loadTripInfo();
        Driver testDriver = new Driver();
        testDriver.setFirstName("Dan");
        histUtil.doesTripQualifyForReporting(testDriver);
        double testSpeed = testDriver.getSpeed();
        Assert.assertEquals(47, testSpeed, .0001);

        testDriver.setFirstName("mary");
        histUtil.doesTripQualifyForReporting(testDriver);
        testSpeed = testDriver.getSpeed();
        Assert.assertEquals(0, testSpeed, .0001);
    }

    @Test
    public void determineSpeedTest() {
        double testDistance = 12;
        int testTime = 50;
        double expectedResult = 14;
        double testResult = histUtil.determineSpeed(testDistance, testTime);
        Assert.assertEquals(expectedResult, testResult, 0.0001);

    }

    @Test
    public void findSpeedAndFilterTripsTest() {
        double tooSlow = 2;
        double tooFast = 101;
        double justRight = 34;
        boolean testResultSlow = histUtil.findSpeedAndFilterTrips(tooSlow);
        boolean testResultFast = histUtil.findSpeedAndFilterTrips(tooFast);
        boolean testResultJustRight = histUtil.findSpeedAndFilterTrips(justRight);
        Assert.assertEquals(false, testResultSlow);
        Assert.assertEquals(true, testResultJustRight);
        Assert.assertEquals(false, testResultFast);
    }

    @Test
    public void createOutputTest() throws IOException{
        //will test that all methods work together cohesively and create appropriate data in output file
        Driver testDriver = new Driver();
        testDriver.setFirstName("Alex");
        histUtil.loadTripInfo();
        histUtil.findAndSetDriverDetails();
        histUtil.doesTripQualifyForReporting(testDriver);
        histUtil.createOutput();
    }

    @Test
    public void clearOutTestData()throws IOException{
        new PrintWriter("Trip_Downstream.txt").close();
    }

}
