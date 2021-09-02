package com.example.footballstatsjm.ui.season.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.footballstatsjm.databinding.ViewStandingBinding
import com.example.footballstatsjm.domain.season.Standing
import com.example.footballstatsjm.setStartDrawableCircleImageFromUri

class StandingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    private val viewBinding: ViewStandingBinding by viewBinding()

    fun bind(standing: Standing, delegate: StandingAdapter.Delegate?) {
        with(viewBinding) {
            teamRank.text = "${standing.rank}"
            teamName.setStartDrawableCircleImageFromUri(standing.team.logo)
            teamName.text = standing.team.name
            gamesAmount.text = "${standing.pointsDetails.played}"
            goalsDifferent.text = "${standing.goalsDiff}"
            teamPoints.text = "${standing.points}"
        }

    }
}