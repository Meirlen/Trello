package com.example.meirlen.mtrello.routers

import android.content.Context
import com.example.meirlen.mtrello.testing.OpenForTesting


@OpenForTesting
class MainRouter {

    fun showColumns(context: Context?, id: String) {
       // context?.let { it.startActivity(ColumnsActivity.getStartIntent(it, id)) }
    }
}