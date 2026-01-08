package com.jclavijo.picoplaca.core.model

import java.time.LocalDateTime

data class NotificationEvent(
    val plate: String,
    val notifyAt: LocalDateTime,
    val ruleDay: Int
)
