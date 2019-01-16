package com.example.meirlen.mtrello.ui.board

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.interactor.blog.ArticleUseCase
import com.example.meirlen.mtrello.base.vm.AbstractViewModel
import com.example.meirlen.mtrello.base.vo.Resource
import com.example.gateway.entity.Board
import com.example.meirlen.mtrello.data.repository.BoardRepository
import com.example.meirlen.mtrello.utill.shedulers.SchedulerProvider


class BoardViewModel(private val articleUseCase: ArticleUseCase) : ViewModel() {

    val uiData = MutableLiveData<Resource<List<Board>>>()

    fun getBoards(id: String) {

        articleUseCase.execute(
                { uiData.value = Resource.success(it) },
                { uiData.value = Resource.error(it.localizedMessage, null) },
                id
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