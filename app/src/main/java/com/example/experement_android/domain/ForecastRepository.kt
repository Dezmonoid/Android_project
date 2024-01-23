package com.example.experement_android.domain

import com.example.experement_android.domain.model.Forecast

interface ForecastRepository {
    suspend fun getForecast(): List<Forecast>
}

