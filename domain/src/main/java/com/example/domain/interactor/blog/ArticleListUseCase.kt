package com.example.domain.interactor.blog

import com.example.domain.interactor.base.SingleUseCase
import com.example.domain.repository.BlogRepository
import com.shopapp.gateway.entity.Article

import io.reactivex.Single
import javax.inject.Inject

class ArticleListUseCase @Inject constructor(private val blogRepository: BlogRepository) :
    SingleUseCase<List<Article>, ArticleListUseCase.Params>() {

    override fun buildUseCaseSingle(params: Params): Single<List<Article>> {
        return with(params) {
            blogRepository.getArticleList(perPage, paginationValue, true)
        }
    }

    data class Params(
        val perPage: Int,
        val paginationValue: String? = null
    )
}