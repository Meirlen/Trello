package com.example.meirlen.mtrello.ui.board

import android.os.Build
import com.example.meirlen.mtrello.ui.home.HomeFragment
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.Robolectric



@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class BoardsFragmentTest {

    private lateinit var fragment: HomeFragment

    @Before
    fun setUp() {
        fragment = SupportFragmentController.of(HomeFragment())
                .create()
                .resume()
                .visible()
                .get()
    }

}