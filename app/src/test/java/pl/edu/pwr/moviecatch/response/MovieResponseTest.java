package pl.edu.pwr.moviecatch.response;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import pl.edu.pwr.moviecatch.models.MovieModel;

public class MovieResponseTest {

    private MovieResponse movieResponse;
    private MovieModel movie;

    @Before
    public void setUp() {
        // Prepare test data
        movie = new MovieModel("Title 1", "Path 1", "Release Date 1", 1, 4.5F, "Overview 1", "en");
        movieResponse = new MovieResponse();
        movieResponse.movie = movie;
    }

    @Test
    public void testGetMovie_returnsCorrectMovie() {
        // Call the method under test
        MovieModel returnedMovie = movieResponse.getMovie();

        // Verify the results
        assertEquals(movie, returnedMovie);
    }

    @Test
    public void testToString_returnsCorrectString() {
        // Call the method under test
        String result = movieResponse.toString();

        // Verify the results
        assertEquals("MovieResponse{movie=MovieModel{title='Title 1', poster_path='Path 1', release_date='Release Date 1', movie_id=1, vote_average=4.5, movie_overview='Overview 1', original_language='en'}}", result);
    }
}
