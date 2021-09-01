package com.example.footballstatsjm.domain.league.datasource

import com.example.footballstatsjm.domain.league.LeagueResponseDetails
import io.reactivex.Single

interface LeagueDataSource {

    fun getLeagues(countryCode: String): Single<List<LeagueResponseDetails>>
}