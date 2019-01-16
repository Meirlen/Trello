package com.example.domain.interactor.blog

import com.example.domain.interactor.base.SingleUseCase
import com.example.domain.repository.BlogRepository
import com.example.gateway.entity.Board
import io.reactivex.Single
import javax.inject.Inject

class ArticleUseCase @Inject constructor(private val blogRepository: BlogRepository) :
        SingleUseCase<List<Board>, String>() {

    override fun buildUseCaseSingle(params: String): Single<List<Board>> =
            blogRepository.getArticleList()

}