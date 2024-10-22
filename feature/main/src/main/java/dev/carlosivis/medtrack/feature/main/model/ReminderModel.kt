package dev.carlosivis.medtrack.feature.main.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class ReminderModel(
    val id: Int,
    val name: String,
    val medicationId: List<Int>,
    val reminderType: String, // "medication" or "prescription"
    val reminderTime: Long
) : Parcelable

val mockReminder = ReminderModel(
    id = 1,
    name = "Reminder One",
    medicationId = listOf(1, 2),
    reminderType = "medication",
    reminderTime = 1729622631000
)
val mockReminder1 = ReminderModel(
    id = 2,
    name = "Reminder",
    medicationId = listOf(1, 2,4),
    reminderType = "medication",
    reminderTime = 1829622631000
)
val mockReminder2 = ReminderModel(
    id = 3,
    name = "Reminder Number 3",
    medicationId = listOf(1,),
    reminderType = "medication",
    reminderTime = 1799622631000
)
val listMockReminder = listOf<ReminderModel>(
    mockReminder,
    mockReminder1,
    mockReminder2
)