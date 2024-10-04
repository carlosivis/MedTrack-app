package dev.carlosivis.medtrack.domain.medicine.model

data class MedicationDomain(
    val id: Int,
    val name: String,
    val dosage: String,
    val frequency: String,
    val startTime: Long,
    val duration: Int,
    val isActive: Boolean
){
}