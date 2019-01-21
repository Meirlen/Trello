package com.example.domain.interactor.board

import com.example.domain.interactor.GetBoardsUseCase
import com.example.domain.repository.BoardRepository
import com.nhaarman.mockito_kotlin.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetBoardsUseCaseTest{

    private lateinit var useCase: GetBoardsUseCase

    @Mock
    private lateinit var  repository: BoardRepository

    @Before
    fun setUp() {
        useCase= GetBoardsUseCase(repository)
    }

    @Test
    fun shoulDelegateCallToRepository() {
        useCase.buildUseCaseSingle(Unit)
        verify(repository).getBoardList()
    }
}