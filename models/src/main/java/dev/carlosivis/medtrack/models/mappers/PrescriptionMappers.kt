package dev.carlosivis.medtrack.models.mappers

import dev.carlosivis.medtrack.data.local.entity.PrescriptionEntity
import dev.carlosivis.medtrack.domain.medicine.model.PrescriptionDomain

fun PrescriptionDomain.toEntity() =  PrescriptionEntity(
        id = id,
        medicationId = medicationId,
        expiryDate = expiryDate,
        doctorName = doctorName,
        doctorContact = doctorContact
    )

 fun PrescriptionEntity.toDomain() = PrescriptionDomain(
        id = id,
        medicationId = medicationId,
        expiryDate = expiryDate,
        doctorName = doctorName,
        doctorContact = doctorContact
    )
