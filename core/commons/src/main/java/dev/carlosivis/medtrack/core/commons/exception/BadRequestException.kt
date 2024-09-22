package dev.carlosivis.medtrack.core.commons.exception

class BadRequestException(
    override val message: String? = null
) : Throwable(message)