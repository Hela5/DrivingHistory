package DriverHistoryTests;

import com.DriverHistory.Driver;
import com.DriverHistory.HistoryUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class HistoryUtilTest {

    public HistoryUtil histUtilTest = mock(HistoryUtil.class);

    HistoryUtil histUtil = new HistoryUtil();


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void loadTripInfoTest() throws IOException {
        histUtilTest.loadTripInfo();
        verify(histUtilTest, atLeastOnce()).loadTripInfo();
    }

    @Test
    public void setDriverDetailsTest() {
        histUtilTest.findAndSetDriverDetails();
        verify(histUtilTest, atLeastOnce()).findAndSetDriverDetails();
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
        Assert.assertNull(testSpeed);
    }

    @Test
    public void createOutputTest() throws IOException{
        histUtilTest.createOutput();
        verify(histUtilTest, atLeastOnce()).createOutput();
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

}
