package com.example.data.impl
import com.example.data.remote.ApiService
import com.example.domain.repository.BlogRepository
import com.example.gateway.entity.Board
import io.reactivex.Single

class BlogRepositoryImpl(private val api: ApiService) : BlogRepository {

    override fun getArticleList(): Single<List<Board>> = api.getBoards()

}