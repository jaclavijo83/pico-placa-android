package com.jclavijo.picoplaca.core.model

/**
 * Regla de pico y placa para un día específico.
 *
 * @param dayOfWeek Día de la semana (1 = Lunes, 7 = Domingo, ISO-8601)
 * @param restrictedLastDigits Dígitos de placa restringidos ese día
 * @param windows Franjas horarias donde aplica la restricción
 */
data class PicoPlacaRule(
    val dayOfWeek: Int,
    val restrictedLastDigits: Set<Int>,
    val windows: List<TimeWindow>
)
