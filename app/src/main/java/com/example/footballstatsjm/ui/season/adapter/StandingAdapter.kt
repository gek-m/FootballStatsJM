package com.example.footballstatsjm.ui.season.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.footballstatsjm.R.layout.view_standing
import com.example.footballstatsjm.domain.season.Standing
import com.example.footballstatsjm.domain.season.Team

class StandingAdapter(
    private val delegate: Delegate?
) : ListAdapter<Standing, StandingViewHolder>(StandingDiffUtil) {

    interface Delegate {

        fun onTeamSelected(team: Team)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StandingViewHolder =
        StandingViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(view_standing, parent, false)
        )

    override fun onBindViewHolder(holder: StandingViewHolder, position: Int) =
        holder.bind(getItem(position), delegate)
}