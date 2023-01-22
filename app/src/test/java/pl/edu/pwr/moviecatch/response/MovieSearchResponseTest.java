package pl.edu.pwr.moviecatch.response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import pl.edu.pwr.moviecatch.models.MovieModel;

public class MovieSearchResponseTest {

    private MovieSearchResponse movieSearchResponse;
    private List<MovieModel> movies;

    @Before
    public void setUp() {
        // Prepare test data
        movies = new ArrayList<>();
        MovieModel movie1 = new MovieModel("Title 1", "Path 1", "Release Date 1", 1, 4.5F, "Overview 1", "en");
        MovieModel movie2 = new MovieModel("Title 2", "Path 2", "Release Date 2", 2, 3.5F, "Overview 2", "en");
        movies.add(movie1);
        movies.add(movie2);
        movieSearchResponse = new MovieSearchResponse();
        movieSearchResponse.total_count = 2;
        movieSearchResponse.movies = movies;
    }

    @Test
    public void testGetTotal_count_returnsCorrectValue() {
        // Call the method under test
        int returnedTotalCount = movieSearchResponse.getTotal_count();

        // Verify the results
        assertEquals(2, returnedTotalCount);
    }

    @Test
    public void testGetMovies_returnsCorrectList() {
        // Call the method under test
        List<MovieModel> returnedMovies = movieSearchResponse.getMovies();

        // Verify the results
        assertSame(movies, returnedMovies);
    }

    @Test
    public void testSetMovies_updatesMoviesList() {
        // Prepare test data
        List<MovieModel> newMovies = new ArrayList<>();
        MovieModel movie1 = new MovieModel("Title 3", "Path 3", "Release Date 3", 3, 2.5F, "Overview 3", "en");
        MovieModel movie2 = new MovieModel("Title 4", "Path 4", "Release Date 4", 4, 1.5F, "Overview 4", "en");
        newMovies.add(movie1);
        newMovies.add(movie2);

        // Call the method under test
        movieSearchResponse.setMovies(newMovies);

        // Verify the results
        assertSame(newMovies, movieSearchResponse.movies);
    }

    @Test
    public void testToString_returnsCorrectString() {
        // Call the method under test
        String result = movieSearchResponse.toString();

        // Verify the results
        assertEquals("MovieSearchResponse{total_count=2, movies=[MovieModel{title='Title 1', poster_path='Path 1', release_date='Release Date 1', movie_id=1, vote_average=4.5, movie_overview='Overview 1', original_language='en'}, MovieModel{title='Title 2', poster_path='Path 2', release_date='Release Date 2', movie_id=2, vote_average=3.5, movie_overview='Overview 2', original_language='en'}]}", result);
    }
}
