package com.jclavijo.picoplaca.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jclavijo.picoplaca.data.model.VehicleEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface VehicleDao {

    @Query("SELECT * FROM vehicles")
    fun getAll(): Flow<List<VehicleEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vehicle: VehicleEntity)

    @Query("DELETE FROM vehicles WHERE id = :id")
    suspend fun deleteById(id: Long)
}
