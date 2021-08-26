package com.example.footballstatsjm.domain.api

import com.example.footballstatsjm.domain.country.CountryResponse
import io.reactivex.Single
import retrofit2.http.GET

interface FootballApi {

    @GET("/countries")
    fun getCountries(): Single<CountryResponse>
}