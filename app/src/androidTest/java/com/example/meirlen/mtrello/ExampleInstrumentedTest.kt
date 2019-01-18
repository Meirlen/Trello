package com.example.meirlen.mtrello


import androidx.lifecycle.MediatorLiveData
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.example.gateway.entity.Board
import com.example.meirlen.mtrello.base.vo.Resource
import com.example.meirlen.mtrello.testing.SingleFragmentActivity
import com.example.meirlen.mtrello.ui.board.BoardViewModel
import com.example.meirlen.mtrello.ui.board.BoardsFragment
import com.example.meirlen.mtrello.ui.home.HomeFragment
import com.example.meirlen.mtrello.util.EspressoTestUtil
import com.example.meirlen.mtrello.util.RecyclerViewMatcher
import com.example.meirlen.mtrello.util.TestUtil
import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
@LargeTest
class ExampleInstrumentedTest {

    @get:Rule
    val activityRule = ActivityTestRule(SingleFragmentActivity::class.java)

    @Mock
    private
    lateinit var viewModel: BoardViewModel

    private lateinit var list: List<Board>


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        EspressoTestUtil.disableProgressBarAnimations(activityRule)
        val fragment = BoardsFragment.newInstance()
        list = TestUtil.createBoards(10, "1", "Miko")
        viewModel.uiData.value=Resource.success(list)
        activityRule.activity.replaceFragment(fragment)
    }

    @Test
    fun shouldBoardItemClick() {
        // onView(listMatcher().atPosition(0)).check(matches(isDisplayed()))
    }

    private fun listMatcher(): RecyclerViewMatcher {
        return RecyclerViewMatcher(R.id.mRecyclerView)
    }
}
