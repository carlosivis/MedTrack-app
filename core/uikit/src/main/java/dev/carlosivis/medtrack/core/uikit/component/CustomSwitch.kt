package dev.carlosivis.medtrack.core.uikit.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.carlosivis.medtrack.core.uikit.theme.Colors

@Composable
fun CustomSwitch(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    colors: SwitchColors = SwitchDefaults.colors(
        checkedThumbColor = Colors.Primary,
        checkedTrackColor = Colors.Primary.copy(alpha = 0.5f),
        uncheckedThumbColor = Colors.Secondary,
        uncheckedTrackColor = Colors.Secondary.copy(alpha = 0.3f)
    )
) {
    Switch(
        checked = checked,
        onCheckedChange = onCheckedChange,
        modifier = modifier.size(64.dp),
        colors = colors
    )
}

@Preview(showSystemUi = true)
@Composable
fun CustomSwitchPreview() {
Column {
    CustomSwitch(
        checked = true,
        onCheckedChange = {},
        modifier = Modifier.size(64.dp)
    )
    CustomSwitch(
        checked = false,
        onCheckedChange = {},
        modifier = Modifier.size(64.dp)
    )
}
}