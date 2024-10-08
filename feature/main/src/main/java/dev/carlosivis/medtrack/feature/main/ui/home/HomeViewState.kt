package dev.carlosivis.medtrack.feature.main.ui.home

import dev.carlosivis.medtrack.feature.main.model.MedicationModel
import dev.carlosivis.medtrack.feature.main.model.PrescriptionModel
import dev.carlosivis.medtrack.feature.main.model.ReminderModel

data class HomeViewState(
    val error: Throwable? = null,
    val isLoading: Boolean = false,
    val medicationList: List<MedicationModel> = emptyList(),
    val prescriptionList: List<PrescriptionModel> = emptyList(),
    val reminderList: List<ReminderModel> = emptyList(),
)