package pl.edu.pwr.moviecatch.response;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

import pl.edu.pwr.moviecatch.models.MovieModel;

public class MovieResponseTest {

    private MovieResponse movieResponse;

    @Before
    public void setUp(){
        movieResponse = new MovieResponse();
    }

    @Test
    public void shouldReturnMovie() {
        //given
        MovieModel mockResult = mock(MovieModel.class);
        movieResponse.movie = mockResult;
        //when
        MovieModel result = movieResponse.getMovie();
        //then
        assertEquals(result, mockResult);
    }

    @Test
    public void shouldReturnStringRepresentationOfMovie() {
        //given
        MovieModel movie = new MovieModel("The Godfather",
                "http://t1.gstatic.com/licensed-image?q=tbn:ANd9GcQUObbKfZg1xCfueoYQX7RZFIBoXQ6rAy0ToKzsuFs0X71FfObEFNfSUhRjRbFy1VEU",
                "01.01.1977",
                1,
                4.5F,
                "Movie Overview For The Godfather",
                "English");
        movieResponse.movie = movie;
        //when
        String result = movieResponse.toString();
        //then
        assertEquals(result, "MovieResponse{movie=MovieModel{title='The Godfather', poster_path='http://t1.gstatic.com/licensed-image?q=tbn:ANd9GcQUObbKfZg1xCfueoYQX7RZFIBoXQ6rAy0ToKzsuFs0X71FfObEFNfSUhRjRbFy1VEU', release_date='01.01.1977', movie_id=1, vote_average=4.5, movie_overview='Movie Overview For The Godfather', original_language='English'}}");
    }
}