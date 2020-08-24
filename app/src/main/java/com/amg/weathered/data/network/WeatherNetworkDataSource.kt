package com.amg.weathered.data.network

import androidx.lifecycle.LiveData
import com.amg.weathered.data.network.response.CurrentWeatherResponse

interface WeatherNetworkDataSource {
    val downloadCurrentWeather : LiveData<CurrentWeatherResponse>

    suspend fun fetchCurrentWeather(
        location : String,
        languageCode : String
    )
}