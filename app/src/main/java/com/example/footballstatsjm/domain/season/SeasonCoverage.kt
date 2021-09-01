package com.example.footballstatsjm.domain.season

import com.google.gson.annotations.SerializedName

data class SeasonCoverage(

    @SerializedName("standings") val standings: Boolean
)
