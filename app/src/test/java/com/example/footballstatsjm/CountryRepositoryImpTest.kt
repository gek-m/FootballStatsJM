package com.example.footballstatsjm

import com.example.footballstatsjm.domain.country.Country
import com.example.footballstatsjm.domain.country.CountryRepository
import com.example.footballstatsjm.domain.country.CountryRepositoryImp
import com.example.footballstatsjm.domain.country.CountryResponse
import com.example.footballstatsjm.domain.country.datasource.CountryDataSource
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations

class CountryRepositoryImpTest {

    private lateinit var repository: CountryRepository

    @Mock
    private lateinit var countryDataSource: CountryDataSource

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        repository = CountryRepositoryImp(countryDataSource)
    }

    @Test
    fun getCountries_InvokeOnce_test() {
        val countries = listOf(mock(Country::class.java))
        `when`(repository.getCountries()).thenReturn(countries)
        repository.getCountries()
        verify(countryDataSource, times(1)).getCountries()
    }

    @Test
    fun getCountries_ReturnCountries_Test() {
        val countries = listOf(mock(Country::class.java))
        `when`(repository.getCountries()).thenReturn(countries)
        countryDataSource.getCountries()

        assertEquals(countries, countryDataSource.getCountries())
    }
}