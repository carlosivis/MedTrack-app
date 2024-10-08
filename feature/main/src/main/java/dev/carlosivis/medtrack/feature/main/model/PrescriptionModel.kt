package dev.carlosivis.medtrack.feature.main.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PrescriptionModel(
    val id: Int,
    val medicationId: List<Int>,
    val expiryDate: Long,
    val doctorName: String,
    val doctorContact: String
): Parcelable
