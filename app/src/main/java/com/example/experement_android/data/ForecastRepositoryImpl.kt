package com.example.experement_android.data

import com.example.experement_android.domain.ForecastRepository
import com.example.experement_android.domain.model.Forecast

private const val APP_ID = "eeba719e0ea1ed0d70d6ea433307695e"
private const val UNITS = "metric"
private const val CITY_ID = "622034"

class ForecastRepositoryImpl(
    private val appDatabase: AppDatabase,
    private val weatherApi: WeatherApi
) : ForecastRepository {
    override suspend fun getForecast(): List<Forecast> {
        val forecastDao = appDatabase.forecastDao()
        return try {
            val response = weatherApi.getCurrentForecastData(
                cityId = CITY_ID,
                appId = APP_ID,
                units = UNITS
            )
            val forecast = response.list?.map { it.toDomain() }.orEmpty()
            forecastDao.insertToDatabase(forecast.map { it.toDB() })
            forecast
        } catch (e: Exception) {
            forecastDao.getAll().map { it.toDomain() }
        }
    }
}