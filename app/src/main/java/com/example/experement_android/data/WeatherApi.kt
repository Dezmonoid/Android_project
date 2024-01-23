package com.example.experement_android.data

import com.example.experement_android.data.model.nw.ForecastNW
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("forecast?")
    suspend fun getCurrentForecastData(
        @Query("id") cityId: String,
        @Query("APPID") appId: String,
        @Query("units") units: String
    ): ForecastNW
}