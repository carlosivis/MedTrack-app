package dev.carlosivis.medtrack.feature.main.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PrescriptionModel(
    val id: Int,
    val medicationId: List<Int>,
    val expiryDate: Long,
    val doctorName: String,
    val doctorContact: String
): Parcelable

val mockPrescriptionModel = PrescriptionModel(
    id = 1,
    medicationId = listOf(1,2),
    expiryDate = 1729622631,
    doctorName = "Dr. John Doe",
    doctorContact = "123-456-7890"
)