package project.com.espressotutorial;

import android.content.Intent;
import android.support.test.espresso.intent.Intents;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.init;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.Intents.intending;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by bharatghimire on 29/8/16.
 */

@RunWith(AndroidJUnit4.class)
public class TestIntent {
    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule =
            new ActivityTestRule<LoginActivity>(LoginActivity.class);

@Before
public void initialize(){
    Intents.init();
}
@Test
    public void openNewActivity(){
    onView(withId(R.id.button_call)).perform(click());
    intended(toPackage("project.com.espressodemo"));
    intended(hasExtra("CountryCode", "42"));
}
    @After
    public void release(){
        Intents.release();
    }



}
