package dev.carlosivis.medtrack.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.carlosivis.medtrack.data.local.entity.ReminderEntity

@Dao
interface ReminderDao {
    @Query("SELECT * FROM reminders WHERE medicationId = :medicationId")
    fun getRemindersByMedication(medicationId: Int): List<ReminderEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertReminder(reminder: ReminderEntity)

    @Delete
    fun deleteReminder(reminder: ReminderEntity)
}
