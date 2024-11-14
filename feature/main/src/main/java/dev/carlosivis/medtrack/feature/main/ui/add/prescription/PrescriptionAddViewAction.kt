package dev.carlosivis.medtrack.feature.main.ui.add.prescription

import dev.carlosivis.medtrack.feature.main.model.PrescriptionModel

sealed class PrescriptionAddViewAction {
    object Set {
        data class Loading(val isLoading: Boolean) : PrescriptionAddViewAction()
    }
    object Navigate {
        object Home: PrescriptionAddViewAction()
    }
    object Save {
        data class prescription(val prescription: PrescriptionModel) : PrescriptionAddViewAction()
    }
    object Edit {
        data class doctorName(val name: String) : PrescriptionAddViewAction()
        data class doctorContact(val contact: String) : PrescriptionAddViewAction()
        data class expiryDate(val date: Long) : PrescriptionAddViewAction()
        data class medicationId(val medicationId: List<Int>) : PrescriptionAddViewAction()

    }

}