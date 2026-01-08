package com.jclavijo.picoplaca.core.engine

import com.jclavijo.picoplaca.core.model.PicoPlacaRule
import java.time.LocalDateTime

class PicoPlacaEngine(
    private val rules: List<PicoPlacaRule>
) {

    fun isRestricted(
        plate: String,
        dateTime: LocalDateTime
    ): Boolean {

        val lastDigit = plate.last().digitToIntOrNull() ?: return false
        val day = dateTime.dayOfWeek.value
        val minutes = dateTime.hour * 60 + dateTime.minute

        val todayRules = rules.filter { it.dayOfWeek == day }

        return todayRules.any { rule ->
            lastDigit in rule.restrictedLastDigits &&
                    rule.windows.any { window ->
                        minutes in window.startMinutes..window.endMinutes
                    }
        }
    }
}
