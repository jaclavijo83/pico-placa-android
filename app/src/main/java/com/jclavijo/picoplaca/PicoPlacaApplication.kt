package com.jclavijo.picoplaca

import android.app.Application
import com.jclavijo.picoplaca.data.db.AppDatabase
import com.jclavijo.picoplaca.data.repository.PicoPlacaRuleRepository
import com.jclavijo.picoplaca.data.repository.VehicleRepository
import com.jclavijo.picoplaca.notifications.PicoPlacaScheduler
import kotlinx.coroutines.*

class PicoPlacaApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val database = AppDatabase.getInstance(this)

        val scheduler = PicoPlacaScheduler(
            context = this,
            vehicleRepository = VehicleRepository(database.vehicleDao()),
            ruleRepository = PicoPlacaRuleRepository(database.picoPlacaRuleDao())
        )

        CoroutineScope(Dispatchers.Default).launch {
            scheduler.scheduleAll()
        }
    }
}
