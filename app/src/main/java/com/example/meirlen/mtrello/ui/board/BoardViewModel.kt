package com.example.meirlen.mtrello.ui.board

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.example.domain.interactor.GetBoardsUseCase
import com.example.gateway.entity.Board
import com.example.meirlen.mtrello.base.vo.Resource
import com.example.meirlen.mtrello.testing.OpenForTesting

@OpenForTesting
open class BoardViewModel(private val getBoardsUseCase: GetBoardsUseCase) : ViewModel() {


    private val uiData = MutableLiveData<Resource<List<Board>>>()

    fun getBoards(): MutableLiveData<Resource<List<Board>>> {
        uiData.value = Resource.loading(null)

        getBoardsUseCase.execute(
                {
                    uiData.value = Resource.success(it)
                },
                {
                    uiData.value = Resource.error(it.message.toString(), null)

                }
        )
        return uiData
    }


}

