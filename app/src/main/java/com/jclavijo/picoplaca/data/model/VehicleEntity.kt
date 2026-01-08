package com.jclavijo.picoplaca.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vehicles")
data class VehicleEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val plate: String
)
