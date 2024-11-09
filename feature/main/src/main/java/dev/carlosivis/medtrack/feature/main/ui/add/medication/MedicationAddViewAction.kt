package dev.carlosivis.medtrack.feature.main.ui.add.medication

import dev.carlosivis.medtrack.feature.main.model.MedicationModel

sealed class MedicationAddViewAction {

    object Navigate{
        object Home: MedicationAddViewAction()
    }

    object Edit{
        data class name(val name: String): MedicationAddViewAction()
        data class dosage(val dosage: String): MedicationAddViewAction()
        data class frequency(val frequency: Int): MedicationAddViewAction()
        data class duration(val duration: String): MedicationAddViewAction()
        data class startTime(val startTime: Long): MedicationAddViewAction()
        data class isActive(val isActive : Boolean): MedicationAddViewAction()
    }

    object Save {
        data class medication(val medication:MedicationModel) : MedicationAddViewAction()
    }

    object Set{
        data class Loading(val isLoading: Boolean): MedicationAddViewAction()
}
}

