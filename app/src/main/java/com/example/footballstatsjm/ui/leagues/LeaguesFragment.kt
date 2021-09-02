package com.example.footballstatsjm.ui.leagues

import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.footballstatsjm.R
import com.example.footballstatsjm.arguments
import com.example.footballstatsjm.databinding.FragmentLeaguesBinding
import com.example.footballstatsjm.domain.league.League
import com.example.footballstatsjm.domain.league.LeagueResponseDetails
import com.example.footballstatsjm.ui.abs.AbsFragment
import com.example.footballstatsjm.ui.leagues.adapter.LeaguesAdapter
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class LeaguesFragment : AbsFragment(R.layout.fragment_leagues), LeaguesView,
    LeaguesAdapter.Delegate {

    companion object {
        private const val ARG_COUNTRY_CODE = "arguments_country_code"
        private const val ARG_COUNTRY_NAME = "arguments_country_name"

        fun newInstance(countryCode: String, countryName: String): Fragment =
            LeaguesFragment()
                .arguments(
                    ARG_COUNTRY_NAME to countryName,
                    ARG_COUNTRY_CODE to countryCode
                )
    }

    private val countryCode: String by lazy {
        arguments?.getString(ARG_COUNTRY_CODE).orEmpty()
    }

    private val countryName: String by lazy {
        arguments?.getString(ARG_COUNTRY_NAME).orEmpty()
    }

    @Inject
    lateinit var leaguesPresenterFactory: LeaguesPresenterFactory

    private val presenter: LeaguesPresenter by moxyPresenter {
        leaguesPresenterFactory.create(countryCode = countryCode)
    }

    private val leaguesAdapter = LeaguesAdapter(delegate = this)
    private val viewBinding: FragmentLeaguesBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.country.text = countryName
        viewBinding.leagues.adapter = leaguesAdapter

    }

    override fun showLeagues(leagues: List<LeagueResponseDetails>) {
        leaguesAdapter.submitList(leagues)

        viewBinding.progress.visibility = GONE
        viewBinding.leagues.visibility = VISIBLE
    }

    override fun showError(error: Throwable) {
        Toast.makeText(requireContext(), error.message, Toast.LENGTH_LONG).show()
    }

    override fun onLeagueSelected(leagueResponseDetails: LeagueResponseDetails) {
        presenter.displayLeagueSeason(
            leagueResponseDetails = leagueResponseDetails
        )
    }
}