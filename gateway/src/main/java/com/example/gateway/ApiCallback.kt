package com.shopapp.gateway

interface ApiCallback<in T> {

     fun onResult(result: T)

     fun onFailure(error: Error)
}
