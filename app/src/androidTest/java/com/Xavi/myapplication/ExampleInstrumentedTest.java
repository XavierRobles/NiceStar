package com.Xavi.myapplication;

import android.content.Context;

import androidx.test.InstrumentationRegistry;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;


/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityScenarioRule<RegistroActivity> activityRule =

            new ActivityScenarioRule<>(RegistroActivity.class);

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.Xavi.myapplication",
                appContext.getPackageName());
    }

    @Test
    public void activityLaunch() {

        onView(withId(R.id.usernameTIL)).perform(
                typeText("This is a test."));
        onView(withId(R.id.btn_cancel)).perform(click());


    }

    @Test
    public void textInputOutput() {
        onView(withId(R.id.input_nameRegistro)).perform(
                typeText("This is a test."));

//        onView(withId(R.id.input_nameRegistro)).check(
//                matches(withText("This is a test.")));
    }
}