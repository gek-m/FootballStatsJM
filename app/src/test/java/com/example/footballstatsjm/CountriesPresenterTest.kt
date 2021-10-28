package com.example.footballstatsjm

import com.example.footballstatsjm.domain.country.Country
import com.example.footballstatsjm.domain.country.CountryRepository
import com.example.footballstatsjm.schedulers.Schedulers
import com.example.footballstatsjm.ui.ScreenView
import com.example.footballstatsjm.ui.countries.CountriesPresenter
import com.example.footballstatsjm.ui.countries.CountriesView
import com.example.footballstatsjm.ui.leagues.LeaguesScreen
import com.github.terrakok.cicerone.Router
import com.nhaarman.mockito_kotlin.atLeast
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

class CountriesPresenterTest {

    private lateinit var presenter: CountriesPresenter

    @Mock
    private lateinit var repository: CountryRepository

    @Mock
    private lateinit var router: Router

    @Mock
    private lateinit var schedulers: Schedulers

    @Mock
    private lateinit var view: CountriesView

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = CountriesPresenter(
            countryRepository = repository,
            router = router,
            schedulers = schedulers
        )
        presenter.attachView(view)
    }

    @Test
    fun getCounties_RunOnce_test() {
        val countries = listOf(mock(Country::class.java))
        `when`(repository.getCountries()).thenReturn(countries)
        repository.getCountries()
        verify(repository, times(1)).getCountries()
    }

    @Test
    fun presenter_ToLeaguesScreen_Test() {
        val leaguesScreen = mock(LeaguesScreen::class.java)
        val country = mock(Country::class.java)
        //`when`(presenter.displayLeagues(country)).thenReturn(any())
        presenter.displayLeagues(country)
        verify(router, atLeastOnce()).navigateTo(leaguesScreen)
    }
}