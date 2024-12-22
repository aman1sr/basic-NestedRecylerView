package com.aman.basearchsetup.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

/*
* Use the D/OkHttp tag to see logs related to your interceptoR
* */
object HttpClient {
    private val httpLogginInterceptor = HttpLoggingInterceptor().apply {
    HttpLoggingInterceptor.Level.BODY
    }
    val okHttpclient : OkHttpClient =
        OkHttpClient()
            .newBuilder()
            .addInterceptor(AuthTokenInterceptor())
            .addInterceptor(httpLogginInterceptor)
            .build()

}