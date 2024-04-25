package com.example.weatherapp

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.WeatherRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class WeatherViewModel: ViewModel() {

    private val repository = WeatherRepository()
    val uiState = MutableStateFlow<WeatherResponse?>(null)

    fun fetchWeatherData(query: String) {
        viewModelScope.launch {
            try {
                val weatherResponse = repository.fetchWeatherData(query)
                // Handle the weather response here
                uiState.emit(weatherResponse)
                Log.d("AlexK","what happened here $weatherResponse")
            } catch (e: Exception) {
                // Handle errors
                Log.d("AlexK","what happened here $e")
            }
        }
    }
}