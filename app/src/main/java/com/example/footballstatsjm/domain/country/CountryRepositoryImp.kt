package com.example.footballstatsjm.domain.country

import com.example.footballstatsjm.domain.country.datasource.CountryDataSource
import io.reactivex.Observable
import javax.inject.Inject

class CountryRepositoryImp @Inject constructor(
    private val cloud: CountryDataSource
) : CountryRepository {

    override fun getCountries(): Observable<List<Country>> =
        cloud.getCountries().toObservable()
}