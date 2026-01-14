package com.jclavijo.picoplaca.core.model

/**
 * Franja horaria en minutos desde medianoche.
 *
 * Ejemplo:
 * 7:00  -> 420
 * 9:00  -> 540
 */
data class TimeWindow(
    val startMinutes: Int,
    val endMinutes: Int
) {
    init {
        require(startMinutes in 0..1439) {
            "startMinutes must be between 0 and 1439"
        }
        require(endMinutes in 1..1440) {
            "endMinutes must be between 1 and 1440"
        }
        require(startMinutes < endMinutes) {
            "startMinutes must be less than endMinutes"
        }
    }
}
