package dev.carlosivis.medtrack.feature.main

import androidx.compose.ui.graphics.Color
import dev.carlosivis.medtrack.core.uikit.theme.Colors
import java.util.concurrent.TimeUnit

fun getHoursUntilReminder(reminderTime: Long): Long {
    val currentTime = System.currentTimeMillis()
    val diffInMillis = reminderTime - currentTime

    return TimeUnit.MILLISECONDS.toHours(diffInMillis)
}
fun getReminderTextColor(reminderTime: Long): Color {
    return if (reminderTime < System.currentTimeMillis()) {
        Colors.PaleYellow
    } else {
        Color.Black
    }
}