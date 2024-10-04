package dev.carlosivis.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.carlosivis.data.local.dao.MedicationDao
import dev.carlosivis.data.local.dao.PrescriptionDao
import dev.carlosivis.data.local.dao.ReminderDao
import dev.carlosivis.data.local.entity.MedicationEntity
import dev.carlosivis.data.local.entity.PrescriptionEntity
import dev.carlosivis.data.local.entity.ReminderEntity

@Database(entities = [MedicationEntity::class, PrescriptionEntity::class, ReminderEntity::class], version = 1)
abstract class MedTrackDataBase : RoomDatabase() {
    abstract fun medicationDao(): MedicationDao
    abstract fun prescriptionDao(): PrescriptionDao
    abstract fun reminderDao(): ReminderDao
}
