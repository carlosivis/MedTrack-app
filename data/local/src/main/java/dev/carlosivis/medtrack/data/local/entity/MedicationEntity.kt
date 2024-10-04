package dev.carlosivis.medtrack.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "medications")
data class MedicationEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val dosage: String,
    val frequency: Int, // in hours
    val startTime: Long, // timestamp for when to start the treatment
    val duration: Int, // duration in days
    val isActive: Boolean = true
){

}

