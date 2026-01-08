package com.jclavijo.picoplaca.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jclavijo.picoplaca.data.db.dao.VehicleDao
import com.jclavijo.picoplaca.data.model.VehicleEntity

@Database(
    entities = [VehicleEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun vehicleDao(): VehicleDao
}
