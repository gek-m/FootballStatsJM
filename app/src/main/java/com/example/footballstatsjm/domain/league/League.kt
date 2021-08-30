package com.example.footballstatsjm.domain.league

import com.google.gson.annotations.SerializedName

data class League(

    @SerializedName("id") val id: Int,

    @SerializedName("name") val name: String,

    @SerializedName("type") val type: String,

    @SerializedName("logo") val logo: String
)
