package com.example.footballstatsjm.ui.season.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.footballstatsjm.domain.season.Standing

object StandingDiffUtil: DiffUtil.ItemCallback<Standing>() {

    private val payload = Any()

    override fun areItemsTheSame(oldItem: Standing, newItem: Standing): Boolean {
        return oldItem.rank == newItem.rank
    }

    override fun areContentsTheSame(oldItem: Standing, newItem: Standing): Boolean {
        return oldItem == newItem
    }

    override fun getChangePayload(oldItem: Standing, newItem: Standing) = payload
}