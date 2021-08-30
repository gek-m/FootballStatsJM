package com.example.footballstatsjm.ui.leagues.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.footballstatsjm.domain.league.League
import com.example.footballstatsjm.domain.league.LeagueResponseDetails

object LeagueDiffUtil: DiffUtil.ItemCallback<LeagueResponseDetails>() {

    private val payload = Any()

    override fun areItemsTheSame(oldItem: LeagueResponseDetails, newItem: LeagueResponseDetails): Boolean {
        return oldItem.league.id == newItem.league.id
    }

    override fun areContentsTheSame(oldItem: LeagueResponseDetails, newItem: LeagueResponseDetails): Boolean {
        return oldItem == newItem
    }

    override fun getChangePayload(oldItem: LeagueResponseDetails, newItem: LeagueResponseDetails) = payload
}