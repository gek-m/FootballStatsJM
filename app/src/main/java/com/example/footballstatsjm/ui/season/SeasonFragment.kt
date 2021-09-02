package com.example.footballstatsjm.ui.season

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.footballstatsjm.R
import com.example.footballstatsjm.arguments
import com.example.footballstatsjm.databinding.FragmentSeasonBinding
import com.example.footballstatsjm.domain.season.Standing
import com.example.footballstatsjm.domain.season.Team
import com.example.footballstatsjm.ui.abs.AbsFragment
import com.example.footballstatsjm.ui.season.adapter.StandingAdapter
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class SeasonFragment : AbsFragment(R.layout.fragment_season), SeasonView, StandingAdapter.Delegate {

    companion object {
        private const val ARG_LEAGUE_ID = "arguments_league_id"
        private const val ARG_LEAGUE_NAME = "arguments_league_name"
        private const val ARG_SEASON_YEAR = "arguments_season_year"

        fun newInstance(seasonYear: String, leagueId: String, leagueName: String): Fragment =
            SeasonFragment()
                .arguments(
                    ARG_SEASON_YEAR to seasonYear,
                    ARG_LEAGUE_ID to leagueId,
                    ARG_LEAGUE_NAME to leagueName
                )
    }

    private val seasonYear: Int by lazy {
        arguments?.getString(ARG_SEASON_YEAR).orEmpty().toInt()
    }

    private val leagueId: Int by lazy {
        arguments?.getString(ARG_LEAGUE_ID).orEmpty().toInt()
    }

    private val leagueName: String by lazy {
        arguments?.getString(ARG_LEAGUE_NAME).orEmpty()
    }

    @Inject
    lateinit var seasonPresenterFactory: SeasonPresenterFactory

    private val presenter: SeasonPresenter by moxyPresenter {
        seasonPresenterFactory.create(
            seasonYear = seasonYear,
            leagueId = leagueId
        )
    }

    private val standingAdapter = StandingAdapter(delegate = this)
    private val viewBinding: FragmentSeasonBinding by viewBinding()

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.leagueName.text = leagueName
        viewBinding.seasonYear.text = "Season $seasonYear"

        viewBinding.standing.adapter = standingAdapter
    }

    override fun showStanding(standings: List<Standing>) {
        standingAdapter.submitList(standings)

        viewBinding.progress.visibility = View.GONE
        viewBinding.standing.visibility = View.VISIBLE
    }

    override fun showError(error: Throwable) {
        Toast.makeText(requireContext(), error.message, Toast.LENGTH_LONG).show()
    }

    override fun onTeamSelected(team: Team) {
        TODO("Not yet implemented")
    }
}