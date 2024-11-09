package dev.carlosivis.medtrack.feature.main.ui.add.medication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.carlosivis.medtrack.core.uikit.component.CustomInputTextField
import dev.carlosivis.medtrack.core.uikit.component.CustomSwitch
import dev.carlosivis.medtrack.core.uikit.theme.Colors

@Composable
fun MedicationAddScreen(viewModel: MedicationAddViewModel) {
    val state by viewModel.state.collectAsState()
    val action = viewModel::dispatch

    Content(state,viewModel::dispatch)

}

@Composable
private fun Content(
    state: MedicationAddViewState,
    action: (MedicationAddViewAction) -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(MaterialTheme.colors.background),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Add New Medication",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.onPrimary
        )

        CustomInputTextField(
            value = state.medication.name,
            onValueChange = { action(MedicationAddViewAction.Edit.name(it)) },
            label = "Name of Medication",
        )

        CustomInputTextField(
            value = state.medication.dosage,
            onValueChange = { action(MedicationAddViewAction.Edit.dosage(it)) },
            label = "Dosage in mg",
        )

        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround) {
            CustomInputTextField(
                value = state.medication.frequency.toString(),
                onValueChange = { action(MedicationAddViewAction.Edit.frequency(it.toInt())) },
                label = "Frequency (in hours)",
                keyboardType = KeyboardType.Decimal,
                modifier = Modifier.fillMaxWidth(0.3F)
                    .background(shape = RoundedCornerShape(16.dp), color = Colors.Tertiary)
            )
            CustomInputTextField(
                value = state.medication.duration.toString(),
                onValueChange = { action(MedicationAddViewAction.Edit.duration(it)) },
                label = "Duration (in days)",
                keyboardType = KeyboardType.Decimal,
                modifier = Modifier.fillMaxWidth(0.6F)
                    .background(shape = RoundedCornerShape(16.dp), color = Colors.Tertiary)
            )
        }

//        DatePickerDocked{
//            action(MedicationAddViewAction.Edit.startTime(it))
//        }
        Row {
            Text("Medication Active")
            CustomSwitch(
                checked = state.medication.isActive,
                onCheckedChange = { action(MedicationAddViewAction.Edit.isActive(it))},
            )

        }

        Button(
            onClick = {
                action(MedicationAddViewAction.Save.medication(state.medication))
            },
            modifier = Modifier
                .fillMaxWidth(0.25F)
                .align(Alignment.CenterHorizontally)
        ) {
            Text("Save")
        }
    }
}

@Composable
@Preview
fun MedicationAddScreenPreview() {
    val fakeState = MedicationAddViewState()
    val fakeAction: (MedicationAddViewAction) -> Unit = {}

    Content(fakeState, fakeAction)
}