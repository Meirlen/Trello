package com.example.meirlen.mtrello.ui.board

import androidx.lifecycle.MutableLiveData
import com.example.meirlen.mtrello.base.vm.AbstractViewModel
import com.example.meirlen.mtrello.data.datasource.entities.Board
import com.example.meirlen.mtrello.data.repository.BoardRepository
import com.example.meirlen.mtrello.utill.arch.SingleLiveEvent
import com.example.meirlen.mtrello.utill.shedulers.SchedulerProvider



class BoardViewModel(private val boardRepository: BoardRepository, scheduler: SchedulerProvider) : AbstractViewModel(scheduler) {

    val uiData = MutableLiveData<List<Board>>()
    val searchEvent = SingleLiveEvent<SearchEvent>()

    fun getBoards() {
        launch {
            searchEvent.value = SearchEvent(isLoading = true)
            try {
                val list = boardRepository.getBoards().await()
                uiData.value=list
                searchEvent.postValue(SearchEvent(isSuccess = true))

            }
            catch (error: Throwable) {
                searchEvent.postValue(SearchEvent(error = error.message))

            }
        }
    }


    data class SearchEvent(val isLoading: Boolean = false, val isSuccess: Boolean = false, val error: String? = null)

}