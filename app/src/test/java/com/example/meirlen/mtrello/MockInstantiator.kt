package com.example.meirlen.mtrello

import com.example.meirlen.mtrello.base.constants.Constant

object MockInstantiator {

    const val DEFAULT_ID = "DEFAULT_ID"
    const val DEFAULT_CURRENCY = "USD"
    const val DEFAULT_EMAIL = "default@mail.com"
    const val DEFAULT_ORDER_NUMBER = 5
    const val DEFAULT_PAGINATION_VALUE = "default_pagination_value"


    fun <T> newList(item: T, size: Int = Constant.DEFAULT_PER_PAGE_COUNT): List<T> {
        val list: MutableList<T> = mutableListOf()
        repeat(size) {
            list.add(item)
        }
        return list
    }

}