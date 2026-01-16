package com.jclavijo.picoplaca.data.repository

import com.jclavijo.picoplaca.core.model.Vehicle
import com.jclavijo.picoplaca.data.db.dao.VehicleDao
import com.jclavijo.picoplaca.data.db.VehicleEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class VehicleRepository(
    private val dao: VehicleDao
) {
    fun getVehicles(): Flow<List<Vehicle>> =
        dao.getAll().map { list ->
            list.map {
                Vehicle(
                    id = it.id,
                    plate = it.plate,
                    isActive = it.isActive
                )
            }
        }

    suspend fun addVehicle(plate: String) {
        dao.insert(
            VehicleEntity(
                plate = plate,
                isActive = true
            )
        )
    }

    suspend fun getAllVehiclesOnce(): List<Vehicle> {
        return dao.getAllOnce().map {
            Vehicle(
                id = it.id,
                plate = it.plate,
                isActive = it.isActive
            )
        }
    }




    suspend fun toggle(vehicle: Vehicle) {
        dao.update(
            VehicleEntity(
                id = vehicle.id,
                plate = vehicle.plate,
                isActive = !vehicle.isActive
            )
        )
    }
}
