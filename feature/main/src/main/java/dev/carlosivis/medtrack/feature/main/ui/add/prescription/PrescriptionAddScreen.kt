package dev.carlosivis.medtrack.feature.main.ui.add.prescription

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.carlosivis.medtrack.core.uikit.component.CustomInputTextField
import dev.carlosivis.medtrack.core.uikit.component.DatePickerDocked
import dev.carlosivis.medtrack.feature.main.model.PrescriptionModel

@Composable
fun PrescriptionAddScreen(viewModel: PrescriptionAddViewModel) {
    val state by viewModel.state.collectAsState()
    val action = viewModel::dispatch

    Content(state,action)
}

@Composable
private fun Content(
    state: PrescriptionAddViewState,
    action: (PrescriptionAddViewAction) -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ){
          CustomInputTextField(
              value = state.prescription.doctorName,
              onValueChange = { action(PrescriptionAddViewAction.Edit.doctorName(it)) },
              label = "Name of Doctor",
          )

          CustomInputTextField(
              value = state.prescription.doctorContact,
              onValueChange = { action(PrescriptionAddViewAction.Edit.doctorContact(it)) },
              label = "Contact of Doctor",
          )

        DatePickerDocked {
            action(PrescriptionAddViewAction.Edit.expiryDate(it))

        }

        Button(
            onClick = {
                action(PrescriptionAddViewAction.Save.prescription(state.prescription))
            },
            enabled = verifyInputs(state.prescription),
            modifier = Modifier
                .fillMaxWidth(0.25F)
        ) {
            Text("Save")
        }
    }
}

@Composable
private fun MedicationCard() {
    Row(modifier = Modifier.fillMaxWidth(),) {
        CustomInputTextField(
            value = "",
            onValueChange = {},
            label = "Name of Medication",
        )
        CustomInputTextField(
            value = "",
            onValueChange = {},
            label = "Dosage in mg",
        )
    }
}

private fun verifyInputs(prescription : PrescriptionModel?): Boolean {
    return prescription != null &&
            prescription.doctorName.isNotBlank() &&
            prescription.doctorContact.isNotBlank() &&
            prescription.expiryDate > 0
}

@Composable
@Preview
fun PrescriptionAddScreenPreview() {
    val fakeState = PrescriptionAddViewState()
    val fakeAction: (PrescriptionAddViewAction) -> Unit = {}

    Content(fakeState, fakeAction)

}