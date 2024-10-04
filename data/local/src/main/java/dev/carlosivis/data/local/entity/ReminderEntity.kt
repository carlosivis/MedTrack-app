package dev.carlosivis.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "reminders")
data class ReminderEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val medicationId: Int,
    val reminderType: String, // "medication" or "prescription"
    val reminderTime: Long // timestamp of the reminder time
)
