package dev.carlosivis.data.local.datasource

import dev.carlosivis.data.local.dao.MedicationDao
import dev.carlosivis.data.local.dao.PrescriptionDao
import dev.carlosivis.data.local.dao.ReminderDao
import dev.carlosivis.medtrack.core.commons.base.Either
import dev.carlosivis.medtrack.domain.medicine.model.MedicationDomain
import dev.carlosivis.medtrack.domain.medicine.model.PrescriptionDomain
import dev.carlosivis.medtrack.domain.medicine.model.ReminderDomain
import dev.carlosivis.medtrack.repository.datasource.local.MedTrackLocalDataSource
import kotlinx.coroutines.flow.Flow

internal class MedTrackLocalDataSourceImpl (
    private val medicationDao: MedicationDao,
    private val prescriptionDao: PrescriptionDao,
    private val reminderDao: ReminderDao
): MedTrackLocalDataSource {
    override fun saveMedication(medication: MedicationDomain): Either<Unit> {
        TODO("Not yet implemented")
    }

    override fun getActiveMedications(): Flow<Either<List<MedicationDomain>>> {
        TODO("Not yet implemented")
    }

    override fun getInactiveMedications(): Flow<Either<List<MedicationDomain>>> {
        TODO("Not yet implemented")
    }

    override fun updateMedicationStatus(medicationId: Int, isActive: Boolean): Either<Unit> {
        TODO("Not yet implemented")
    }

    override fun deleteMedication(medication: MedicationDomain): Either<Unit> {
        TODO("Not yet implemented")
    }

    override fun savePrescription(prescription: PrescriptionDomain): Either<Unit> {
        TODO("Not yet implemented")
    }

    override fun getPrescriptionsByMedication(medicationsIds: List<Int>): Flow<Either<List<PrescriptionDomain>>> {
        TODO("Not yet implemented")
    }

    override fun deletePrescription(prescription: PrescriptionDomain): Either<Unit> {
        TODO("Not yet implemented")
    }

    override fun saveReminder(reminder: ReminderDomain): Either<Unit> {
        TODO("Not yet implemented")
    }

    override fun getRemindersByMedication(medicationId: Int): Flow<Either<List<ReminderDomain>>> {
        TODO("Not yet implemented")
    }

    override fun deleteReminder(reminder: ReminderDomain): Either<Unit> {
        TODO("Not yet implemented")
    }
}