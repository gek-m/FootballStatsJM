package com.example.footballstatsjm.domain.di.modules

import com.example.footballstatsjm.domain.league.LeagueRepository
import com.example.footballstatsjm.domain.league.LeagueRepositoryImpl
import com.example.footballstatsjm.domain.league.datasource.CloudLeagueDataSource
import com.example.footballstatsjm.domain.league.datasource.LeagueDataSource
import com.example.footballstatsjm.ui.leagues.LeaguesFragment
import dagger.Binds
import dagger.Module
import dagger.Reusable
import dagger.android.ContributesAndroidInjector

@Module
interface LeaguesModule {

    @ContributesAndroidInjector
    fun bindLeaguesFragment(): LeaguesFragment

    @Reusable
    @Binds
    fun bindLeagueRepository(repository: LeagueRepositoryImpl): LeagueRepository

    @Reusable
    @Binds
    fun bindLeagueDataSource(dataSource: CloudLeagueDataSource): LeagueDataSource
}