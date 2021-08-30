package com.example.footballstatsjm.ui.countries.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.footballstatsjm.domain.country.Country

object CountriesDiffUtil: DiffUtil.ItemCallback<Country>() {

    private val payload = Any()

    override fun areItemsTheSame(oldItem: Country, newItem: Country): Boolean {
        return oldItem.code == newItem.code
    }

    override fun areContentsTheSame(oldItem: Country, newItem: Country): Boolean {
        return oldItem == newItem
    }

    override fun getChangePayload(oldItem: Country, newItem: Country) = payload
}