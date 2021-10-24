package com.example.footballstatsjm.ui.leagues.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.footballstatsjm.R
import com.example.footballstatsjm.domain.season.Season

class SeasonAdapter(
    //private val delegate: Delegate?
) : ListAdapter<Season, SeasonViewHolder>(SeasonDiffUtil) {

    interface Delegate {

        fun onSeasonSelected(season: Season)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeasonViewHolder =
        SeasonViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.view_league, parent, false)
        )

    override fun onBindViewHolder(holder: SeasonViewHolder, position: Int) =
        holder.bind(getItem(position)) //, delegate)
}