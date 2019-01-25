package com.example.meirlen.mtrello.ui.board

import android.content.Context
import android.content.Intent
import androidx.lifecycle.MutableLiveData
import androidx.test.InstrumentationRegistry
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.rule.ActivityTestRule
import com.example.gateway.entity.Board
import com.example.meirlen.mtrello.HomeActivity
import com.example.meirlen.mtrello.R
import com.example.meirlen.mtrello.base.vo.Resource
import com.example.meirlen.mtrello.ui.home.HomeFragment
import com.example.meirlen.mtrello.util.TestUtil
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import org.koin.standalone.StandAloneContext
import org.koin.test.KoinTest
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class BoardsFragmentTest : KoinTest {
    @Rule
    @JvmField
    val rule = ActivityTestRule(HomeActivity::class.java, false, false)

    lateinit var mockVm: BoardViewModel
    private val MY_ACTIVITY_INTENT = Intent(InstrumentationRegistry.getTargetContext(), HomeActivity::class.java)

    private val listLiveData = MutableLiveData<Resource<List<Board>>>()

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        mockVm = Mockito.mock(BoardViewModel::class.java)
        Mockito.`when`(mockVm.getBoards()).thenReturn(listLiveData)
        StandAloneContext.loadKoinModules(module {
            viewModel {
                mockVm
            }
        })
        rule.launchActivity(MY_ACTIVITY_INTENT)
    }

    @Test
    fun shouldLoading() {
        listLiveData.postValue(Resource.loading(null))
        Espresso.onView(ViewMatchers.withId(R.id.boardProgressBar)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun shouldLoadBoardsOnLoadDate() {
        val repo = TestUtil.createBoards(2, "TestId", "TestName")
        listLiveData.postValue(Resource.success(repo))
    }

    @After
    fun cleanUp() {
        StandAloneContext.stopKoin()
    }

}