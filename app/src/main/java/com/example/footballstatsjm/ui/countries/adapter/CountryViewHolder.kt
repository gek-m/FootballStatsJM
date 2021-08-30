package com.example.footballstatsjm.ui.countries.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.footballstatsjm.R
import com.example.footballstatsjm.click
import com.example.footballstatsjm.domain.country.Country
import com.example.footballstatsjm.setStartDrawableCircleImageFromUri

class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(country: Country, delegate: CountriesAdapter.Delegate?) {

        val countryName: TextView = itemView.findViewById(R.id.country)
        //countryName.setStartDrawableCircleImageFromUri(country.flag)
        countryName.text = country.name

        countryName.click {
            delegate?.onCountySelected(country)
        }
    }
}