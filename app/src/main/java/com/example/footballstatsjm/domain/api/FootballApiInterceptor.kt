package com.example.footballstatsjm.domain.api

import com.example.footballstatsjm.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

object FootballApiInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response =
        chain.proceed(
            chain.request()
                .newBuilder()
                .header("x-rapidapi-key", BuildConfig.API_KEY)
                .build()
        )
}