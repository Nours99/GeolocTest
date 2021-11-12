package com.hb.geoloctest.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hb.geoloctest.dao.CoordinateDAO
import com.hb.geoloctest.models.Coordinate

@Database(entities = [Coordinate::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun coordinateDao(): CoordinateDAO

    companion object{
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}