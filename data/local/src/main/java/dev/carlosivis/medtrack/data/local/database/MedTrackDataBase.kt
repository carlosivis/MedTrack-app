package dev.carlosivis.medtrack.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.carlosivis.medtrack.data.local.dao.MedicationDao
import dev.carlosivis.medtrack.data.local.dao.PrescriptionDao
import dev.carlosivis.medtrack.data.local.dao.ReminderDao
import dev.carlosivis.medtrack.data.local.entity.MedicationEntity
import dev.carlosivis.medtrack.data.local.entity.PrescriptionEntity
import dev.carlosivis.medtrack.data.local.entity.ReminderEntity

@Database(entities = [MedicationEntity::class, PrescriptionEntity::class, ReminderEntity::class], version = 1)
abstract class MedTrackDataBase : RoomDatabase() {
    abstract fun medicationDao(): MedicationDao
    abstract fun prescriptionDao(): PrescriptionDao
    abstract fun reminderDao(): ReminderDao
}
