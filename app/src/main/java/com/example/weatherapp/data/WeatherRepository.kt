package com.example.weatherapp.data

import com.example.weatherapp.BuildConfig
import com.example.weatherapp.WeatherResponse
import com.example.weatherapp.WeatherRetrofitClient

class WeatherRepository {
    private val service = WeatherRetrofitClient.create()

    suspend fun fetchWeatherData(cityName: String): WeatherResponse {
        val apiKey = getApiKey()
        return service.getWeather(cityName = cityName, apiKey = apiKey)
    }

    private fun getApiKey(): String {
        return BuildConfig.WEATHER_API_KEY
    }
}