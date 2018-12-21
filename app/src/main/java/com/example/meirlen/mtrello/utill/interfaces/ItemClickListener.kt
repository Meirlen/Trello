package com.example.meirlen.mtrello.utill.interfaces

interface ItemClickListener<in T> {
    fun onItemClick(dataObject : T)
}