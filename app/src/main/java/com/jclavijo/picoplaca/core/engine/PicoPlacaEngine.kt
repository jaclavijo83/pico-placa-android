package com.jclavijo.picoplaca.core.engine

import java.time.DayOfWeek

class PicoPlacaEngine(
    private val rules: Map<DayOfWeek, Set<Int>>
) {

    fun appliesToday(
        plateLastDigit: Int,
        today: DayOfWeek
    ): Boolean {
        val restrictedDigits = rules[today] ?: return false
        return restrictedDigits.contains(plateLastDigit)
    }
}
