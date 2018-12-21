package com.example.meirlen.mtrello.viewmodel

import androidx.lifecycle.ViewModel
import com.example.meirlen.mtrello.util.vm.SchedulerProvider
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.Job

/**
 * ViewModel for Coroutines Jobs
 *
 * launch() - launch request
 * clear all request on stop
 */
abstract class AbstractViewModel(private val schedulerProvider: SchedulerProvider) : ViewModel() {
    var jobs = listOf<Job>()

    fun launch(code: suspend CoroutineScope.() -> Unit) {
        jobs += kotlinx.coroutines.experimental.launch(schedulerProvider.ui(), block = code)
    }

    override fun onCleared() {
        super.onCleared()
        jobs.forEach { it.cancel() }
    }
}