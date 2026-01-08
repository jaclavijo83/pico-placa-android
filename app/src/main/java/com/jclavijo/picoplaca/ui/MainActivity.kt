package com.jclavijo.picoplaca.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.room.Room
import com.jclavijo.picoplaca.data.db.AppDatabase
import com.jclavijo.picoplaca.data.repository.VehicleRepository
import com.jclavijo.picoplaca.ui.vehicle.VehicleScreen
import com.jclavijo.picoplaca.ui.vehicle.VehicleViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "pico_placa.db"
        ).build()

        val repository = VehicleRepository(db.vehicleDao())
        val viewModel = VehicleViewModel(repository)

        setContent {
            VehicleScreen(viewModel)
        }
    }
}
