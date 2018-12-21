package com.example.meirlen.mtrello.ui.fragments

import android.content.Context
import androidx.lifecycle.MediatorLiveData

import com.example.meirlen.mtrello.R
import com.example.meirlen.mtrello.data.datasource.entities.Board
import com.example.meirlen.mtrello.routers.MainRouter
import com.example.meirlen.mtrello.testing.SingleFragmentActivity
import com.example.meirlen.mtrello.util.EspressoTestUtil
import com.example.meirlen.mtrello.util.RecyclerViewMatcher
import com.example.meirlen.mtrello.util.TestUtil
import com.example.meirlen.mtrello.util.ViewModelUtil
import com.example.meirlen.mtrello.viewmodel.BoardsViewModel
import com.example.meirlen.mtrello.vo.Resource
import org.hamcrest.CoreMatchers.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.*
import org.mockito.Mockito.verify

class BoardFragmentTest {

    @Rule
    @JvmField
    val activityRule = ActivityTestRule(SingleFragmentActivity::class.java, true, true)

    private val result = MediatorLiveData<Resource<List<Board>>>()

    @Mock
    private
    lateinit var viewModel: BoardsViewModel

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

        val fragment = BoardFragment.newInstance()
        fragment.viewModelFactory = ViewModelUtil.createFor(viewModel)
        fragment.router = router

        Mockito.`when`(viewModel.boards).thenReturn(result)
        activityRule.activity.replaceFragment(fragment)
    }

    @Test
    fun successTest() {
        result.postValue(Resource.success(list))
        Espresso.onView(listMatcher().atPosition(0)).check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.progressBar)).check(matches(not(isDisplayed())))
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
        verify(router).showColumns(captorContext.capture(), com.nhaarman.mockitokotlin2.capture(captorBoard))

    }

    private fun listMatcher(): RecyclerViewMatcher {
        return RecyclerViewMatcher(R.id.mRecyclerView)
    }
}