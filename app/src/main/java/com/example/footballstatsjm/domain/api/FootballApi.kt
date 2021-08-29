package com.example.footballstatsjm.domain.api

import com.example.footballstatsjm.domain.country.CountryResponse
import com.example.footballstatsjm.domain.league.LeagueResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface FootballApi {

    @GET("/countries")
    fun getCountries(): Single<CountryResponse>

    @GET("/leagues")
    fun getLeagues(@Query("code") code: String): Single<LeagueResponse>
}