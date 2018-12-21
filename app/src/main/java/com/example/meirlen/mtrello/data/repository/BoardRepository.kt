package com.example.meirlen.mtrello.data.repository

import com.example.meirlen.mtrello.data.datasource.remote.ApiService
import com.example.meirlen.mtrello.data.datasource.entities.Board
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async


interface BoardRepository {
    fun getBoards(): Deferred<List<Board>>
}


class BoardRepositoryImpl(private val mApiService: ApiService) : BoardRepository {

    override fun getBoards(): Deferred<List<Board>> = async {
        mApiService.getBoards().await()
    }


}