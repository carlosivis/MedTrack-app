package dev.carlosivis.medtrack.feature.main.model

import android.os.Parcelable
import dev.carlosivis.medtrack.domain.medicine.model.PrescriptionDomain
import kotlinx.parcelize.Parcelize

@Parcelize
data class PrescriptionModel(
    val id: Int,
    val medicationId: List<Int>,
    val expiryDate: Long,
    val doctorName: String,
    val doctorContact: String
): Parcelable

val EMPTY_PRESCRIPTION_MODEL = PrescriptionModel(
    id = 0,
    medicationId = listOf(),
    expiryDate = 0,
    doctorName = "",
    doctorContact = ""
)
fun PrescriptionModel.toDomain(): PrescriptionDomain =
    PrescriptionDomain(
        id = id,
        medicationId = medicationId,
        expiryDate = expiryDate,
        doctorName = doctorName,
        doctorContact = doctorContact
    )

val mockPrescriptionModel = PrescriptionModel(
    id = 1,
    medicationId = listOf(1,2),
    expiryDate = 1729622631,
    doctorName = "Dr. John Doe",
    doctorContact = "123-456-7890"
)
val mockPrescriptionModel2 = PrescriptionModel(
    id = 2,
    medicationId = listOf(1,2),
    expiryDate = 1929622631,
    doctorName = "Dr. John Doe",
    doctorContact = "123-456-7890"
)

val listMockPrescription = listOf(mockPrescriptionModel, mockPrescriptionModel2)