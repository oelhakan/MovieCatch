package pl.edu.pwr.moviecatch;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import pl.edu.pwr.moviecatch.models.MovieModel;

public class MovieDetailsTest {

    @Rule
    public ActivityTestRule<MovieDetails> activityTestRule =
            new ActivityTestRule<>(MovieDetails.class);

    @Test
    public void checkDetailsDisplayed() {
        MovieModel movieModel = new MovieModel("Test Title", "Test Poster Path",
                "Test Release Date", 1, 5.0f, "Test Overview", "Test Language");

        activityTestRule.launchActivity(MovieDetails.getIntent(activityTestRule.getActivity(), movieModel));

        Espresso.onView(ViewMatchers.withId(R.id.textView_title_details))
                .check(ViewAssertions.matches(ViewMatchers.withText("Test Title")));

        Espresso.onView(ViewMatchers.withId(R.id.textView_desc_details))
                .check(ViewAssertions.matches(ViewMatchers.withText("Test Overview")));

        Espresso.onView(ViewMatchers.withId(R.id.ratingBar_details))
                .check(ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
    }
}

