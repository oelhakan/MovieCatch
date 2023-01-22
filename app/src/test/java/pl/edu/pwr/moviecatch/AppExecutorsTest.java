package pl.edu.pwr.moviecatch;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import java.util.concurrent.ScheduledExecutorService;

import org.junit.Test;

public class AppExecutorsTest {

    @Test
    public void testGetInstance_returnsAppExecutorsInstance() {
        // Call the method under test
        AppExecutors appExecutors = AppExecutors.getInstance();

        // Verify the results
        assertNotNull(appExecutors);
    }

    @Test
    public void testGetInstance_returnsSameInstance() {
        // Call the method under test
        AppExecutors appExecutors1 = AppExecutors.getInstance();
        AppExecutors appExecutors2 = AppExecutors.getInstance();

        // Verify the results
        assertSame(appExecutors1, appExecutors2);
    }

    @Test
    public void testNetworkIO_returnsScheduledExecutorService() {
        // Call the method under test
        ScheduledExecutorService networkIO = AppExecutors.getInstance().networkIO();

        // Verify the results
        assertNotNull(networkIO);
    }

}
