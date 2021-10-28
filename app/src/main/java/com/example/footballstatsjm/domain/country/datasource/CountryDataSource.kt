package com.example.footballstatsjm.domain.country.datasource

import com.example.footballstatsjm.domain.country.Country
import com.example.footballstatsjm.domain.country.CountryResponse
import io.reactivex.Single

interface CountryDataSource {

    //fun getCountries(): Single<List<Country>>
    fun getCountries(): List<Country>
}