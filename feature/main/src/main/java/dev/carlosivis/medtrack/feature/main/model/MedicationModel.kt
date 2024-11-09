package dev.carlosivis.medtrack.feature.main.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

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

val EMPTY_MEDICATION_MODEL = MedicationModel(
    id = 0,
    name = "",
    dosage = "",
    frequency = 0,
    startTime = 0,
    duration = 0,
    isActive = false
)
val mockMedicationModel = MedicationModel(
    id = 1,
    name = "Medication One",
    dosage = "500mg",
    frequency = 3,
    startTime = 1729622631,
    duration = 5,
    isActive = true
)

val listMockMedication = listOf<MedicationModel>(
    mockMedicationModel,
    mockMedicationModel,
    mockMedicationModel,
)