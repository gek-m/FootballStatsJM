package com.example.footballstatsjm.domain.season.datasource

import com.example.footballstatsjm.domain.api.FootballApi
import com.example.footballstatsjm.domain.season.Standing
import io.reactivex.Single
import javax.inject.Inject

class CloudSeasonDataSource @Inject constructor(
    private val footballApi: FootballApi
) : SeasonDataSource {

    override fun getStandings(seasonYear: Int, leagueId: Int): Single<List<Standing>> =
        footballApi.getStandings(
            seasonYear = seasonYear,
            leagueId = leagueId
        ).map { it.response[0].league.standings[0] }
}