package com.jclavijo.picoplaca.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jclavijo.picoplaca.data.db.dao.PicoPlacaRuleDao
import com.jclavijo.picoplaca.data.db.dao.VehicleDao

@Database(
    entities = [
        VehicleEntity::class,
        PicoPlacaRuleEntity::class,
        TimeWindowEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun vehicleDao(): VehicleDao
    abstract fun picoPlacaRuleDao(): PicoPlacaRuleDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "pico_placa_db"
                ).build().also { INSTANCE = it }
            }
        }
    }
}
