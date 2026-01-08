package com.jclavijo.picoplaca.core.util

import java.time.LocalDateTime

fun LocalDateTime.dayOfWeekAsInt(): Int {
    return when (this.dayOfWeek.value) {
        1 -> 1 // Monday
        2 -> 2
        3 -> 3
        4 -> 4
        5 -> 5
        6 -> 6
        7 -> 7 // Sunday
        else -> 0
    }
}

