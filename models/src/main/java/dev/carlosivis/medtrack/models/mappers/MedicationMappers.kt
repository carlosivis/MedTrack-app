package dev.carlosivis.medtrack.models.mappers

import dev.carlosivis.medtrack.data.local.entity.MedicationEntity
import dev.carlosivis.medtrack.domain.medicine.model.MedicationDomain


fun MedicationDomain.toEntity() = MedicationEntity(
        id = id,
        name = name,
        dosage = dosage,
        frequency = frequency,
        startTime = startTime,
        duration = duration,
        isActive = isActive
    )

fun MedicationEntity.toDomain() = MedicationDomain(
    id = id,
    name = name,
    dosage = dosage,
    frequency = frequency,
    startTime = startTime,
    duration = duration,
    isActive = isActive)
