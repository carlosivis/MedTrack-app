package dev.carlosivis.medtrack.domain.medicine.model

data class ReminderDomain(
    val id: Int,
    val name: String,
    val medicationId: List<Int>,
    val reminderType: String, // "medication" or "prescription"
    val reminderTime: Long // timestamp of the reminder time
) {
}