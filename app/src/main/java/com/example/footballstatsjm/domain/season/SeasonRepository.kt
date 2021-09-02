package com.example.footballstatsjm.domain.season

import io.reactivex.Observable

interface SeasonRepository {

    fun getStandings(leagueId: Int, seasonYear: Int): Observable<List<Standing>>
}