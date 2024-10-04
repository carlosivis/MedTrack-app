package dev.carlosivis.medtrack.repository.datasource.local

import dev.carlosivis.medtrack.core.commons.base.Either
import dev.carlosivis.medtrack.domain.medicine.model.MedicationDomain
import dev.carlosivis.medtrack.domain.medicine.model.PrescriptionDomain
import dev.carlosivis.medtrack.domain.medicine.model.ReminderDomain
import kotlinx.coroutines.flow.Flow

interface MedTrackLocalDataSource {
    fun saveMedication(medication: MedicationDomain): Either<Unit>

    fun getActiveMedications(): Flow<Either<List<MedicationDomain>>>
    fun getInactiveMedications(): Flow<Either<List<MedicationDomain>>>
    fun updateMedicationStatus(medicationId: Int, isActive: Boolean): Either<Unit>
    fun deleteMedication(medication: MedicationDomain): Either<Unit>

    fun savePrescription(prescription: PrescriptionDomain): Either<Unit>
    fun getPrescriptionsByMedication(medicationsIds: List<Int>): Flow<Either<List<PrescriptionDomain>>>
    fun deletePrescription(prescription: PrescriptionDomain): Either<Unit>

    fun saveReminder(reminder: ReminderDomain): Either<Unit>
    fun getRemindersByMedication(medicationId: Int): Flow<Either<List<ReminderDomain>>>
    fun deleteReminder(reminder: ReminderDomain): Either<Unit>


}