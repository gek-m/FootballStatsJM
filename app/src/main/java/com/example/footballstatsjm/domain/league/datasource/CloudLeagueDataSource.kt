package com.example.footballstatsjm.domain.league.datasource

import com.example.footballstatsjm.domain.api.FootballApi
import com.example.footballstatsjm.domain.league.League
import com.example.footballstatsjm.domain.league.LeagueResponseDetails
import io.reactivex.Single
import javax.inject.Inject

class CloudLeagueDataSource @Inject constructor(
    private val footballApi: FootballApi
) : LeagueDataSource {

    override fun getLeagues(countryCode: String): Single<List<LeagueResponseDetails>> =
        footballApi
            .getLeagues(code = countryCode)
            .map { it.response }
}