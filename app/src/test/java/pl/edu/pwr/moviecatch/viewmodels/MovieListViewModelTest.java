package pl.edu.pwr.moviecatch.viewmodels;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import androidx.lifecycle.LiveData;

import org.junit.Before;
import org.junit.Test;

import pl.edu.pwr.moviecatch.models.MovieModel;
import pl.edu.pwr.moviecatch.repositories.MovieRepository;

import java.util.ArrayList;
import java.util.List;

public class MovieListViewModelTest {

    private MovieListViewModel movieListViewModel;
    private MovieRepository movieRepository;
    private LiveData<List<MovieModel>> moviesLiveData;
    private LiveData<List<MovieModel>> popLiveData;
    private List<MovieModel> movies;

    @Before
    public void setUp() {
        // Prepare test data
        movies = new ArrayList<>();
        MovieModel movie1 = new MovieModel("Title 1", "Path 1", "Release Date 1", 1, 4.5F, "Overview 1", "en");
        MovieModel movie2 = new MovieModel("Title 2", "Path 2", "Release Date 2", 2, 3.5F, "Overview 2", "en");
        movies.add(movie1);
        movies.add(movie2);
        moviesLiveData = mock(LiveData.class);
        popLiveData = mock(LiveData.class);
        when(moviesLiveData.getValue()).thenReturn(movies);
        movieRepository = mock(MovieRepository.class);
        when(movieRepository.getMovies()).thenReturn(moviesLiveData);
        when(movieRepository.getPop()).thenReturn(popLiveData);
        movieListViewModel = new MovieListViewModel();
        movieListViewModel.movieRepository = movieRepository;
    }

    @Test
    public void testGetMovies_returnsMoviesLiveData() {
        // Call the method under test
        LiveData<List<MovieModel>> returnedMoviesLiveData = movieListViewModel.getMovies();

        // Verify the results
        assertSame(moviesLiveData, returnedMoviesLiveData);
    }

    @Test
    public void testGetPop_returnsPopLiveData() {
        // Call the method under test
        LiveData<List<MovieModel>> returnedPopLiveData = movieListViewModel.getPop();

        // Verify the results
        assertSame(popLiveData, returnedPopLiveData);
    }

    @Test
    public void testSearchMovieApi_callsSearchMovieApiOnMovieRepository() {
        // Prepare test data
        String query = "Test Query";
        int pageNumber = 1;

        // Call the method under test
        movieListViewModel.searchMovieApi(query, pageNumber);

        // Verify the results
        verify(movieRepository).serachMovieApi(query, pageNumber);
    }

    @Test
    public void testSearchMoviePop_callsSearchMoviePopOnMovieRepository() {
        // Prepare test data
        int pageNumber = 1;

        // Call the method under test
        movieListViewModel.searchMoviePop(pageNumber);

        // Verify the results
        verify(movieRepository).serachMoviePop(pageNumber);
    }

    @Test
    public void testSearchNextPage_callsSearchNextPageOnMovieRepository() {
        // Call the method under test
        movieListViewModel.searchNextpage();

        // Verify the results
        verify(movieRepository).searchNextPage();
    }
}