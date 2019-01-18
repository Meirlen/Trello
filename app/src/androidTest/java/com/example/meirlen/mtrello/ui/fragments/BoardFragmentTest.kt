package com.example.meirlen.mtrello.ui.fragments

import android.content.Context
import androidx.lifecycle.MediatorLiveData
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.example.meirlen.mtrello.R
import com.example.meirlen.mtrello.base.vo.Resource
import com.example.gateway.entity.Board
import com.example.meirlen.mtrello.routers.MainRouter
import com.example.meirlen.mtrello.testing.SingleFragmentActivity
import com.example.meirlen.mtrello.ui.board.BoardViewModel
import com.example.meirlen.mtrello.ui.board.BoardsFragment
import com.example.meirlen.mtrello.util.EspressoTestUtil
import com.example.meirlen.mtrello.util.RecyclerViewMatcher
import com.example.meirlen.mtrello.util.TestUtil
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.*
import org.mockito.Mockito.verify

@RunWith(AndroidJUnit4::class)
@LargeTest
class BoardFragmentTest {

    @Rule
    @JvmField
    val activityRule = ActivityTestRule(SingleFragmentActivity::class.java, true, true)

    private val result = MediatorLiveData<Resource<List<Board>>>()

    @Mock
    private
    lateinit var viewModel: BoardViewModel

    @Mock
    private
    lateinit var router: MainRouter


    private lateinit var list: List<Board>

    @Captor
    lateinit var captorContext: ArgumentCaptor<Context>

    @Captor
    lateinit var captorBoard: ArgumentCaptor<String>


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        EspressoTestUtil.disableProgressBarAnimations(activityRule)
        list = TestUtil.createBoards(10, "1", "Miko")

        val fragment = BoardsFragment()
        // fragment.router = router

        // Mockito.`when`(viewModel.getBoards()).thenReturn(result)
        activityRule.activity.replaceFragment(fragment)
    }

    @Test
    fun successTest() {
        result.postValue(Resource.success(list))
        // Espresso.onView(listMatcher().atPosition(0)).check(matches(isDisplayed()))
        // Espresso.onView(withId(R.id.progressBar)).check(matches(not(isDisplayed())))
    }

     @Test
     fun loadingTest() {
         result.postValue(Resource.loading(null))
         Espresso.onView(withId(R.id.progressBar)).check(matches(isDisplayed()))
     }

     @Test
     fun errorTest() {
         val errorMsg = "failed to load"
         result.postValue(Resource.error(errorMsg, null))
       //  Espresso.onView(withId(R.id.tvError)).check(matches(withText(errorMsg))).check(matches(isDisplayed()))
     }

     @Test
     fun testBoardItemClick() {
         result.postValue(Resource.success(list))
         onView(listMatcher().atPosition(0)).check(matches(isDisplayed()))
         onView(listMatcher().atPosition(0)).perform(click())
       //  verify(router).showColumns(captorContext.capture(), com.nhaarman.mockitokotlin2.capture(captorBoard))

     }

    private fun listMatcher(): RecyclerViewMatcher {
        return RecyclerViewMatcher(R.id.mRecyclerView)
    }
}