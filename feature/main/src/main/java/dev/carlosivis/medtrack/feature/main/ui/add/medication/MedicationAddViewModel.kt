package dev.carlosivis.medtrack.feature.main.ui.add.medication

import androidx.lifecycle.ViewModel
import dev.carlosivis.medtrack.core.useCase
import dev.carlosivis.medtrack.domain.medicine.usecase.SaveMedicationUseCase
import dev.carlosivis.medtrack.feature.main.model.MedicationModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.koin.core.component.KoinComponent

class MedicationAddViewModel(
    private val navigation: MedicationAddNavigation,
    ):ViewModel(), KoinComponent {

    private val _state = MutableStateFlow(MedicationAddViewState())
    val state = _state.asStateFlow()

    private val saveMedicationUseCase: SaveMedicationUseCase by useCase()

    private fun setLoading(isLoading: Boolean) {
        _state.update { it.copy(isLoading = isLoading) }
    }

    fun dispatch(action: MedicationAddViewAction) {
        when (action) {
            is MedicationAddViewAction.Navigate.Home -> navigation.popBackStack()
            is MedicationAddViewAction.Set.Loading -> setLoading(action.isLoading)
            is MedicationAddViewAction.Edit.name -> _state.update { it.copy(medication = it.medication.copy(name = action.name))}
            is MedicationAddViewAction.Edit.dosage -> _state.update { it.copy(medication = it.medication.copy(dosage = action.dosage))}
            is MedicationAddViewAction.Edit.duration -> _state.update { it.copy(medication = it.medication.copy(duration = action.duration.toInt()))}
            is MedicationAddViewAction.Edit.frequency -> _state.update { it.copy(medication = it.medication.copy(frequency = action.frequency))}
            is MedicationAddViewAction.Edit.isActive -> _state.update { it.copy(medication = it.medication.copy(isActive = action.isActive))}
            is MedicationAddViewAction.Edit.startTime -> _state.update { it.copy(medication = it.medication.copy(startTime = action.startTime))}
            is MedicationAddViewAction.Save.medication -> saveMedication(action.medication)
        }
    }

    private fun saveMedication(medication: MedicationModel){
        saveMedicationUseCase()
    }
}