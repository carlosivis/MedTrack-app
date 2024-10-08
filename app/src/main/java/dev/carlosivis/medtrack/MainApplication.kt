package dev.carlosivis.medtrack

import android.app.Application
import dev.carlosivis.medtrack.data.local.di.localDataSourceModule
import dev.carlosivis.medtrack.repository.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                listOf(
                    localDataSourceModule,
                    repositoryModule
                )
            )
        }.androidContext(this)
    }
}