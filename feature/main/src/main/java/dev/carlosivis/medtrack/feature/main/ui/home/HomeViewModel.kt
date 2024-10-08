package dev.carlosivis.medtrack.feature.main.ui.home

import androidx.lifecycle.ViewModel
import dev.carlosivis.medtrack.core.ViewState
import dev.carlosivis.medtrack.core.useCase
import dev.carlosivis.medtrack.domain.medicine.usecase.SaveMedicationUseCase
import dev.carlosivis.medtrack.domain.medicine.usecase.SavePrescriptionUseCase
import dev.carlosivis.medtrack.domain.medicine.usecase.SaveReminderUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.koin.core.component.KoinComponent

class HomeViewModel(
    private val navigation : HomeNavigation,
): ViewModel(), KoinComponent {

    private val _state = MutableStateFlow(HomeViewState())
    val state = _state.asStateFlow()

    private val saveMedicationUseCase: SaveMedicationUseCase by useCase()
    private val savePrescriptionUseCase: SavePrescriptionUseCase by useCase()
    private val saveReminderUseCase: SaveReminderUseCase by useCase()
}