package com.aman.basearchsetup.utils

import com.aman.basearchsetup.BuildConfig

object AppConstant {
    val apiKey by lazy {
        BuildConfig.NEWS_API_KEY        // generate your API key from newsapi.org
    }
}