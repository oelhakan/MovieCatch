package pl.edu.pwr.moviecatch.repositories;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import pl.edu.pwr.moviecatch.models.MovieModel;
import pl.edu.pwr.moviecatch.request.MovieApiClient;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MovieRepositoryTest {

    @Mock
    private MovieApiClient movieApiClient;

    private MovieRepository repository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        repository = new MovieRepository();
        repository.movieApiClient = movieApiClient;
    }

    @Test
    public void testGetMovies() {
        MutableLiveData<List<MovieModel>> testData = new MutableLiveData<>();
        when(movieApiClient.getMovies()).thenReturn(testData);

        Assert.assertEquals(testData, repository.getMovies());
    }

    @Test
    public void testSearchMovieApi() {
        String query = "test query";
        int pageNumber = 1;
        repository.serachMovieApi(query, pageNumber);

        verify(movieApiClient).searchMoviesApi(query, pageNumber);
    }

    @Test
    public void testSearchNextPage() {
        String query = "test query";
        int pageNumber = 1;
        repository.serachMovieApi(query, pageNumber);
        repository.searchNextPage();

        verify(movieApiClient).searchMoviesApi(query, pageNumber + 1);
    }

    @Test
    public void testGetPop() {
        MutableLiveData<List<MovieModel>> testData = new MutableLiveData<>();
        when(movieApiClient.getPop()).thenReturn(testData);

        Assert.assertEquals(testData, repository.getPop());
    }

    @Test
    public void testSearchMoviePop() {
        int pageNumber = 1;
        repository.serachMoviePop(pageNumber);

        verify(movieApiClient).searchMoviesPop(pageNumber);
    }
}