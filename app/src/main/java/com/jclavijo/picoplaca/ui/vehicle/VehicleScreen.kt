package com.jclavijo.picoplaca.ui.vehicle

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jclavijo.picoplaca.core.model.Vehicle

@Composable
fun VehicleScreen(
    viewModel: VehicleViewModel
) {
    val vehicles by viewModel.vehicles.collectAsState(initial = emptyList())
    var plate by remember { mutableStateOf("") }

    Column(Modifier.padding(16.dp)) {

        OutlinedTextField(
            value = plate,
            onValueChange = { plate = it },
            label = { Text("Placa") }
        )

        Button(
            onClick = {
                viewModel.addVehicle(plate)
                plate = ""
            },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Agregar")
        }

        Spacer(Modifier.height(16.dp))

        LazyColumn {
            items(vehicles) { vehicle ->
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(vehicle.plate)
                    Switch(
                        checked = vehicle.isActive,
                        onCheckedChange = {
                            viewModel.toggle(vehicle)
                        }
                    )
                }
            }
        }
    }
}
