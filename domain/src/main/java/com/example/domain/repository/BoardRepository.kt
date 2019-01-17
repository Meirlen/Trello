package com.example.domain.repository

import com.example.gateway.entity.Board
import io.reactivex.Single

interface BoardRepository {

    fun getBoardList(): Single<List<Board>>

}