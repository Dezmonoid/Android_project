package com.example.experement_android.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.experement_android.data.model.db.ForecastDB

@Database(entities = [ForecastDB::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun forecastDao(): ForecastDao
}