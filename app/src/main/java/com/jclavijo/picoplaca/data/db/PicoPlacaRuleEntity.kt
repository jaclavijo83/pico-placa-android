package com.jclavijo.picoplaca.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pico_placa_rules")
data class PicoPlacaRuleEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    val dayOfWeek: Int,

    /**
     * Últimos dígitos restringidos, separados por coma.
     * Ejemplo: "3,4"
     */
    val restrictedLastDigits: String
)
