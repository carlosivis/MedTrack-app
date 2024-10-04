package dev.carlosivis.medtrack.domain.medicine.model

data class PrescriptionDomain(
    val id: Int,
    val medicationId: Int,
    val expiryDate: Long,
    val doctorName: String,
    val doctorContact: String
)
