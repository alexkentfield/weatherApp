package com.example.weatherapp

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