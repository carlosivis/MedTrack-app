package dev.carlosivis.medtrack.feature.main.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class ReminderModel(
    val id: Int,
    val medicationId: Int,
    val reminderType: String, // "medication" or "prescription"
    val reminderTime: Long
) : Parcelable
