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
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.carlosivis.medtrack.core.uikit.theme.Colors
import dev.carlosivis.medtrack.feature.main.getHoursUntilReminder
import dev.carlosivis.medtrack.feature.main.getReminderTextColor
import dev.carlosivis.medtrack.feature.main.model.ReminderModel

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
        ExpandableFABMenu()

    }
}

@Composable
private fun CardReminders(reminders: List<ReminderModel>){
    Box(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()
        .fillMaxHeight(0.4f)
        .shadow(elevation = 4.dp)
        .background(shape = RoundedCornerShape(16.dp), color = Colors.SoftLavender),
        contentAlignment = Alignment.Center){
        Text(text = "Reminders",
            modifier = Modifier.align(Alignment.TopCenter)
                                .padding(top = 8.dp),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,)

        Spacer(modifier = Modifier.height(16.dp))

        if(reminders.isEmpty()){
            Text(text = "No reminders for the next 5 days",
                modifier = Modifier.align(Alignment.Center),
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Normal,)
        }
        reminders.forEach{
            val expired = it.reminderTime < System.currentTimeMillis()
            val hoursLeft = getHoursUntilReminder(it.reminderTime)
            val reminderText = if (expired) {
                "${it.name} reminder expired"
            } else {
                "${it.name} expires in $hoursLeft hours"
            }
            Text(
                text = reminderText,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Normal,
                color = getReminderTextColor(it.reminderTime)
            )
        }

    }
}

@Composable
private fun CardPrescriptions(){

}

@Composable
private fun CardMedicines(){

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
fun ExpandableFABMenuPreview() {
    ExpandableFABMenu()
}

@Composable
@Preview()
fun CardsPreview() {
  CardMedicines()
  CardPrescriptions()
  CardReminders(emptyList())

}