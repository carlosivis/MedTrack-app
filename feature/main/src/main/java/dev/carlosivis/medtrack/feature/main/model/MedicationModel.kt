package dev.carlosivis.medtrack.feature.main.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MedicationModel(
    val id: Int,
    val name: String,
    val dosage: String,
    val frequency: Int,
    val startTime: Long,
    val duration: Int,
    val isActive: Boolean
) : Parcelable
