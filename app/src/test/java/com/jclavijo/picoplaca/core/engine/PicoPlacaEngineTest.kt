package com.jclavijo.picoplaca.core.engine

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import java.time.DayOfWeek

class PicoPlacaEngineTest {

    @Test
    fun aplica_pico_y_placa_cuando_el_digito_esta_restringido() {
        val rules = mapOf(
            DayOfWeek.THURSDAY to setOf(9, 0)
        )

        val engine = PicoPlacaEngine(rules)

        assertTrue(
            engine.appliesToday(9, DayOfWeek.THURSDAY)
        )
    }

    @Test
    fun no_aplica_pico_y_placa_cuando_el_digito_no_esta_restringido() {
        val rules = mapOf(
            DayOfWeek.THURSDAY to setOf(9, 0)
        )

        val engine = PicoPlacaEngine(rules)

        assertFalse(
            engine.appliesToday(5, DayOfWeek.THURSDAY)
        )
    }
}
