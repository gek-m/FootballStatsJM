package com.example.footballstatsjm.domain.season

import com.example.footballstatsjm.domain.season.datasource.SeasonDataSource
import io.reactivex.Observable
import javax.inject.Inject

class SeasonRepositoryImpl @Inject constructor(
    private val cloud: SeasonDataSource
): SeasonRepository {

    override fun getStandings(leagueId: Int, seasonYear: Int): Observable<List<Standing>> =
        cloud.getStandings(seasonYear, leagueId)
            .toObservable()
}