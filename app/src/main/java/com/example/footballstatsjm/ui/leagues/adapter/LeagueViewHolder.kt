package com.example.footballstatsjm.ui.leagues.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.footballstatsjm.click
import com.example.footballstatsjm.databinding.ViewLeagueBinding
import com.example.footballstatsjm.domain.league.LeagueResponseDetails
import com.example.footballstatsjm.setStartDrawableCircleImageFromUri

class LeagueViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val viewBinding: ViewLeagueBinding by viewBinding()

    fun bind(league: LeagueResponseDetails, delegate: LeaguesAdapter.Delegate?) {
        with(viewBinding) {
            leagueName.setStartDrawableCircleImageFromUri(league.league.logo)
            leagueName.text = league.league.name

            leagueName.click {
                seasonName.apply {
                    visibility = if (this.visibility == View.GONE) View.VISIBLE else View.GONE
                }
            }
            seasonName.click {
                delegate?.onLeagueSelected(league)
            }
        }

    }
}