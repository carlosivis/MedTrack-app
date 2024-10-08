package dev.carlosivis.medtrack.models.mappers

import dev.carlosivis.medtrack.data.local.entity.ReminderEntity
import dev.carlosivis.medtrack.domain.medicine.model.ReminderDomain


fun ReminderDomain.toEntity() = ReminderEntity(
    id = id,
    name = name,
    medicationId = medicationId,
    reminderTime = reminderTime,
    reminderType = reminderType,
)

fun ReminderEntity.toDomain() = ReminderDomain(
    id = id,
    name = name,
    medicationId = medicationId,
    reminderTime = reminderTime,
    reminderType = reminderType,
)