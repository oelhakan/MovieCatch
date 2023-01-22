package pl.edu.pwr.moviecatch;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.pressImeActionButton;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.action.ViewActions.typeTextIntoFocusedView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import android.content.Intent;
import android.widget.EditText;

import androidx.appcompat.widget.SearchView;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;
import androidx.test.uiautomator.UiDevice;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;

public class MovieListActivityTest {


    @Rule
    public ActivityTestRule<MovieListActivity> activityTestRule = new ActivityTestRule<>(MovieListActivity.class);

    @Before
    public void setUp() throws IOException {
        UiDevice device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        device.executeShellCommand("settings put global transition_animation_scale 0");
        device.executeShellCommand("settings put global window_animation_scale 0");
        device.executeShellCommand("settings put global animator_duration_scale 0");
        activityTestRule.launchActivity(new Intent());
    }

    @Test
    public void checkSearchViewIsDisplayed() {
        onView(withId(R.id.search_view))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    @Test
    public void checkRecyclerViewIsDisplayed() {
        onView(withId(R.id.recyclerView))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

//    @Test
//    public void checkSearchViewFunctionality() throws InterruptedException {
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        onView(withId(R.id.search_view)).perform(click());
//        activityTestRule.getActivity().runOnUiThread(new Runnable() {
//            public void run() {
//                onView(withId(R.id.search_src_text)).perform(typeText("Test"), closeSoftKeyboard());
//            }
//        });
//        onView(withId(R.id.search_src_text)).perform(pressImeActionButton());
//
//        // Additional assertions here to check if the search results are displayed as expected
//    }
}
