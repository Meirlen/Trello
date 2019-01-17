package com.example.domain.interactor.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class UseCase {

    protected var lastDisposable: Disposable? = null
    var disposables: CompositeDisposable = CompositeDisposable()



    protected fun disposeLatest() {
        lastDisposable?.let {
            if (!it.isDisposed) {
                it.dispose()
            }
        }
    }


    fun dispose() {
        disposables.clear()
    }

}