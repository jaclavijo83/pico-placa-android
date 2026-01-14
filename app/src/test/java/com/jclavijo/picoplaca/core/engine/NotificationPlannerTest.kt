package com.jclavijo.picoplaca

import com.jclavijo.picoplaca.core.engine.NotificationPlanner
import com.jclavijo.picoplaca.core.model.PicoPlacaRule
import com.jclavijo.picoplaca.core.model.TimeWindow
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import java.time.LocalDateTime

class NotificationPlannerTest {

    @Test
    fun `notifica una hora antes del inicio de la franja`() {
        val planner = NotificationPlanner(toleranceMinutes = 60)

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

        val from = LocalDateTime.of(2025, 1, 22, 10, 0) // Miércoles

        val events = planner.plan(
            plate = "ABC129",
            rules = listOf(rule),
            from = from
        )

        assertEquals(1, events.size)
        assertEquals(6, events.first().notifyAt.hour)
        assertEquals(4, events.first().ruleDay)
    }

    @Test
    fun `no notifica si la placa no aplica`() {
        val planner = NotificationPlanner(toleranceMinutes = 60)

        val rule = PicoPlacaRule(
            dayOfWeek = 4,
            restrictedLastDigits = setOf(1, 2),
            windows = listOf(
                TimeWindow(
                    startMinutes = 7 * 60,
                    endMinutes = 9 * 60
                )
            )
        )

        val from = LocalDateTime.now()

        val events = planner.plan(
            plate = "ABC129",
            rules = listOf(rule),
            from = from
        )

        assertTrue(events.isEmpty())
    }
}
