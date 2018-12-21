package com.example.meirlen.mtrello.data.datasource.entities

sealed class Error : Exception() {
    class Critical : Error()
    class NonCritical(override val message: String) : Error()
    class Content(var isNetworkError: Boolean = false) : Error()
}