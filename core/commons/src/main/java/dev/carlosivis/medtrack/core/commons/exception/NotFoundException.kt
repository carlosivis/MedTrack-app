package dev.carlosivis.medtrack.core.commons.exception

class NotFoundException (
    override val message: String? = null,
    override val cause: Throwable? = null
) : Throwable(message)