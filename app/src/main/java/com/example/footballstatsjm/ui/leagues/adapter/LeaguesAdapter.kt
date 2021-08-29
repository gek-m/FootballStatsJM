package com.example.footballstatsjm.ui.leagues.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.footballstatsjm.R
import com.example.footballstatsjm.domain.league.League
import com.example.footballstatsjm.domain.league.LeagueResponseDetails

class LeaguesAdapter(
    private val delegate: Delegate?
) : ListAdapter<LeagueResponseDetails, LeagueViewHolder>(LeagueDiffUtil) {

    interface Delegate {

        fun onLeagueSelected(league: League)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeagueViewHolder =
        LeagueViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.view_league, parent, false)
        )

    override fun onBindViewHolder(holder: LeagueViewHolder, position: Int) =
        holder.bind(getItem(position), delegate)
}