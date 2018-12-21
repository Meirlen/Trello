package com.example.meirlen.mtrello.util.vm
import kotlinx.coroutines.experimental.CoroutineDispatcher

/**
 * Rx Scheduler Provider
 */
interface SchedulerProvider {
    fun ui(): CoroutineDispatcher
}