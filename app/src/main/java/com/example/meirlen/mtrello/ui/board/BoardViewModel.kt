package com.example.meirlen.mtrello.ui.board

import androidx.lifecycle.MutableLiveData
import com.example.meirlen.mtrello.base.vm.AbstractViewModel
import com.example.meirlen.mtrello.base.vo.Resource
import com.example.meirlen.mtrello.data.datasource.entities.Board
import com.example.meirlen.mtrello.data.repository.BoardRepository
import com.example.meirlen.mtrello.utill.arch.SingleLiveEvent
import com.example.meirlen.mtrello.utill.shedulers.SchedulerProvider


class BoardViewModel(private val boardRepository: BoardRepository, scheduler: SchedulerProvider) : AbstractViewModel(scheduler) {

    val uiData = MutableLiveData<Resource<List<Board>>>()

    fun getBoards() {
        launch {
            uiData.value = Resource.loading(null)

            try {
                val list = boardRepository.getBoards().await()
                uiData.value = Resource.success(list)

            } catch (error: Throwable) {
                uiData.value = Resource.error(error.message.toString(), null)

            }
        }
    }

}