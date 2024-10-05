package dev.carlosivis.medtrack.repository.di

import dev.carlosivis.medtrack.domain.medicine.di.domainModule
import dev.carlosivis.medtrack.domain.medicine.repository.MedTrackRepository
import dev.carlosivis.medtrack.repository.repository.MedTrackRepositoryImpl
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

val repositoryModule = module {
    single<MedTrackRepository> { MedTrackRepositoryImpl(get()) }

    loadKoinModules(domainModule)
    TODO("Add repository remote")



}