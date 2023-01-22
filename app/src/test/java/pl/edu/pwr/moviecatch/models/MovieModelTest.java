package pl.edu.pwr.moviecatch.models;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class MovieModelTest {

    private MovieModel movieModel;

    @Before
    public void setUp(){
        movieModel = new MovieModel("The Godfather",
                "http://t1.gstatic.com/licensed-image?q=tbn:ANd9GcQUObbKfZg1xCfueoYQX7RZFIBoXQ6rAy0ToKzsuFs0X71FfObEFNfSUhRjRbFy1VEU",
                "01.01.1977",
                1,
                4.5F,
                "Movie Overview For The Godfather",
                "English");
    }

    @Test
    public void shouldReturnTitle() {
        //when
        String result = movieModel.getTitle();
        //then
        assertEquals(result, "The Godfather");
    }

    @Test
    public void shouldReturnPosterPath() {
        //when
        String result = movieModel.getPoster_path();
        //then
        assertEquals(result,"http://t1.gstatic.com/licensed-image?q=tbn:ANd9GcQUObbKfZg1xCfueoYQX7RZFIBoXQ6rAy0ToKzsuFs0X71FfObEFNfSUhRjRbFy1VEU");
    }

    @Test
    public void shouldReturnReleaseDate() {
        //when
        String result = movieModel.getRelease_date();
        //then
        assertEquals(result, "01.01.1977");
    }

    @Test
    public void shouldReturnMovieId() {
        //when
        int result = movieModel.getMovie_id();
        //then
        assertEquals(result, 1);
    }

    @Test
    public void shouldReturnVoteAverage() {
        //when
        double result = (double) movieModel.getVote_average();
        //then
        assertEquals(result, 4.5, 0);
    }

    @Test
    public void shouldReturnMovieOverview() {
        //when
        String result = movieModel.getMovie_overview();
        //then
        assertEquals(result, "Movie Overview For The Godfather");
    }

    @Test
    public void shouldReturnOriginalLanguage() {
        //when
        String result = movieModel.getOriginal_language();
        //then
        assertEquals(result, "English");
    }

    @Test
    public void shouldReturnStringRepresentationOfMovie() {
        //when
        String result = movieModel.toString();
        //then
        assertEquals(result, "MovieModel{title='The Godfather', poster_path='http://t1.gstatic.com/licensed-image?q=tbn:ANd9GcQUObbKfZg1xCfueoYQX7RZFIBoXQ6rAy0ToKzsuFs0X71FfObEFNfSUhRjRbFy1VEU', release_date='01.01.1977', movie_id=1, vote_average=4.5, movie_overview='Movie Overview For The Godfather', original_language='English'}");
    }
}