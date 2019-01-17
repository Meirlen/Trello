package com.example.meirlen.mtrello

import android.content.Context
import android.os.Build
import kotlinx.android.synthetic.main.activity_main.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class HomeActivityTest {

    private lateinit var activity: HomeActivity
    private lateinit var context: Context

    @Before
    fun setUpTest() {
        context=RuntimeEnvironment.application.baseContext
        val intent=HomeActivity.getStartIntent(context)
        activity = Robolectric.buildActivity(HomeActivity::class.java, intent).create().start().get()
    }

    @Test
    fun shouldSelectHomeTabOnCreate() {
        assertEquals(HomeActivity.HOME,activity.bottomTabNavigation.selectedTabPosition)

    }
}