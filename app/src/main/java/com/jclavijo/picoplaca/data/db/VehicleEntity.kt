package com.jclavijo.picoplaca.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vehicles")
data class VehicleEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val plate: String,
    val isActive: Boolean
)
