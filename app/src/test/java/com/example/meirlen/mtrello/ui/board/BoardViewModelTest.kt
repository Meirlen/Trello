package com.example.meirlen.mtrello.ui.board

import com.example.domain.interactor.GetBoardsUseCase
import com.example.gateway.entity.Board
import com.example.meirlen.mtrello.util.RxImmediateSchedulerRule
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.given
import io.reactivex.Single
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class BoardViewModelTest {
    @Rule
    @JvmField
    var testSchedulerRule = RxImmediateSchedulerRule()

    @Mock
    private lateinit var mUseCase: GetBoardsUseCase

    @Mock
    private lateinit var articles: List<Board>

    private lateinit var mViewModel: BoardViewModel

    @Before
    fun setUpTest() {
        MockitoAnnotations.initMocks(this)
        mViewModel = BoardViewModel(mUseCase)
        mUseCase.mock()
    }

    @Test
    fun shouldShowContent() {
        given(mUseCase.buildUseCaseSingle(any())).willReturn(Single.just(articles))
        mViewModel.getBoards()

    }

}