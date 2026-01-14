package com.jclavijo.picoplaca.data.db

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "time_windows",
    foreignKeys = [
        ForeignKey(
            entity = PicoPlacaRuleEntity::class,
            parentColumns = ["id"],
            childColumns = ["ruleId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("ruleId")]
)
data class TimeWindowEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    val ruleId: Long,

    /**
     * Minutos desde medianoche
     * Ejemplo: 420 = 7:00 AM
     */
    val startMinutes: Int,

    val endMinutes: Int
)
