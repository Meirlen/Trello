package com.example.meirlen.mtrello.ui.board

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.interactor.board.GetBoardsUseCase
import com.example.meirlen.mtrello.base.vo.Resource
import com.example.gateway.entity.Board


open  class BoardViewModel(private val getBoardsUseCase: GetBoardsUseCase) : ViewModel() {

    val uiData = MutableLiveData<Resource<List<Board>>>()

    fun getBoards() {

        getBoardsUseCase.execute(
                { uiData.value = Resource.success(it) },
                { uiData.value = Resource.error(it.localizedMessage, null) },
                Unit
        )
    }

}
