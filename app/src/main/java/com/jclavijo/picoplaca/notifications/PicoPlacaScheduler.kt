package com.jclavijo.picoplaca.notifications

import android.content.Context
import android.util.Log
import androidx.work.WorkManager
import com.jclavijo.picoplaca.core.engine.NotificationPlanner
import com.jclavijo.picoplaca.core.engine.PicoPlacaEngine
import com.jclavijo.picoplaca.data.repository.PicoPlacaRuleRepository
import com.jclavijo.picoplaca.data.repository.VehicleRepository
import java.time.LocalDateTime

class PicoPlacaScheduler(
    private val context: Context,
    private val vehicleRepository: VehicleRepository,
    private val ruleRepository: PicoPlacaRuleRepository
) {

    private val planner = NotificationPlanner(
        toleranceMinutes = 15
    )

    private val engine = PicoPlacaEngine(planner)

    suspend fun scheduleAll() {
        val vehicles = vehicleRepository.getAllVehiclesOnce()
        val rules = ruleRepository.getAllRules()
        val now = LocalDateTime.now()

        vehicles.forEach { vehicle ->
            val events = planner.plan(
                plate = vehicle.plate,
                rules = rules,
                from = now
            )

            events.forEach { event ->
                Log.d(
                    "PicoPlacaScheduler",
                    "Scheduling ${event.plate} at ${event.notifyAt}"
                )

                NotificationScheduler.schedule(
                    context = context,
                    notifyAt = event.notifyAt
                )
            }
        }
    }
}
