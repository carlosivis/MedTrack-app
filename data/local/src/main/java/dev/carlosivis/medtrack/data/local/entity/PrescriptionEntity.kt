package dev.carlosivis.medtrack.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "prescriptions")
data class PrescriptionEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val medicationId: Int, // relationship with the medication
    val expiryDate: Long, // timestamp of the prescription expiry date
    val doctorName: String,
    val doctorContact: String
)
