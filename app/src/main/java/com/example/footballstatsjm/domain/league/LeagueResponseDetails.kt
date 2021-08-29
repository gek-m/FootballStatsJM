package com.example.footballstatsjm.domain.league

import com.example.footballstatsjm.domain.country.Country
import com.google.gson.annotations.SerializedName

data class LeagueResponseDetails(

    @SerializedName("league") val league: League,

    @SerializedName("country") val country: Country
)
