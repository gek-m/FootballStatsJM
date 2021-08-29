package com.example.footballstatsjm.ui.leagues

import com.example.footballstatsjm.domain.league.LeagueRepository
import com.example.footballstatsjm.domain.league.LeagueResponseDetails
import com.example.footballstatsjm.schedulers.Schedulers
import com.github.terrakok.cicerone.Router
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import moxy.MvpPresenter

class LeaguesPresenter @AssistedInject constructor(
    @Assisted private val countryCode: String,
    private val router: Router,
    private val leagueRepository: LeagueRepository,
    private val schedulers: Schedulers
) : MvpPresenter<LeaguesView>() {

    private val disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        disposables +=
            leagueRepository
                .getLeagues(countryCode = countryCode)
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.background())
                .subscribe(
                    ::onLeaguesSuccess,
                    viewState::showError
                )
    }

    private fun onLeaguesSuccess(leagues: List<LeagueResponseDetails>) {
        viewState.showLeagues(leagues)
    }

    override fun onDestroy() {
        disposables.clear()
    }
}