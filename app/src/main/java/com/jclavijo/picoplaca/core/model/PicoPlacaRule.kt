package com.jclavijo.picoplaca.core.model

data class PicoPlacaRule(
    val dayOfWeek: Int,            // 1 = Monday ... 7 = Sunday
    val restrictedLastDigits: Set<Int>,
    val windows: List<TimeWindow>
)
