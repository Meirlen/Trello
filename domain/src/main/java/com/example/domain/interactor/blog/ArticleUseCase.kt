package com.example.domain.interactor.blog

import com.example.domain.interactor.base.SingleUseCase
import com.example.domain.repository.BlogRepository
import com.shopapp.gateway.entity.Article
import io.reactivex.Single
import javax.inject.Inject

class ArticleUseCase @Inject constructor(private val blogRepository: BlogRepository) :
    SingleUseCase<Pair<Article, String>, String>() {

    override fun buildUseCaseSingle(params: String): Single<Pair<Article, String>> =
        blogRepository.getArticle(params)
}