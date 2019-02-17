package DriverHistoryTests;

import com.DriverHistory.Driver;
import com.DriverHistory.HistoryHelper;
import com.DriverHistory.Trip;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.Assert;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class HistoryHelperTest {

    public Driver driverMock = mock(Driver.class);
    public Trip tripMock = mock(Trip.class);
    public HistoryHelper histHelper = mock(HistoryHelper.class);


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void loadTripInfoTest() throws IOException {
        histHelper.loadTripInfo();
        verify(histHelper, atLeastOnce()).loadTripInfo();
    }

}
