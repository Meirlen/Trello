package com.example.domain.repository

import com.example.gateway.entity.Board
import io.reactivex.Single

interface BlogRepository {

    fun getArticleList(): Single<List<Board>>

}