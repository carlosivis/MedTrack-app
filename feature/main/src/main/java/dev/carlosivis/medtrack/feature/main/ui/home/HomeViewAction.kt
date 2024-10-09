package dev.carlosivis.medtrack.feature.main.ui.home

sealed class HomeViewAction {

    object Get {
        object Resume : HomeViewAction()
        object Medication : HomeViewAction()
        object Prescription : HomeViewAction()
        object Reminder : HomeViewAction()
    }

    object Navigate{
        data class Details(val id: Int): HomeViewAction()
    }
    object Set {
        data class Loading(val isLoading: Boolean): HomeViewAction()
    }
}