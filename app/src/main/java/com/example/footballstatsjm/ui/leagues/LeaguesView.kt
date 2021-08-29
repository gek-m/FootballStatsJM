package com.example.footballstatsjm.ui.leagues

import com.example.footballstatsjm.domain.league.LeagueResponseDetails
import com.example.footballstatsjm.ui.ScreenView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface LeaguesView : ScreenView {

    @AddToEndSingle
    fun showLeagues(league: List<LeagueResponseDetails>)
}