package com.example.footballstatsjm.domain.league

import com.example.footballstatsjm.domain.league.datasource.LeagueDataSource
import io.reactivex.Observable
import javax.inject.Inject

class LeagueRepositoryImpl @Inject constructor(
    private val cloud: LeagueDataSource
) : LeagueRepository {

    override fun getLeagues(countryCode: String): Observable<List<LeagueResponseDetails>> =
        cloud.getLeagues(countryCode = countryCode)
            .toObservable()
}