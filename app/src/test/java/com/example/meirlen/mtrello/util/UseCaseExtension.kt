package com.example.meirlen.mtrello.util



import com.example.domain.interactor.base.CompletableUseCase
import com.example.domain.interactor.base.ObservableUseCase
import com.example.domain.interactor.base.SingleUseCase
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.given
import io.reactivex.disposables.CompositeDisposable

inline fun <reified T : Any> CompletableUseCase<T>.mock() {
    given(execute(any(), any(), any())).willCallRealMethod()
    given(disposables).willReturn(CompositeDisposable())
}

inline fun <reified T : Any?, reified P : Any> SingleUseCase<T, P>.mock() {
    given(execute(any(), any(), any())).willCallRealMethod()
    given(disposables).willReturn(CompositeDisposable())
}

inline fun <reified T : Any?, reified P : Any> ObservableUseCase<T, P>.mock() {
    given(execute(any(), any(), any(), any())).willCallRealMethod()
    given(disposables).willReturn(CompositeDisposable())
}