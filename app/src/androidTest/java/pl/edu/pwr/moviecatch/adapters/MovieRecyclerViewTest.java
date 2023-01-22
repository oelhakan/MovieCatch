package pl.edu.pwr.moviecatch.adapters;

import static org.junit.Assert.assertEquals;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import pl.edu.pwr.moviecatch.models.MovieModel;

@RunWith(AndroidJUnit4.class)
public class MovieRecyclerViewTest {

    private MovieRecyclerView movieRecyclerView;
    private List<MovieModel> movieModelList;

    @Before
    public void setUp() {
        // Initialize the MovieRecyclerView
        movieRecyclerView = new MovieRecyclerView(new OnMovieListener() {
            @Override
            public void onMovieClick(int position) {
            }
        });

        // Create a list of MovieModel objects
        movieModelList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            movieModelList.add(new MovieModel("Example " + i, "example_path " + i, "2022-01-01", i, 8.5f, "Example overview " + i, "en"));
        }
    }

    @Test
    public void testSetmMovies() {
        // Call the setmMovies method
        movieRecyclerView.setmMovies(movieModelList);

        // Check that the RecyclerView has the correct number of items
        assertEquals(movieModelList.size(), movieRecyclerView.getItemCount());
    }
}
