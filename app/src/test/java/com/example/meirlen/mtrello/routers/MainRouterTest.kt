package com.example.meirlen.mtrello.routers

import android.app.Activity
import android.os.Build
import com.example.meirlen.mtrello.MockInstantiator
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows
import org.robolectric.annotation.Config


@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class MainRouterTest {

    private lateinit var router: MainRouter
    private lateinit var activity: Activity

    @Before
    fun setUpTest() {
        router = MainRouter()
        activity = Robolectric.setupActivity(Activity::class.java)
    }

    @Test
    fun shouldOpenProductDetailsByClick() {
        router.showColumns(activity, MockInstantiator.DEFAULT_ID)
      //  val startedIntent = Shadows.shadowOf(activity).nextStartedActivity
       // val shadowIntent = Shadows.shadowOf(startedIntent)
        // assertEquals(MockInstantiator.DEFAULT_ID, startedIntent.extras?.getString(ColumnsActivity.EXTRA_BOARD_ID))
        // assertEquals(ColumnsActivity::class.java, shadowIntent.intentClass)
    }

}