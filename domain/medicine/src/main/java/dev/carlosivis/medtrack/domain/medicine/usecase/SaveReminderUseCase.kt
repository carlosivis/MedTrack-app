package dev.carlosivis.medtrack.domain.medicine.usecase

import dev.carlosivis.medtrack.core.commons.base.Either
import dev.carlosivis.medtrack.core.commons.base.UseCase
import dev.carlosivis.medtrack.domain.medicine.model.ReminderDomain
import dev.carlosivis.medtrack.domain.medicine.repository.MedTrackRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class SaveReminderUseCase(
    scope: CoroutineScope,
    private val repository: MedTrackRepository
): UseCase<ReminderDomain, Unit>(scope) {
    override suspend fun run(params: ReminderDomain?): Flow<Either<Unit>> {
        return repository.saveReminder(params!!)
    }
}