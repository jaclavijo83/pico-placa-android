package com.jclavijo.picoplaca.core.model

import java.time.LocalTime

data class TimeWindow(
    val dayOfWeek: Int,
    val start: LocalTime,
    val end: LocalTime,
    val minutesBefore: Int
)

