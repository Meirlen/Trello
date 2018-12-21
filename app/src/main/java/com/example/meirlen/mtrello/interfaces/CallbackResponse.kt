package com.example.meirlen.mtrello.interfaces


interface CallbackResponse<in T> {
    fun onResponse(response : T)
}