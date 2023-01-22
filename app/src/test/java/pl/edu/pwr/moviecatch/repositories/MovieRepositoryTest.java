package pl.edu.pwr.moviecatch.repositories;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import pl.edu.pwr.moviecatch.models.MovieModel;
import pl.edu.pwr.moviecatch.request.MovieApiClient;

public class MovieRepositoryTest {

    private MovieRepository movieRepository;

    @Before
    public void setUp(){
        movieRepository = MovieRepository.getInstance();
    }

    @Test
    public void shouldReturnInstance() {
        assertThat(MovieRepository.getInstance(), instanceOf(MovieRepository.class));
    }

    @Test
    public void shouldGetMoviesFromApi() {
        //given
        ArrayList<MovieModel> movies = new ArrayList<>();
        movies.add(mock(MovieModel.class));
        LiveData<List<MovieModel>> mockResult = new MutableLiveData<>(movies);
        movieRepository.movieApiClient = mock(MovieApiClient.class);
        when(movieRepository.movieApiClient.getMovies()).thenReturn(mockResult);
        //when
        LiveData<List<MovieModel>> result = movieRepository.getMovies();
        //then
        assertEquals(result, mockResult);
    }

    @Test
    public void shouldGetPopularMoviesFromApi() {
        //given
        ArrayList<MovieModel> movies = new ArrayList<>();
        movies.add(mock(MovieModel.class));
        LiveData<List<MovieModel>> mockResult = new MutableLiveData<>(movies);
        movieRepository.movieApiClient = mock(MovieApiClient.class);
        when(movieRepository.movieApiClient.getPop()).thenReturn(mockResult);
        //when
        LiveData<List<MovieModel>> result = movieRepository.getPop();
        //then
        assertEquals(result, mockResult);
    }
}