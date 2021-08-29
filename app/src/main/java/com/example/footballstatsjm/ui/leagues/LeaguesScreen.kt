package com.example.footballstatsjm.ui.leagues

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

class LeaguesScreen(
    private val countryCode: String,
    private val countryName: String
) : FragmentScreen{

    override fun createFragment(factory: FragmentFactory): Fragment =
        LeaguesFragment.newInstance(countryCode, countryName)
}