package com.example.experement_android.presentation.forecast

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.experement_android.domain.ForecastRepository
import com.example.experement_android.presentation.model.ForecastUI
import com.example.experement_android.presentation.toUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

const val TAG = "ForecastViewModel"

@HiltViewModel
class ForecastViewModel @Inject constructor(
    private val repository: ForecastRepository
) : ViewModel() {
    private val _liveData = MutableLiveData<List<ForecastUI>>()
    val liveData: LiveData<List<ForecastUI>>
        get() = _liveData

    init {
        loadWeather()
    }

    private fun loadWeather() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val forecast = repository.getForecast().map { it.toUI() }
                withContext(Dispatchers.Main) {
                    _liveData.value = forecast
                }
            } catch (e: Throwable) {
                Log.e(TAG, e.message, e)
            }
        }
    }
}