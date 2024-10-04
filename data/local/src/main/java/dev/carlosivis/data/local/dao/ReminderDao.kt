package dev.carlosivis.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.carlosivis.data.local.entity.ReminderEntity

@Dao
interface ReminderDao {
    @Query("SELECT * FROM reminders WHERE medicationId = :medicationId")
    suspend fun getRemindersByMedication(medicationId: Int): List<ReminderEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertReminder(reminder: ReminderEntity)

    @Delete
    suspend fun deleteReminder(reminder: ReminderEntity)
}
