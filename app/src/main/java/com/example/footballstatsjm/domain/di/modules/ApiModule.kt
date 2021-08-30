package com.example.footballstatsjm.domain.di.modules

import com.example.footballstatsjm.domain.api.FootballApi
import com.example.footballstatsjm.domain.api.FootballApiInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApiModule {

    @Singleton
    @Provides
    fun provideGitHubApi(): FootballApi =
        Retrofit.Builder()
            .baseUrl("https://v3.football.api-sports.io/")
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(FootballApiInterceptor)
                    .addInterceptor(HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    })
                    .build()
            )
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(FootballApi::class.java)

    private val gson: Gson
        get() = GsonBuilder()
            .create()
}