package com.example.footballstatsjm.domain.country.datasource

import com.example.footballstatsjm.domain.api.FootballApi
import com.example.footballstatsjm.domain.country.Country
import com.example.footballstatsjm.domain.country.CountryResponse
import io.reactivex.Single
import javax.inject.Inject

class CloudCountryDataSource @Inject constructor(
    private val footballApi: FootballApi
): CountryDataSource {

    /*override fun getCountries(): Single<List<Country>> =
        footballApi
            .getCountries()
            .map { it.response }*/

    override fun getCountries(): List<Country> =
        footballApi
            .getCountries()
            .response
}