package dev.carlosivis.medtrack.feature.main.ui.add.prescription

import androidx.lifecycle.ViewModel
import dev.carlosivis.medtrack.core.useCase
import dev.carlosivis.medtrack.domain.medicine.usecase.SaveMedicationUseCase
import dev.carlosivis.medtrack.domain.medicine.usecase.SavePrescriptionUseCase
import dev.carlosivis.medtrack.feature.main.model.PrescriptionModel
import dev.carlosivis.medtrack.feature.main.model.toDomain
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.koin.core.component.KoinComponent

class PrescriptionAddViewModel(
    private val navigation: PrescriptionAddNavigation
):ViewModel(), KoinComponent {
    private val _state = MutableStateFlow(PrescriptionAddViewState())
    val state = _state.asStateFlow()

    private val savePrescriptionUseCase: SavePrescriptionUseCase by useCase()
    private val saveMedicationUseCase: SaveMedicationUseCase by useCase()

    private fun setLoading(isLoading: Boolean) {
        _state.update { it.copy(isLoading = isLoading) }
    }

    fun dispatch(action: PrescriptionAddViewAction) {
        when(action) {
            is PrescriptionAddViewAction.Navigate.Home -> TODO()
            is PrescriptionAddViewAction.Set.Loading -> setLoading(action.isLoading)
            is PrescriptionAddViewAction.Save.prescription -> savePrescription(action.prescription)
            is PrescriptionAddViewAction.Edit.doctorContact -> _state.update { it.copy(prescription = it.prescription.copy(doctorContact = action.contact)) }
            is PrescriptionAddViewAction.Edit.doctorName -> _state.update { it.copy(prescription = it.prescription.copy(doctorName = action.name)) }
            is PrescriptionAddViewAction.Edit.expiryDate -> _state.update { it.copy(prescription = it.prescription.copy(expiryDate = action.date)) }
            is PrescriptionAddViewAction.Edit.medicationId -> _state.update { it.copy(prescription = it.prescription.copy(medicationId = action.medicationId)) }
        }
    }

    private fun savePrescription(prescription: PrescriptionModel) {
        setLoading(true)
        savePrescriptionUseCase(
            params = prescription.toDomain(),
            onSuccess = {
                setLoading(false)
                navigation.popBackStack()
            },
            onFailure = {
                setLoading(false)
                _state.update { it.copy(error = it.error) }
            }
        )
    }
}