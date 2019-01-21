package com.example.meirlen.mtrello.ui.board

import com.example.domain.functional.Either
import com.example.domain.interactor.GetBoardsUseCase
import com.example.gateway.entity.Board
import com.example.meirlen.mtrello.util.AndroidTest
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.given
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.experimental.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock

class BoardViewModelTest  : AndroidTest() {

    @Mock
    private lateinit var mUseCase: GetBoardsUseCase

    private lateinit var mViewModel: BoardViewModel

    @Before
    fun setUpTest() {
        mViewModel = BoardViewModel(mUseCase)
    }

    @Test
    fun `loading movies should update live data`() {
        val moviesList = listOf(Board("1", "Zhumanov"), Board("2", "Meirlen"))
        given { runBlocking { mUseCase.run(any()) } }.willReturn(Either.Right(moviesList))

        mViewModel.uiData.observeForever {
            assertEquals(2, it.size)
            assertEquals("1", it[0].id)
            assertEquals("Zhumanov", it[0].name)
        }
        runBlocking {
            mViewModel.getBoards()
        }

    }

}