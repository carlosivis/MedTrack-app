package dev.carlosivis.medtrack.data.local.di

import androidx.room.Room
import dev.carlosivis.medtrack.data.local.database.MedTrackDataBase
import dev.carlosivis.medtrack.data.local.datasource.MedTrackLocalDataSourceImpl
import dev.carlosivis.medtrack.repository.datasource.local.MedTrackLocalDataSource
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val localDataSourceModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            MedTrackDataBase::class.java,
            "medtrack_database"
        ).build()
    }
    single {
        val db =get<MedTrackDataBase>()
        db.medicationDao()
        db.prescriptionDao()
        db.reminderDao()
    }

    single<MedTrackLocalDataSource> { MedTrackLocalDataSourceImpl(get(), get(), get()) }
}