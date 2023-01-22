package pl.edu.pwr.moviecatch.models;

import org.junit.Assert;
import org.junit.Test;

public class MovieModelTest {

    @Test
    public void testGetTitle() {
        String expectedTitle = "Example Title";
        MovieModel movie = new MovieModel(expectedTitle, "example_path", "2022-01-01", 1, 8.5f, "Example overview", "en");
        String actualTitle = movie.getTitle();

        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Test
    public void testGetPosterPath() {
        String expectedPosterPath = "example_path";
        MovieModel movie = new MovieModel("Example Title", expectedPosterPath, "2022-01-01", 1, 8.5f, "Example overview", "en");
        String actualPosterPath = movie.getPoster_path();

        Assert.assertEquals(expectedPosterPath, actualPosterPath);
    }

    @Test
    public void testGetReleaseDate() {
        String expectedReleaseDate = "2022-01-01";
        MovieModel movie = new MovieModel("Example Title", "example_path", expectedReleaseDate, 1, 8.5f, "Example overview", "en");
        String actualReleaseDate = movie.getRelease_date();

        Assert.assertEquals(expectedReleaseDate, actualReleaseDate);
    }

    @Test
    public void testGetVoteAverage() {
        float expectedVoteAverage = 8.5f;
        MovieModel movie = new MovieModel("Example Title", "example_path", "2022-01-01", 1, expectedVoteAverage, "Example overview", "en");
        float actualVoteAverage = movie.getVote_average();

        Assert.assertEquals(expectedVoteAverage, actualVoteAverage, 0);
    }

    @Test
    public void testGetMovieId() {
        int expectedMovieId = 1;
        MovieModel movie = new MovieModel("Example Title", "example_path", "2022-01-01", expectedMovieId, 8.5f, "Example overview", "en");
        int actualMovieId = movie.getMovie_id();

        Assert.assertEquals(expectedMovieId, actualMovieId);
    }

    @Test
    public void testGetMovieOverview() {
        String expectedOverview = "Example overview";
        MovieModel movie = new MovieModel("Example Title", "example_path", "2022-01-01", 1, 8.5f, expectedOverview, "en");
        String actualOverview = movie.getMovie_overview();

        Assert.assertEquals(expectedOverview, actualOverview);
    }

    @Test
    public void testGetOriginalLanguage() {
        String expectedLanguage = "en";
        MovieModel movie = new MovieModel("Example Title", "example_path", "2022-01-01", 1, 8.5f, "Example overview", expectedLanguage);
        String actualLanguage = movie.getOriginal_language();

        Assert.assertEquals(expectedLanguage, actualLanguage);
    }
}
