package com.example.footballstatsjm.domain.league

import io.reactivex.Observable

interface LeagueRepository {

    fun getLeagues(countryCode: String): Observable<List<LeagueResponseDetails>>
}