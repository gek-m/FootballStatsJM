package com.example.footballstatsjm.ui.countries

import com.example.footballstatsjm.domain.country.Country
import com.example.footballstatsjm.ui.ScreenView
import moxy.viewstate.strategy.alias.SingleState

interface CountriesView : ScreenView {

    @SingleState
    fun showCountries(countries: List<Country>)
}