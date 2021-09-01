package com.example.footballstatsjm.ui.season

import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory

@AssistedFactory
interface SeasonPresenterFactory {

    fun create(
        @Assisted("season")seasonYear: Int,

        @Assisted("leagueId")leagueId: Int): SeasonPresenter
}