package dev.carlosivis.medtrack.domain.medicine.repository

import dev.carlosivis.medtrack.core.commons.base.Either
import dev.carlosivis.medtrack.domain.medicine.model.MedicationDomain
import dev.carlosivis.medtrack.domain.medicine.model.PrescriptionDomain
import dev.carlosivis.medtrack.domain.medicine.model.ReminderDomain
import kotlinx.coroutines.flow.Flow

interface MedTrackRepository {

    suspend fun saveMedication(medication: MedicationDomain): Flow<Either<Unit>>
    suspend fun getActiveMedications(): Flow<Either<List<MedicationDomain>>>
    suspend fun getInactiveMedications(): Flow<Either<List<MedicationDomain>>>
    suspend fun updateMedicationStatus(medicationId: Int, isActive: Boolean): Either<Unit>
    suspend fun deleteMedication(medication: MedicationDomain): Either<Unit>

    suspend fun savePrescription(prescription: PrescriptionDomain): Flow<Either<Unit>>
    suspend fun getPrescriptionsByMedication(medicationsIds: List<Int>): Flow<Either<List<PrescriptionDomain>>>
    suspend fun deletePrescription(prescription: PrescriptionDomain): Either<Unit>

    suspend fun saveReminder(reminder: ReminderDomain): Flow<Either<Unit>>
    suspend fun getRemindersByMedication(medicationId: Int): Flow<Either<List<ReminderDomain>>>
    suspend fun deleteReminder(reminder: ReminderDomain): Either<Unit>

}