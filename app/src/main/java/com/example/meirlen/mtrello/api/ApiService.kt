package com.example.meirlen.mtrello.api

import androidx.lifecycle.LiveData
import com.example.meirlen.mtrello.model.Board
import com.example.meirlen.mtrello.model.Column
import kotlinx.coroutines.experimental.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiService {


   /* @GET("1/members/me/boards")
    fun getBoards(): LiveData<ApiResponse<List<Board>>>

    @GET("1/boards/{id}/lists?cards=all")
    fun getColumns(@Path("id") id: String?): LiveData<ApiResponse<List<Column>>>*/


    @GET("1/members/me/boards")
    fun getBoards(): Deferred<List<Board>>
}