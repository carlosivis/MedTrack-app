package dev.carlosivis.medtrack.core.commons.exception

class MissingBodyResponseException(
    override val message: String? = null
) : Throwable(message)