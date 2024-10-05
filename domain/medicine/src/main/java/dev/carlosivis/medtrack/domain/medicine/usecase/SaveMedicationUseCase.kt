package dev.carlosivis.medtrack.domain.medicine.usecase

import dev.carlosivis.medtrack.core.commons.base.Either
import dev.carlosivis.medtrack.core.commons.base.UseCase
import dev.carlosivis.medtrack.domain.medicine.model.MedicationDomain
import dev.carlosivis.medtrack.domain.medicine.repository.MedTrackRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class SaveMedicationUseCase(
    scope: CoroutineScope,
    private val repository: MedTrackRepository
): UseCase<MedicationDomain, Unit>(scope) {
    override suspend fun run(params: MedicationDomain?): Flow<Either<Unit>> {
        return repository.saveMedication(params!!)
    }
}