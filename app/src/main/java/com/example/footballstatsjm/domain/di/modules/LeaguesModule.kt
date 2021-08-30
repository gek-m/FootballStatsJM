package com.example.footballstatsjm.domain.di.modules

import com.example.footballstatsjm.domain.league.LeagueRepository
import com.example.footballstatsjm.domain.league.LeagueRepositoryImpl
import com.example.footballstatsjm.domain.league.datasource.CloudLeagueDataSource
import com.example.footballstatsjm.domain.league.datasource.LeagueDataSource
import com.example.footballstatsjm.ui.leagues.LeaguesFragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton

@Module
interface LeaguesModule {

    @ContributesAndroidInjector
    fun bindLeaguesFragment(): LeaguesFragment

    @Singleton
    @Binds
    fun bindLeagueRepository(repository: LeagueRepositoryImpl): LeagueRepository

    @Singleton
    @Binds
    fun bindLeagueDataSource(dataSource: CloudLeagueDataSource): LeagueDataSource
}