package com.example.footballstatsjm.ui.countries.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.footballstatsjm.R
import com.example.footballstatsjm.domain.country.Country

class CountriesAdapter (
    private val delegate: Delegate?
) : ListAdapter<Country, CountryViewHolder>(CountriesDiffUtil) {

    interface Delegate {

        fun onCountySelected(user: Country)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder =
        CountryViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.view_country, parent, false)
        )

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) =
        holder.bind(getItem(position), delegate)

}