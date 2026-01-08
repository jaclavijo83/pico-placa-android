package com.jclavijo.picoplaca.data.dao

import androidx.room.*
import com.jclavijo.picoplaca.data.db.VehicleEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface VehicleDao {

    @Query("SELECT * FROM vehicles")
    fun getAll(): Flow<List<VehicleEntity>>

    @Insert
    suspend fun insert(vehicle: VehicleEntity)

    @Update
    suspend fun update(vehicle: VehicleEntity)

    @Delete
    suspend fun delete(vehicle: VehicleEntity)
}
