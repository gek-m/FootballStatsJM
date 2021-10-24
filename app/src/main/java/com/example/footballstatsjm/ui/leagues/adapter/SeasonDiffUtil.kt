package com.example.footballstatsjm.ui.leagues.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.footballstatsjm.domain.season.Season

object SeasonDiffUtil: DiffUtil.ItemCallback<Season>() {

    private val payload = Any()

    override fun areItemsTheSame(oldItem: Season, newItem: Season): Boolean {
        return oldItem.year == newItem.year
    }

    override fun areContentsTheSame(oldItem: Season, newItem: Season): Boolean {
        return oldItem == newItem
    }

    override fun getChangePayload(oldItem: Season, newItem: Season) = payload
}