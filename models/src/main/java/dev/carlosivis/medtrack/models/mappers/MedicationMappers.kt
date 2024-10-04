package dev.carlosivis.medtrack.models.mappers

import dev.carlosivis.medtrack.domain.medicine.model.MedicationDomain

class MedicationMappers {
    fun MedicationDomain.toEntity(): MedicationEntity{
        return MedicationEntity(
            id = id,
            name = name,
            dosage = dosage,
            frequency = frequency,
            startTime = startTime,)
    }

    fun MedicationEntity.toDomain(): MedicationDomain{
        return MedicationDomain(
            id = id,
            name = name,
            dosage = dosage,
            frequency = frequency,
            startTime = startTime,)
    }
}
