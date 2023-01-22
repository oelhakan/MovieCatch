package pl.edu.pwr.moviecatch.viewmodels;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import pl.edu.pwr.moviecatch.models.MovieModel;
import pl.edu.pwr.moviecatch.repositories.MovieRepository;

public class MovieListViewModelTest {

    private MovieListViewModel movieListViewModel;

    @Before
    public void setUp(){
        movieListViewModel = new MovieListViewModel();
    }

    @Test
    public void shouldGetMoviesFromApi() {
        //given
        ArrayList<MovieModel> movies = new ArrayList<>();
        movies.add(mock(MovieModel.class));
        LiveData<List<MovieModel>> mockResult = new MutableLiveData<>(movies);
        movieListViewModel.movieRepository = mock(MovieRepository.class);
        when(movieListViewModel.movieRepository.getMovies()).thenReturn(mockResult);
        //when
        LiveData<List<MovieModel>> result = movieListViewModel.getMovies();
        //then
        assertEquals(result, mockResult);
    }

    @Test
    public void shouldGetPopularMoviesFromApi() {
        //given
        ArrayList<MovieModel> movies = new ArrayList<>();
        movies.add(mock(MovieModel.class));
        LiveData<List<MovieModel>> mockResult = new MutableLiveData<>(movies);
        movieListViewModel.movieRepository = mock(MovieRepository.class);
        when(movieListViewModel.movieRepository.getPop()).thenReturn(mockResult);
        //when
        LiveData<List<MovieModel>> result = movieListViewModel.getPop();
        //then
        assertEquals(result, mockResult);
    }
}