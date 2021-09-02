package com.example.footballstatsjm.ui.countries

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.footballstatsjm.R
import com.example.footballstatsjm.arguments
import com.example.footballstatsjm.databinding.ViewCountriesBinding
import com.example.footballstatsjm.domain.country.Country
import com.example.footballstatsjm.ui.abs.AbsFragment
import com.example.footballstatsjm.ui.countries.adapter.CountriesAdapter
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class CountriesFragment : AbsFragment(R.layout.view_countries),
    CountriesView, CountriesAdapter.Delegate {

    companion object {

        fun newInstance(): Fragment =
            CountriesFragment()
                .arguments()
    }

    @Inject
    lateinit var countriesPresenterFactory: CountriesPresenterFactory

    private val presenter: CountriesPresenter by moxyPresenter {
        countriesPresenterFactory.create()
    }

    private val countriesAdapter = CountriesAdapter(delegate = this)
    private val viewBinding: ViewCountriesBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.countries.adapter = countriesAdapter
    }

    override fun showCountries(countries: List<Country>) {
        countriesAdapter.submitList(countries)
    }

    override fun showError(error: Throwable) {
        Toast.makeText(requireContext(), error.message, Toast.LENGTH_LONG).show()
    }

    override fun onCountySelected(country: Country) {
        presenter.displayLeagues(country)
    }
}