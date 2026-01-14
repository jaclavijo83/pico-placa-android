package com.jclavijo.picoplaca

import com.jclavijo.picoplaca.core.engine.NotificationPlanner
import com.jclavijo.picoplaca.core.engine.PicoPlacaEngine
import com.jclavijo.picoplaca.core.model.PicoPlacaRule
import com.jclavijo.picoplaca.core.model.TimeWindow
import org.junit.Assert.assertEquals
import org.junit.Test
import java.time.LocalDateTime

class PicoPlacaEngineTest {

    @Test
    fun `engine delega correctamente al planner`() {
        val planner = NotificationPlanner(toleranceMinutes = 60)
        val engine = PicoPlacaEngine(planner)

        val rule = PicoPlacaRule(
            dayOfWeek = 4, // Jueves
            restrictedLastDigits = setOf(9),
            windows = listOf(
                TimeWindow(
                    startMinutes = 7 * 60,
                    endMinutes = 9 * 60
                )
            )
        )

        val now = LocalDateTime.of(2025, 1, 22, 10, 0)

        val events = engine.calculateNotifications(
            plate = "ABC129",
            rules = listOf(rule),
            now = now
        )

        assertEquals(1, events.size)
        assertEquals(6, events.first().notifyAt.hour)
    }
}
