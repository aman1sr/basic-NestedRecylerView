package com.aman.basearchsetup.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

object HttpClient {
    private val httpLogginInterceptor = HttpLoggingInterceptor().apply {
    HttpLoggingInterceptor.Level.BASIC
    }
    val okHttpclient : OkHttpClient =
        OkHttpClient()
            .newBuilder()
            .addInterceptor(AuthTokenInterceptor())
            .addInterceptor(httpLogginInterceptor)
            .build()

}