package com.hb.geoloctest.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Coordinate(
    @PrimaryKey(autoGenerate = true) val id: Long?,
    @ColumnInfo(name = "latitude") var latitude: Double?,
    @ColumnInfo(name = "longitude") var longitude: Double?
) {
    override fun toString(): String {
        return "Coordinate(id=$id, latitude=$latitude, longitude=$longitude)"
    }
}