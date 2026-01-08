package com.jclavijo.picoplaca.core.engine

import com.jclavijo.picoplaca.core.model.PicoPlacaRule
import com.jclavijo.picoplaca.core.model.TimeWindow
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import java.time.LocalDateTime

class PicoPlacaEngineTest {

    private val rule = PicoPlacaRule(
        dayOfWeek = 4, // Thursday
        restrictedLastDigits = setOf(9, 0),
        windows = listOf(
            TimeWindow(7 * 60, 9 * 60),
            TimeWindow(18 * 60, 20 * 60)
        )
    )

    private val engine = PicoPlacaEngine(listOf(rule))

    @Test
    fun restricted_when_plate_and_time_match() {
        val date = LocalDateTime.of(2025, 1, 16, 7, 30)
        assertTrue(engine.isRestricted("ABC129", date))
    }

    @Test
    fun not_restricted_outside_time() {
        val date = LocalDateTime.of(2025, 1, 16, 10, 0)
        assertFalse(engine.isRestricted("ABC129", date))
    }
}
