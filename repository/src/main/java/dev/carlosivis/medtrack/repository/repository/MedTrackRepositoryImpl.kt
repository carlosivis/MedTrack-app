package dev.carlosivis.medtrack.repository.repository

import dev.carlosivis.medtrack.core.commons.base.Either
import dev.carlosivis.medtrack.core.commons.base.onFailureSuspend
import dev.carlosivis.medtrack.core.commons.base.onSuccessSuspend
import dev.carlosivis.medtrack.domain.medicine.model.MedicationDomain
import dev.carlosivis.medtrack.domain.medicine.model.PrescriptionDomain
import dev.carlosivis.medtrack.domain.medicine.model.ReminderDomain
import dev.carlosivis.medtrack.domain.medicine.repository.MedTrackRepository
import dev.carlosivis.medtrack.repository.datasource.local.MedTrackLocalDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class MedTrackRepositoryImpl(
    private val local: MedTrackLocalDataSource,
    //TODO: add remote data source: private val remoteDataSource: MedTrackRemoteDataSource
): MedTrackRepository {
    override suspend fun saveMedication(medication: MedicationDomain): Flow<Either<Unit>> = flow {
        local.saveMedication(medication)
            .onSuccessSuspend {
            emit(Either.Success(Unit))
        }.onFailureSuspend {
            emit(Either.Failure(it))
        }
    }


    override suspend fun getActiveMedications(): Flow<Either<List<MedicationDomain>>> {
        TODO("Not yet implemented")
    }

    override suspend fun getInactiveMedications(): Flow<Either<List<MedicationDomain>>> {
        TODO("Not yet implemented")
    }

    override suspend fun updateMedicationStatus(
        medicationId: Int,
        isActive: Boolean
    ): Either<Unit> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteMedication(medication: MedicationDomain): Either<Unit> {
        TODO("Not yet implemented")
    }

    override suspend fun savePrescription(prescription: PrescriptionDomain): Flow<Either<Unit>> = flow {
       local.savePrescription(prescription)
           .onSuccessSuspend {
               emit(Either.Success(Unit))
           }.onFailureSuspend {
               emit(Either.Failure(it))
           }
    }

    override suspend fun getPrescriptionsByMedication(medicationsIds: List<Int>): Flow<Either<List<PrescriptionDomain>>> {
        TODO("Not yet implemented")
    }

    override suspend fun deletePrescription(prescription: PrescriptionDomain): Either<Unit> {
        TODO("Not yet implemented")
    }

    override suspend fun saveReminder(reminder: ReminderDomain): Flow<Either<Unit>> = flow {
        local.saveReminder(reminder)
            .onSuccessSuspend {
                emit(Either.Success(Unit))
            }.onFailureSuspend {
                emit(Either.Failure(it))
            }
    }

    override suspend fun getRemindersByMedication(medicationId: Int): Flow<Either<List<ReminderDomain>>> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteReminder(reminder: ReminderDomain): Either<Unit> {
        TODO("Not yet implemented")
    }
}