package com.example.footballstatsjm.ui.season

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

class SeasonScreen(
    private val seasonYear: Int,
    private val leagueId: Int,
    private val leagueName: String
) : FragmentScreen {

    override fun createFragment(factory: FragmentFactory): Fragment =
        SeasonFragment.newInstance(seasonYear.toString(), leagueId.toString(), leagueName)
}