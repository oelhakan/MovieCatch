package pl.edu.pwr.moviecatch.request;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import pl.edu.pwr.moviecatch.models.MovieModel;

public class MovieApiClientTest {

    private MovieApiClient movieApiClient;

    @Before
    public void setUp(){
        movieApiClient = MovieApiClient.getInstance();
    }

    @Test
    public void shouldReturnInstance() {
        assertThat(MovieApiClient.getInstance(), instanceOf(MovieApiClient.class));
    }

    @Test
    public void shouldGetMoviesFromApi() {
        //given
        ArrayList<MovieModel> movies = new ArrayList<>();
        movies.add(mock(MovieModel.class));
        MutableLiveData<List<MovieModel>> mockResult = new MutableLiveData<>(movies);
        movieApiClient.mMovies = mockResult;
        //when
        LiveData<List<MovieModel>> result = movieApiClient.getMovies();
        //then
        assertEquals(result, mockResult);
    }

    @Test
    public void shouldGetPopularMoviesFromApi() {
        //given
        ArrayList<MovieModel> movies = new ArrayList<>();
        movies.add(mock(MovieModel.class));
        MutableLiveData<List<MovieModel>> mockResult = new MutableLiveData<>(movies);
        movieApiClient.mMoviesPop = mockResult;
        //when
        LiveData<List<MovieModel>> result = movieApiClient.getPop();
        //then
        assertEquals(result, mockResult);
    }
}