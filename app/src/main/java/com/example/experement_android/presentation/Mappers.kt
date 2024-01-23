package com.example.experement_android.presentation

import com.example.experement_android.domain.model.Forecast
import com.example.experement_android.presentation.model.ForecastUI
import kotlin.math.round

fun Forecast.toUI(): ForecastUI =
    ForecastUI(
        dtTxt = dtTxt,
        temp = round(temp).toInt() ,
        icon = icon
    )
