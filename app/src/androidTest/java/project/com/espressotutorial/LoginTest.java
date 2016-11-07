package project.com.espressotutorial;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

/**
 * Created by bharatghimire on 19/8/16.
 */
@RunWith(AndroidJUnit4.class)
public class LoginTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule= new ActivityTestRule<LoginActivity>(LoginActivity.class);


    @Test
    public void loginInSuccess(){
        onView(withId(R.id.edittext_email))
                .perform(typeText("bharat.ghimire@gmail.com"));
        onView(withId(R.id.edittext_password)).perform(typeText("abcdedfd"));
        onView(withId(R.id.button_login)).perform(click());

    }

    @Test
    public void loginEmailEmpty(){
        onView(withId(R.id.edittext_password)).perform(typeText("abcdedfd"));
        onView(withId(R.id.button_login)).perform(click());
        onView(withText(R.string.not_valid_email)).
                inRoot(withDecorView(not(is(mActivityRule.getActivity().getWindow().getDecorView())))).
                check((matches(isDisplayed())));
    }

    @Test
    public void scrollToPosition(){
    onView(withId(R.id.recyclerview_country)).perform(RecyclerViewActions.scrollToPosition(3));

}

}
