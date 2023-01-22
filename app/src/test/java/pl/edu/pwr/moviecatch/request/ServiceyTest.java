package pl.edu.pwr.moviecatch.request;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

import org.junit.Test;

import pl.edu.pwr.moviecatch.utils.MovieApi;

public class ServiceyTest {

    @Test
    public void shouldReturnMovieApi() {
        assertThat(Servicey.getMovieApi(), instanceOf(MovieApi.class));
    }
}