package com.jclavijo.picoplaca

import com.jclavijo.picoplaca.core.engine.PicoPlacaEngine
import com.jclavijo.picoplaca.core.model.*
import org.junit.Assert.*
import org.junit.Test
import java.time.LocalDateTime
import java.time.LocalTime

class PicoPlacaEngineTest {

    @Test
    fun `notifica cuando es jueves, placa 9, y hora correcta`() {

        val vehicle = Vehicle("ABC129", 9)

        val rule = PicoPlacaRule(
            dayOfWeek = 4, // Jueves
            restrictedDigits = setOf(9, 0)
        )

        val window = TimeWindow(
            dayOfWeek = 4,
            start = LocalTime.of(7, 0),
            end = LocalTime.of(9, 0),
            minutesBefore = 60
        )

        val now = LocalDateTime.of(2026, 1, 8, 6, 0) // Jueves 6:00 AM

        val result = PicoPlacaEngine.shouldNotify(vehicle, rule, window, now)

        assertTrue(result)
    }

    @Test
    fun `no notifica si placa no aplica`() {
        val vehicle = Vehicle("ABC123", 3)

        val rule = PicoPlacaRule(4, setOf(9, 0))
        val window = TimeWindow(4, LocalTime.of(7, 0), LocalTime.of(9, 0), 60)

        val now = LocalDateTime.of(2026, 1, 8, 6, 0)

        assertFalse(
            PicoPlacaEngine.shouldNotify(vehicle, rule, window, now)
        )
    }
}

