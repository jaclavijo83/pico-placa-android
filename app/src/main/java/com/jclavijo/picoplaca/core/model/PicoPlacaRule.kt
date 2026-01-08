package com.jclavijo.picoplaca.core.model

data class PicoPlacaRule(
    val dayOfWeek: Int,           // 1=Lunes ... 7=Domingo
    val restrictedDigits: Set<Int>
)
