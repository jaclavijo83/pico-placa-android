package com.jclavijo.picoplaca.ui.vehicle

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jclavijo.picoplaca.data.repository.VehicleRepository
import kotlinx.coroutines.launch

class VehicleViewModel(
    private val repository: VehicleRepository
) : ViewModel() {

    val vehicles = repository.getVehicles()

    fun addVehicle(plate: String) {
        viewModelScope.launch {
            repository.addVehicle(plate)
        }
    }

    fun toggle(vehicle: com.jclavijo.picoplaca.core.model.Vehicle) {
        viewModelScope.launch {
            repository.toggle(vehicle)
        }
    }
}
