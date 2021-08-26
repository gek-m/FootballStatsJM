package com.example.footballstatsjm.domain.di.modules

import com.example.footballstatsjm.MainActivity
import com.example.footballstatsjm.domain.country.CountryRepository
import com.example.footballstatsjm.domain.country.CountryRepositoryImp
import com.example.footballstatsjm.domain.country.datasource.CloudCountryDataSource
import com.example.footballstatsjm.domain.country.datasource.CountryDataSource
import com.example.footballstatsjm.ui.countries.CountriesFragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton

@Module
interface CountriesModule {

    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    fun bindCountriesFragment(): CountriesFragment

    @Singleton
    @Binds
    fun bindCountryRepository(repository: CountryRepositoryImp): CountryRepository

    @Singleton
    @Binds
    fun bindCountryDataSource(dataSource: CloudCountryDataSource): CountryDataSource
}