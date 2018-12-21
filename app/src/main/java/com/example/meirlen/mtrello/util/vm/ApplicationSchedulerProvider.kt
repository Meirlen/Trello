package com.example.meirlen.mtrello.util.vm



import kotlinx.coroutines.experimental.android.UI

/**
 * Application providers
 */
class ApplicationSchedulerProvider : SchedulerProvider {
    override fun ui() = UI
}