package dev.carlosivis.medtrack.core

sealed class ViewState<T>(
    var data: T? = null,
    val message: String? = null,
    val error: Throwable? = null
) {
    class Success<T>(data: T) : ViewState<T>(data)
    class Error<T>(data: T? = null, error: Throwable?) : ViewState<T>(data = data, error = error)
    class Loading<T> : ViewState<T>()
}