package com.example.meirlen.mtrello.data.datasource.remote

import com.example.meirlen.mtrello.data.datasource.entities.Board
import kotlinx.coroutines.experimental.Deferred
import retrofit2.http.GET


interface ApiService {


   /* @GET("1/members/me/boards")
    fun getBoards(): LiveData<ApiResponse<List<Board>>>

    @GET("1/boards/{id}/lists?cards=all")
    fun getColumns(@Path("id") id: String?): LiveData<ApiResponse<List<Column>>>*/


    @GET("1/members/me/boards")
    fun getBoards(): Deferred<List<Board>>
}