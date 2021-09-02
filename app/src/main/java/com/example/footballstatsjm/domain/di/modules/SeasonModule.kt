package com.example.footballstatsjm.domain.di.modules

import com.example.footballstatsjm.domain.season.SeasonRepository
import com.example.footballstatsjm.domain.season.SeasonRepositoryImpl
import com.example.footballstatsjm.domain.season.datasource.CloudSeasonDataSource
import com.example.footballstatsjm.domain.season.datasource.SeasonDataSource
import com.example.footballstatsjm.ui.season.SeasonFragment
import dagger.Binds
import dagger.Module
import dagger.Reusable
import dagger.android.ContributesAndroidInjector

@Module
interface SeasonModule {

    @ContributesAndroidInjector
    fun bindSeasonFragment(): SeasonFragment

    @Reusable
    @Binds
    fun bindSeasonRepository(repository: SeasonRepositoryImpl): SeasonRepository

    @Reusable
    @Binds
    fun bindSeasonDataSource(dataSource: CloudSeasonDataSource): SeasonDataSource
}