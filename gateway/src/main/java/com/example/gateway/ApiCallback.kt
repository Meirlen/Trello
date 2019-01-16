package com.example.gateway

interface ApiCallback<in T> {

     fun onResult(result: T)

     fun onFailure(error: Error)
}
