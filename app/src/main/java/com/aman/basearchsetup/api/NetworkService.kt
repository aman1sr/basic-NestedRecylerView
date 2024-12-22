package com.aman.basearchsetup.api

import com.aman.basearchsetup.model.TopHeadlinesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService {
    @GET("top-headlines")
    suspend fun getTopHeadLines(@Query("country") country: String) : TopHeadlinesResponse

}