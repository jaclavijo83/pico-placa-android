package com.jclavijo.picoplaca.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.jclavijo.picoplaca.notifications.NotificationScheduler
import com.jclavijo.picoplaca.notifications.PicoPlacaScheduler
import com.jclavijo.picoplaca.data.db.AppDatabase
import com.jclavijo.picoplaca.data.repository.PicoPlacaRuleRepository
import com.jclavijo.picoplaca.data.repository.VehicleRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val database = AppDatabase.getInstance(application)

    private val vehicleRepository = VehicleRepository(
        database.vehicleDao()
    )

    private val ruleRepository = PicoPlacaRuleRepository(
        database.picoPlacaRuleDao()
    )

    private val picoPlacaScheduler = PicoPlacaScheduler(
        context = application,
        vehicleRepository = vehicleRepository,
        ruleRepository = ruleRepository
    )

    fun scheduleNotifications() {
        viewModelScope.launch(Dispatchers.Default) {
            picoPlacaScheduler.scheduleAll()
        }
    }
}
