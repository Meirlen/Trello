package com.example.meirlen.mtrello.ui.board

import android.os.Build
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.Robolectric



@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class BoardsFragmentTest {

    private lateinit var fragment: BoardsFragment

    @Test
    fun shouldOpenProductDetailsByClick() {
     //   fragment=Robolectric.buildFragment(BoardsFragment::class.java)

    }

}