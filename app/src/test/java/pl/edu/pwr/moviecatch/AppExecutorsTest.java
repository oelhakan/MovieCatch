package pl.edu.pwr.moviecatch;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ScheduledExecutorService;


public class AppExecutorsTest {

    private AppExecutors appExecutors;

    @Before
    public void setUp(){
        appExecutors = AppExecutors.getInstance();
    }

    @Test
    public void shouldReturnInstance() {
        assertThat(AppExecutors.getInstance(), instanceOf(AppExecutors.class));
    }

    @Test
    public void shouldReturnNetworkIO() {
        assertThat(appExecutors.networkIO(), instanceOf(ScheduledExecutorService.class));
    }
}