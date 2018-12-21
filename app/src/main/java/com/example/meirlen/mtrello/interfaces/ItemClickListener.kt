package com.example.meirlen.mtrello.interfaces

interface ItemClickListener<in T> {
    fun onItemClick(dataObject : T)
}