package com.example.footballstatsjm.ui.season

import com.example.footballstatsjm.domain.season.Standing
import com.example.footballstatsjm.ui.ScreenView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface SeasonView : ScreenView {

    @AddToEndSingle
    fun showStanding(standings: List<Standing>)
}