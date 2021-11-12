package com.hb.geoloctest.dao

import androidx.room.*
import com.hb.geoloctest.models.Coordinate

@Dao
interface CoordinateDAO {
    @Query("SELECT * FROM coordinate")
    suspend fun getAll(): List<Coordinate>

    @Query("SELECT * FROM coordinate WHERE id In (:coodinateIds)")
    suspend fun loadAllByIds(coodinateIds: LongArray): List<Coordinate>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg coordinates: Coordinate)

    @Delete
    fun delete(coordinate: Coordinate)
}