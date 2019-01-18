package com.example.meirlen.mtrello.ui.board

import androidx.test.rule.ActivityTestRule
import com.example.meirlen.mtrello.testing.SingleFragmentActivity
import com.example.meirlen.mtrello.ui.home.HomeFragment
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class BoardsFragmentTest {

    @Rule
    @JvmField
    val activityRule = ActivityTestRule(SingleFragmentActivity::class.java, true, true)


    @Before
    fun setUp() {
        val fragment = HomeFragment()
        activityRule.activity.replaceFragment(fragment)
    }

    @Test
    fun someTest() {
        val errorMsg = "failed to load"
    }
}