package com.example.meirlen.mtrello.ui.board

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.interactor.board.GetBoardsUseCase
import com.example.meirlen.mtrello.base.vo.Resource
import com.example.gateway.entity.Board


class BoardViewModel(private val getBoardsUseCase: GetBoardsUseCase) : ViewModel() {

    val uiData = MutableLiveData<Resource<List<Board>>>()

    fun getBoards() {

        getBoardsUseCase.execute(
                { uiData.value = Resource.success(it) },
                { uiData.value = Resource.error(it.localizedMessage, null) },
                Unit
        )
    }

}

/*

     /*   launch {
               uiData.value = Resource.loading(null)

               try {
                   val list = boardRepository.getBoards().await()
                   uiData.value = Resource.success(list)

               } catch (error: Throwable) {
                   uiData.value = Resource.error(error.message.toString(), null)

               }
           }*/


 */