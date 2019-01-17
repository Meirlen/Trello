package com.example.domain.interactor.board

import com.example.domain.interactor.base.SingleUseCase
import com.example.domain.repository.BoardRepository
import com.example.gateway.entity.Board
import io.reactivex.Single
import javax.inject.Inject

class GetBoardsUseCase @Inject constructor(private val boardRepository: BoardRepository) :
        SingleUseCase<List<Board>, Unit>() {

    override fun buildUseCaseSingle(params: Unit): Single<List<Board>> =
            boardRepository.getBoardList()

}