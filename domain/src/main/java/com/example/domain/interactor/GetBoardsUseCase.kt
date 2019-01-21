package com.example.domain.interactor

import com.example.domain.interactor.UseCase
import com.example.domain.repository.BoardRepository
import com.example.gateway.entity.Board
import io.reactivex.Single
import javax.inject.Inject

class GetBoardsUseCase @Inject constructor(private val boardRepository: BoardRepository)
    : UseCase<List<Board>, UseCase.None>() {

    override suspend fun run(params: None) = boardRepository.getBoardList()

}