package com.example.meirlen.mtrello.di

import com.example.data.impl.BlogRepositoryImpl
import com.example.domain.interactor.blog.ArticleUseCase
import com.example.domain.repository.BlogRepository
import com.example.data.remote.ApiService
import com.example.meirlen.mtrello.base.constants.Constant
import com.example.meirlen.mtrello.base.constants.Constant.BASE_URL
import com.example.meirlen.mtrello.ui.board.BoardViewModel
import com.example.meirlen.mtrello.routers.MainRouter
import com.example.meirlen.mtrello.utill.interceptors.AuthInterceptor
import com.example.meirlen.mtrello.utill.shedulers.ApplicationSchedulerProvider
import com.example.meirlen.mtrello.utill.shedulers.SchedulerProvider
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


val appModule = module {
    factory {
        createOkHttpClient()
    }
    factory {
        createWebService<ApiService>(get(), BASE_URL)
    }

    module("repository") {

        factory {
            BlogRepositoryImpl(get()) as BlogRepository
        }
        factory {
            ArticleUseCase(get())
        }
        module("viewModel") {
            viewModel {
                BoardViewModel(get())
            }
        }

    }

    single {
        MainRouter()
    }


}
val rxModule = module {

    single { ApplicationSchedulerProvider() as SchedulerProvider }
}

fun createOkHttpClient(): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    val okHttpBuilder = OkHttpClient.Builder()
            .connectTimeout(Constant.CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(Constant.READ_TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(AuthInterceptor())
            .addInterceptor(httpLoggingInterceptor)
    return okHttpBuilder.build()
}

inline fun <reified T> createWebService(okHttpClient: OkHttpClient, url: String): T {
    val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build()
    return retrofit.create(T::class.java)
}
