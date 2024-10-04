package dev.carlosivis.medtrack.models.mappers

import dev.carlosivis.medtrack.domain.medicine.model.PrescriptionDomain

class PrescriptionMappers {
    fun PrescriptionDomain.toEntity() = PrescriptionEntity()

    fun PrescriptionEntity.toDomain() = PrescriptionDomain()

}