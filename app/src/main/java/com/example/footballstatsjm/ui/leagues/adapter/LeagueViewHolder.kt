package com.example.footballstatsjm.ui.leagues.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.footballstatsjm.R
import com.example.footballstatsjm.click
import com.example.footballstatsjm.domain.league.LeagueResponseDetails
import com.example.footballstatsjm.setStartDrawableCircleImageFromUri

class LeagueViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(league: LeagueResponseDetails, delegate: LeaguesAdapter.Delegate?) {

        val leagueName: TextView = itemView.findViewById(R.id.leagueName)
        leagueName.setStartDrawableCircleImageFromUri(league.league.logo)
        leagueName.text = league.league.name

        leagueName.click {
            delegate?.onLeagueSelected(league)
        }
    }
}