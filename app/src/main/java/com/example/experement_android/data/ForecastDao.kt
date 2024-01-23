package com.example.experement_android.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.experement_android.data.model.db.ForecastDB

@Dao
abstract class ForecastDao() {

    @Query("SELECT * FROM forecast")
    abstract suspend fun getAll(): List<ForecastDB>

    @Query("DELETE FROM forecast")
    abstract suspend fun deleteAll()

    @Insert
    abstract suspend fun insertAll(forecasts: List<ForecastDB>)

    @Transaction
    open suspend fun insertToDatabase(forecasts: List<ForecastDB>){
        deleteAll()
        insertAll(forecasts)
    }
}