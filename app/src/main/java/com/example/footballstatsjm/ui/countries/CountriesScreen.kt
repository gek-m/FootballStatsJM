package com.example.footballstatsjm.ui.countries

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

object CountriesScreen : FragmentScreen {

    override fun createFragment(factory: FragmentFactory): Fragment =
        CountriesFragment.newInstance()
}