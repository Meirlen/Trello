package com.example.meirlen.mtrello.utill.interfaces


interface CallbackResponse<in T> {
    fun onResponse(response : T)
}