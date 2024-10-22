package dev.carlosivis.medtrack.feature.main.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.carlosivis.medtrack.core.uikit.theme.Colors
import dev.carlosivis.medtrack.feature.main.getHoursUntilReminder
import dev.carlosivis.medtrack.feature.main.getReminderTextColor
import dev.carlosivis.medtrack.feature.main.model.MedicationModel
import dev.carlosivis.medtrack.feature.main.model.ReminderModel
import dev.carlosivis.medtrack.feature.main.model.listMockMedication
import dev.carlosivis.medtrack.feature.main.model.listMockReminder
import dev.carlosivis.medtrack.presentation.main.R

@Composable
fun HomeScreen(viewModel: HomeViewModel){
    val state by viewModel.state.collectAsState()
    val action = viewModel::dispatch

    Content(state, viewModel::dispatch)
    LaunchedEffect(Unit) {
            action(HomeViewAction.Get.Resume)
    }
}

@Composable
private fun Content(
    state: HomeViewState,
    action: (HomeViewAction) -> Unit){

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ){

        CardReminders(state.reminderList)
        CardMedicines(state.medicationList)
        CardPrescriptions()
        //ExpandableFABMenu()
    }
}

@Composable
fun CardPrescriptions(){

}

@Composable
private fun CardReminders(reminders: List<ReminderModel>) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.4f)
            .shadow(elevation = 8.dp, shape = RoundedCornerShape(16.dp))
            .background(shape = RoundedCornerShape(16.dp), color = Colors.SoftLavender)
            .padding(16.dp),
        contentAlignment = Alignment.TopStart
    ) {
        Column {
            Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Icon(
                    painter = painterResource(id = dev.carlosivis.medtrack.core.uikit.R.drawable.baseline_timer_24),
                    contentDescription = "Reminders",
                    tint = Color.Gray
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Reminders",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Normal,
                    color = Color.Black
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            if (reminders.isEmpty()) {
                Text(
                    text = "No reminders for the next 5 days",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    fontStyle = FontStyle.Normal,
                    color = Color.Gray,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            } else {
                reminders.forEach { reminder ->
                    val expired = reminder.reminderTime < System.currentTimeMillis()
                    val hoursLeft = getHoursUntilReminder(reminder.reminderTime)
                    val reminderText = if (expired) {
                        "${reminder.name} reminder expired"
                    } else {
                        "${reminder.name} expires in $hoursLeft hours"
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(vertical = 4.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(8.dp)
                                .background(if (expired) Color.Red else Color.Green, CircleShape)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = reminderText,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            fontStyle = FontStyle.Normal,
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun CardMedicines(medications: List<MedicationModel>) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.4f)
            .shadow(elevation = 8.dp, shape = RoundedCornerShape(16.dp))
            .background(shape = RoundedCornerShape(16.dp), color = Colors.SoftLavender)
            .padding(16.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Column {
            Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Icon(
                    painter = painterResource(id = dev.carlosivis.medtrack.core.uikit.R.drawable.baseline_timer_24),
                    contentDescription = "Medications",
                    tint = Color.Gray
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Medications",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Normal,
                    color = Color.Black
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            if (medications.isEmpty()) {
                Text(
                    text = "No medications registered",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    fontStyle = FontStyle.Normal,
                    color = Color.Gray,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            } else {
                Text(
                    text = "You have ${medications.size} medications active",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    fontStyle = FontStyle.Normal,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(8.dp))
                medications.forEach { medication ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.align(Alignment.Start)
                            .padding(vertical = 4.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = dev.carlosivis.medtrack.core.uikit.R.drawable.baseline_timer_24),
                            contentDescription = "Medication Icon",
                            tint = Color.Gray
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = medication.name,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            fontStyle = FontStyle.Normal,
                            color = Color.Black
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun ExpandableFABMenu() {
    var isMenuExpanded by remember { mutableStateOf(false) }

    Box(
        contentAlignment = Alignment.BottomEnd,
        modifier = Modifier.fillMaxSize()
    ) {
        if (isMenuExpanded) {
            Column(
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                FloatingActionButton(
                    onClick = {  },
                    modifier = Modifier.size(50.dp),
                    backgroundColor = Colors.MintGreen
                ) {
                    Icon(Icons.Filled.Edit, contentDescription = "Add Prescription")
                }

                FloatingActionButton(
                    onClick = {  },
                    modifier = Modifier.size(50.dp),
                    backgroundColor = Colors.BabyBlue
                ) {
                    Icon(Icons.Filled.AddCircle, contentDescription = "Add Medication")
                }
            }
        }

        FloatingActionButton(
            onClick = { isMenuExpanded = !isMenuExpanded },
            backgroundColor = Colors.LightLilac
        ) {
            Icon(
                imageVector = if (isMenuExpanded) Icons.Filled.Close else Icons.Filled.Add,
                contentDescription = "Toggle Menu"
            )
        }
    }
}



@Composable
@Preview()
fun CardsPreview() {
    Column {
        CardMedicines(listMockMedication)
        Spacer(Modifier.height(4.dp))
        CardPrescriptions()
        CardReminders(listMockReminder)
    }
}
@Composable
@Preview()
fun ExpandableFABMenuPreview() {
    ExpandableFABMenu()
}