package pl.edu.pwr.moviecatch.response;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import pl.edu.pwr.moviecatch.models.MovieModel;

public class MovieSearchResponseTest {

    private MovieSearchResponse movieSearchResponse;

    @Before
    public void setUp(){
        movieSearchResponse = new MovieSearchResponse();
    }

    @Test
    public void shouldReturnTotalCount() {
        //given
        int expected = 2;
        movieSearchResponse.total_count = expected;
        //when
        int result = movieSearchResponse.getTotal_count();
        //then
        assertEquals(result, expected);
    }

    @Test
    public void shouldReturnMovies() {
        //given
        ArrayList<MovieModel> movies = new ArrayList<>();
        movies.add(mock(MovieModel.class));
        movieSearchResponse.movies = movies;
        //when
        List<MovieModel> result = movieSearchResponse.getMovies();
        //then
        assertEquals(result, movies);
    }

    @Test
    public void shouldReturnStringRepresentationOfMovies(){
        //given
        MovieModel movieModel1 = new MovieModel("The Godfather",
                "http://t1.gstatic.com/licensed-image?q=tbn:ANd9GcQUObbKfZg1xCfueoYQX7RZFIBoXQ6rAy0ToKzsuFs0X71FfObEFNfSUhRjRbFy1VEU",
                "01.01.1977",
                1,
                4.5F,
                "Movie Overview For The Godfather",
                "English");
        MovieModel movieModel2 = new MovieModel("Test Film",
                "www.google.com",
                "01.01.1999",
                2,
                3.7F,
                "Overview",
                "English");
        ArrayList<MovieModel> movies = new ArrayList<>();
        movies.add(movieModel1);
        movies.add(movieModel2);
        movieSearchResponse.total_count = 2;
        movieSearchResponse.movies = movies;
        //when
        String result = movieSearchResponse.toString();
        //then
        assertEquals(result, "MovieSearchResponse{total_count=2, movies=[MovieModel{title='The Godfather', poster_path='http://t1.gstatic.com/licensed-image?q=tbn:ANd9GcQUObbKfZg1xCfueoYQX7RZFIBoXQ6rAy0ToKzsuFs0X71FfObEFNfSUhRjRbFy1VEU', release_date='01.01.1977', movie_id=1, vote_average=4.5, movie_overview='Movie Overview For The Godfather', original_language='English'}, MovieModel{title='Test Film', poster_path='www.google.com', release_date='01.01.1999', movie_id=2, vote_average=3.7, movie_overview='Overview', original_language='English'}]}");
    }
}