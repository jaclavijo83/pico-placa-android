package com.jclavijo.picoplaca.core.engine

import com.jclavijo.picoplaca.core.model.NotificationEvent
import com.jclavijo.picoplaca.core.model.PicoPlacaRule
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

class NotificationPlanner(
    private val toleranceMinutes: Int
) {

    fun plan(
        plate: String,
        rules: List<PicoPlacaRule>,
        from: LocalDateTime
    ): List<NotificationEvent> {

        val lastDigit = plate.last().digitToIntOrNull() ?: return emptyList()
        val events = mutableListOf<NotificationEvent>()

        rules.forEach { rule ->
            if (lastDigit !in rule.restrictedLastDigits) return@forEach

            val nextDate = nextDateForDay(rule.dayOfWeek, from.toLocalDate())

            rule.windows.forEach { window ->
                val startTime = LocalTime.of(
                    window.startMinutes / 60,
                    window.startMinutes % 60
                )

                val notifyAt = LocalDateTime.of(nextDate, startTime)
                    .minusMinutes(toleranceMinutes.toLong())

                if (notifyAt.isAfter(from)) {
                    events.add(
                        NotificationEvent(
                            plate = plate,
                            notifyAt = notifyAt,
                            ruleDay = rule.dayOfWeek
                        )
                    )
                }
            }
        }

        return events.sortedBy { it.notifyAt }
    }

    private fun nextDateForDay(
        targetDay: Int,
        from: LocalDate
    ): LocalDate {

        var date = from
        while (date.dayOfWeek.value != targetDay) {
            date = date.plusDays(1)
        }
        return date
    }
}
