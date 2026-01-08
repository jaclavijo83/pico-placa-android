package com.jclavijo.picoplaca.core.engine

import com.jclavijo.picoplaca.core.model.PicoPlacaRule
import com.jclavijo.picoplaca.core.model.TimeWindow
import org.junit.Assert.assertEquals
import org.junit.Test
import java.time.LocalDateTime

class NotificationPlannerTest {

    private val rule = PicoPlacaRule(
        dayOfWeek = 4, // Thursday
        restrictedLastDigits = setOf(9),
        windows = listOf(
            TimeWindow(7 * 60, 9 * 60),
            TimeWindow(18 * 60, 20 * 60)
        )
    )

    @Test
    fun plans_two_notifications_one_hour_before() {
        val planner = NotificationPlanner(toleranceMinutes = 60)

        val from = LocalDateTime.of(2025, 1, 15, 12, 0) // Wednesday
        val events = planner.plan("ABC129", listOf(rule), from)

        assertEquals(2, events.size)
        assertEquals(6, events[0].notifyAt.hour)
        assertEquals(17, events[1].notifyAt.hour)
    }
}
