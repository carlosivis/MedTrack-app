package dev.carlosivis.medtrack.domain.medicine.di

import dev.carlosivis.medtrack.domain.medicine.usecase.SaveMedicationUseCase
import dev.carlosivis.medtrack.domain.medicine.usecase.SavePrescriptionUseCase
import dev.carlosivis.medtrack.domain.medicine.usecase.SaveReminderUseCase
import kotlinx.coroutines.CoroutineScope
import org.koin.dsl.module

val domainModule = module {
    factory { (scope: CoroutineScope) ->
        SaveMedicationUseCase(scope, get())
    }
    factory {
            (scope: CoroutineScope) ->
        SavePrescriptionUseCase(scope, get())
    }
    factory {
            (scope: CoroutineScope) ->
        SaveReminderUseCase(scope, get())
    }
}


