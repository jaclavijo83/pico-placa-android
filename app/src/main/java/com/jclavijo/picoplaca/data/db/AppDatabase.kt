package com.jclavijo.picoplaca.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jclavijo.picoplaca.data.dao.VehicleDao

@Database(
    entities = [VehicleEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun vehicleDao(): VehicleDao
}
