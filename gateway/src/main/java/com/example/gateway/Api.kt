package com.example.gateway

import com.example.gateway.entity.Board


interface Api {
    fun getBoardList(callback: ApiCallback<List<Board>>)
}
