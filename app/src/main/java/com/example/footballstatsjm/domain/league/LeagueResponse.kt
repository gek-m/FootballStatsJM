package com.example.footballstatsjm.domain.league

import com.google.gson.annotations.SerializedName

data class LeagueResponse(

    @SerializedName("response") val response: List<LeagueResponseDetails>
)
