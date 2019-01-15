package com.example.domain.repository

import com.shopapp.gateway.entity.Article
import io.reactivex.Single

interface BlogRepository {

    fun getArticleList(perPage: Int, paginationValue: Any?, reverse: Boolean): Single<List<Article>>

    fun getArticle(id: String): Single<Pair<Article, String>>
}