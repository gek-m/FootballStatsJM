package com.example.footballstatsjm.domain.season

import com.google.gson.annotations.SerializedName

data class SeasonResponse(

    @SerializedName("response") val response: List<LeagueResponse>
)

data class LeagueResponse(

    @SerializedName("league") val league: League
)

data class League(

    @SerializedName("id") val id: Int,

    @SerializedName("name") val name: String,

    @SerializedName("country") val country: String,

    @SerializedName("logo") val logo: String,

    @SerializedName("flag") val flag: String,

    @SerializedName("season") val season: Int,

    @SerializedName("standings") val standings: List<List<Standing>>
)

data class Standing(

    @SerializedName("rank") val rank: Int,

    @SerializedName("team") val team: Team,

    @SerializedName("points") val points: Int,

    @SerializedName("goalsDiff") val goalsDiff: Int,

    @SerializedName("all") val pointsDetails: PointsDetails
)

data class Team(

    @SerializedName("id") val id: Int,

    @SerializedName("name") val name: String,

    @SerializedName("logo") val logo: String
)

data class PointsDetails(

    @SerializedName("played") val played: Int,

    @SerializedName("win") val win: Int,

    @SerializedName("draw") val draw: Int,

    @SerializedName("lose") val lose: Int,

    @SerializedName("goals") val goals: Goals
)

data class Goals(

    @SerializedName("for") val forGoals: Int,

    @SerializedName("against") val againstGoals: Int,
)