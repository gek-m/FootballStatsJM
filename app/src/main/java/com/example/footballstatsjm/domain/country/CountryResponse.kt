package com.example.footballstatsjm.domain.country

import com.google.gson.annotations.SerializedName

data class CountryResponse(

    @SerializedName("response") val response: List<Country>
)
