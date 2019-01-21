package com.example.meirlen.mtrello.ui.board

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.interactor.GetBoardsUseCase
import com.example.domain.interactor.UseCase
import com.example.meirlen.mtrello.base.vo.Resource
import com.example.gateway.entity.Board
import com.example.meirlen.mtrello.base.BaseViewModeli


open class BoardViewModel(private val getBoardsUseCase: GetBoardsUseCase) : BaseViewModeli() {

    val uiData: MutableLiveData<List<Board>> = MutableLiveData()

    fun getBoards() = getBoardsUseCase(UseCase.None())
    { it.either(::handleFailure, ::handleMovieList) }

    private fun handleMovieList(movies: List<Board>) {
        this.uiData.value = movies
    }


}

