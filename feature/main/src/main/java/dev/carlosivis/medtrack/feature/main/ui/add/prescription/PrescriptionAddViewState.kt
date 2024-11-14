package dev.carlosivis.medtrack.feature.main.ui.add.prescription

import dev.carlosivis.medtrack.feature.main.model.EMPTY_PRESCRIPTION_MODEL
import dev.carlosivis.medtrack.feature.main.model.PrescriptionModel

data class PrescriptionAddViewState(
    val error: Throwable? = null,
    val isLoading: Boolean = false,
    val prescription: PrescriptionModel = EMPTY_PRESCRIPTION_MODEL,
)