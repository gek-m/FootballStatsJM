package com.example.footballstatsjm.domain.season.datasource

import com.example.footballstatsjm.domain.season.Standing
import io.reactivex.Single

interface SeasonDataSource {

    fun getStandings(seasonYear: Int, leagueId: Int): Single<List<Standing>>
}