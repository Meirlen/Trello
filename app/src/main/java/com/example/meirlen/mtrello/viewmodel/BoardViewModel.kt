package com.example.meirlen.mtrello.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.meirlen.mtrello.model.Board
import com.example.meirlen.mtrello.repos.BoardRepository
import com.example.meirlen.mtrello.util.SingleLiveEvent
import com.example.meirlen.mtrello.util.vm.SchedulerProvider



class BoardViewModel(private val boardRepository: BoardRepository,  scheduler: SchedulerProvider) : AbstractViewModel(scheduler) {

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