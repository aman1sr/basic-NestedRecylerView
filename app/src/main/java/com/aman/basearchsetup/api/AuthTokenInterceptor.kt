package com.aman.basearchsetup.api

import com.aman.basearchsetup.utils.AppConstant
import okhttp3.Interceptor
import okhttp3.Response

class AuthTokenInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalReq = chain.request()
        val reqBuilder = originalReq.newBuilder().header("X-Api-Key", AppConstant.apiKey)
        val req = reqBuilder.build()
        return chain.proceed(req)
    }
}