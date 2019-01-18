package com.example.meirlen.mtrello.ui.home

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.meirlen.mtrello.HomeActivity
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class HomeFragmentTest {
    @get:Rule
    val rule = ActivityTestRule(HomeActivity::class.java)

    @Test
    fun clickingOnTitle_shouldLaunchEditAction() {
       // onView(withId(R.id.button)).perform(click())
       // intended(hasAction(equalTo("android.intent.action.EDIT")))
    }
}