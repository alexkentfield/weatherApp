package com.example.weatherapp

import com.example.weatherapp.data.Main
import com.example.weatherapp.data.Weather

data class WeatherResponse(
    val name: String,
    val main: Main,
    val weather: List<Weather>
)
