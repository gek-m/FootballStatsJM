package com.example.footballstatsjm.ui.leagues

import dagger.assisted.AssistedFactory

@AssistedFactory
interface LeaguesPresenterFactory {

    fun create(countryCode: String): LeaguesPresenter
}