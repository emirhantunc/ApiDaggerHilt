package com.example.ncore

import retrofit2.http.GET

interface MyApi {
    @GET("posts")
    suspend fun getPosts(): List<DataClass>
}