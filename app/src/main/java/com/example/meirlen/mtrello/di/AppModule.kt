package com.example.meirlen.mtrello.di

import com.example.data.impl.BoardRepositoryImpl
import com.example.domain.interactor.GetBoardsUseCase
import com.example.domain.repository.BoardRepository
import com.example.data.remote.ApiService
import com.example.meirlen.mtrello.base.constants.Constant
import com.example.meirlen.mtrello.base.constants.Constant.BASE_URL
import com.example.meirlen.mtrello.ui.board.BoardViewModel
import com.example.meirlen.mtrello.routers.MainRouter
import com.example.meirlen.mtrello.utill.interceptors.AuthInterceptor
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
            BoardRepositoryImpl(get()) as BoardRepository
        }
        factory {
            GetBoardsUseCase(get())
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
            .addConverterFactory(GsonConverterFactory.create()).build()
    return retrofit.create(T::class.java)
}
