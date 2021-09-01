package com.example.footballstatsjm.ui.season

import com.example.footballstatsjm.domain.season.SeasonRepository
import com.example.footballstatsjm.domain.season.Standing
import com.example.footballstatsjm.schedulers.Schedulers
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import moxy.MvpPresenter

class SeasonPresenter @AssistedInject constructor(
    @Assisted("season") private val seasonYear: Int,
    @Assisted("leagueId") private val leagueId: Int,
    private val seasonRepository: SeasonRepository,
    private val schedulers: Schedulers
) : MvpPresenter<SeasonView>() {

    private val disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        disposables +=
            seasonRepository
                .getStandings(leagueId, seasonYear)
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.background())
                .subscribe(
                    ::onSeasonSuccess,
                    viewState::showError
                )
    }

    private fun onSeasonSuccess(standings: List<Standing>) {
        viewState.showStanding(standings)
    }

    override fun onDestroy() {
        disposables.clear()
    }
}