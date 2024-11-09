package dev.carlosivis.medtrack.feature.main.ui.add.medication

import dev.carlosivis.medtrack.feature.main.model.EMPTY_MEDICATION_MODEL
import dev.carlosivis.medtrack.feature.main.model.MedicationModel

data class MedicationAddViewState(
    val error: Throwable? = null,
    val isLoading: Boolean = false,
    val medication: MedicationModel = EMPTY_MEDICATION_MODEL,
)