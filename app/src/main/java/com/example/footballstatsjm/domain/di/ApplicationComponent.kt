package com.example.footballstatsjm.domain.di

import android.content.Context
import com.example.footballstatsjm.FootballStats
import com.example.footballstatsjm.domain.di.modules.ApiModule
import com.example.footballstatsjm.domain.di.modules.CountriesModule
import com.example.footballstatsjm.schedulers.Schedulers
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidInjectionModule::class, ApiModule::class, CountriesModule::class]
)
interface ApplicationComponent : AndroidInjector<FootballStats> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun withContext(context: Context): Builder

        @BindsInstance
        fun withRouter(router: Router): Builder

        @BindsInstance
        fun withNavigationHolder(navigatorHolder: NavigatorHolder): Builder

        @BindsInstance
        fun withSchedulers(schedulers: Schedulers): Builder

        fun build(): ApplicationComponent
    }
}