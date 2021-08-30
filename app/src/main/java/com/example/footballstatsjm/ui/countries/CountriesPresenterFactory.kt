package com.example.footballstatsjm.ui.countries

import dagger.assisted.AssistedFactory

@AssistedFactory
interface CountriesPresenterFactory {

    fun create(): CountriesPresenter
}