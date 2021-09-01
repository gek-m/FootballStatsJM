package com.example.footballstatsjm

import com.example.footballstatsjm.domain.di.DaggerApplicationComponent
import com.example.footballstatsjm.schedulers.AppSchedulers
import com.github.terrakok.cicerone.Cicerone
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import io.reactivex.plugins.RxJavaPlugins

class FootballStats : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<FootballStats> =
        DaggerApplicationComponent
            .builder()
            .withContext(applicationContext)
            .apply {
                val cicerone = Cicerone.create()

                withNavigationHolder(cicerone.getNavigatorHolder())
                withRouter(cicerone.router)
                withSchedulers(AppSchedulers())
            }
            .build()

    /*override fun onCreate() {
        super.onCreate()
        RxJavaPlugins.setErrorHandler { }
    }*/
}