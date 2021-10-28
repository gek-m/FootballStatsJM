package com.example.footballstatsjm

import com.example.footballstatsjm.domain.api.FootballApi
import com.example.footballstatsjm.domain.country.Country
import com.example.footballstatsjm.domain.country.CountryResponse
import com.example.footballstatsjm.domain.country.datasource.CloudCountryDataSource
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class CloudCountryDataSourceTest {

    private lateinit var countryDataSource: CloudCountryDataSource

    @Mock
    private lateinit var footballApi: FootballApi

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        countryDataSource = CloudCountryDataSource(footballApi = footballApi)
    }

    @Test
    fun getCountries_InvokeOnce_test() {
        val response = Mockito.mock(CountryResponse::class.java)
        `when`(footballApi.getCountries()).thenReturn(response)
        countryDataSource.getCountries()

        verify(footballApi, times(1)).getCountries()
    }

    @Test
    fun getCountries_ReturnCountries_Test() {
        val response = Mockito.mock(CountryResponse::class.java)
        val countries = listOf(Mockito.mock(Country::class.java))
        `when`(footballApi.getCountries()).thenReturn(response)
        `when`(response.response).thenReturn(countries)
        countryDataSource.getCountries()

        assertEquals(countries, footballApi.getCountries().response)
    }
}