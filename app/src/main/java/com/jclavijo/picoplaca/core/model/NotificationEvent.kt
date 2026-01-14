package com.jclavijo.picoplaca.core.model

import java.time.LocalDateTime

/**
 * Evento de notificación planificado.
 *
 * @param plate Placa del vehículo
 * @param notifyAt Fecha y hora exacta en la que debe notificarse
 * @param ruleDay Día de la semana de la regla aplicada (1 = Lunes, 7 = Domingo)
 */
data class NotificationEvent(
    val plate: String,
    val notifyAt: LocalDateTime,
    val ruleDay: Int
)
