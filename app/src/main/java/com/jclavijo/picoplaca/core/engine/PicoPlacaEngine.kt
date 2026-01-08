package com.jclavijo.picoplaca.core.engine

import com.jclavijo.picoplaca.core.model.*
import java.time.LocalDateTime
import com.jclavijo.picoplaca.core.util.dayOfWeekAsInt


object PicoPlacaEngine {

    /**
     * Retorna true si se debe NOTIFICAR en este momento
     */
    fun shouldNotify(
        vehicle: Vehicle,
        rule: PicoPlacaRule,
        window: TimeWindow,
        now: LocalDateTime
    ): Boolean {

        // 1️⃣ Día coincide
        if (window.dayOfWeek != rule.dayOfWeek) return false
        if (window.dayOfWeek != now.dayOfWeekAsInt()) return false

        // 2️⃣ Placa está restringida hoy
        if (!rule.restrictedDigits.contains(vehicle.lastDigit)) return false

        // 3️⃣ Hora de notificación
        val notifyTime = window.start.minusMinutes(window.minutesBefore.toLong())

        return now.toLocalTime() == notifyTime
    }
}

