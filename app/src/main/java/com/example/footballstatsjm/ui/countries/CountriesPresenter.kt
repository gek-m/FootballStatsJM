package com.example.footballstatsjm.ui.countries

import com.example.footballstatsjm.domain.country.Country
import com.example.footballstatsjm.domain.country.CountryRepository
import com.example.footballstatsjm.schedulers.Schedulers
import com.github.terrakok.cicerone.Router
import dagger.assisted.AssistedInject
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import moxy.MvpPresenter

class CountriesPresenter @AssistedInject constructor(
    private val countryRepository: CountryRepository,
    private val router: Router,
    private val schedulers: Schedulers
) : MvpPresenter<CountriesView>() {

    private val disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        disposables +=
            countryRepository
                .getCountries()
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.background())
                .subscribe(
                    ::onCountriesSuccess,
                    viewState::showError
                )
    }

    private fun onCountriesSuccess(countries: List<Country>) {
        viewState.showCountries(countries = countries)
    }

    override fun onDestroy() {
        disposables.clear()
    }
}