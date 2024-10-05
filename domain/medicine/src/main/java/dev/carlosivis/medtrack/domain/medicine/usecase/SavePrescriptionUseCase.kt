package dev.carlosivis.medtrack.domain.medicine.usecase

import dev.carlosivis.medtrack.core.commons.base.Either
import dev.carlosivis.medtrack.core.commons.base.UseCase
import dev.carlosivis.medtrack.domain.medicine.model.PrescriptionDomain
import dev.carlosivis.medtrack.domain.medicine.repository.MedTrackRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class SavePrescriptionUseCase(
    scope: CoroutineScope,
    private val repository: MedTrackRepository
): UseCase<PrescriptionDomain, Unit>(scope) {
    override suspend fun run(params: PrescriptionDomain?): Flow<Either<Unit>> {
        return repository.savePrescription(params!!)
    }
}