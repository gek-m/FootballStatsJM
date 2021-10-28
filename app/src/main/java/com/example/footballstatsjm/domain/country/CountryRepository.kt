package com.example.footballstatsjm.domain.country

import io.reactivex.Observable

interface CountryRepository {

    //fun getCountries(): Observable<List<Country>>

    fun getCountries(): List<Country>
}