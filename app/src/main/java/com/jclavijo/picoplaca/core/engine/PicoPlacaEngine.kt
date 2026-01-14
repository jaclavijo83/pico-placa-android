package com.jclavijo.picoplaca.core.engine

import com.jclavijo.picoplaca.core.model.NotificationEvent
import com.jclavijo.picoplaca.core.model.PicoPlacaRule
import java.time.LocalDateTime

class PicoPlacaEngine(
    private val planner: NotificationPlanner
) {

    fun calculateNotifications(
        plate: String,
        rules: List<PicoPlacaRule>,
        now: LocalDateTime
    ): List<NotificationEvent> {
        return planner.plan(
            plate = plate,
            rules = rules,
            from = now
        )
    }
}
