package com.example.footballstatsjm.ui.leagues.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.footballstatsjm.click
import com.example.footballstatsjm.databinding.ViewSeasonBinding
import com.example.footballstatsjm.domain.season.Season

class SeasonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val viewBinding: ViewSeasonBinding by viewBinding()

    fun bind(season: Season) {
        viewBinding.seasonName.text = season.year.toString()
        /*viewBinding.seasonName.click {
            delegate?.onSeasonSelected(season)
        }*/
    }
}