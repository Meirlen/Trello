package com.example.meirlen.mtrello.base.ui

import androidx.annotation.StringRes
import com.example.gateway.entity.Error

interface BaseLceView<in T> {

    fun showContent(data: T)

    fun showLoading(isTranslucent: Boolean = false)

    fun showEmptyState()

    fun showError(error: Error)

    fun showMessage(@StringRes messageRes: Int)

    fun showMessage(message: String)

    fun showActionError(action: String) {

    }

}