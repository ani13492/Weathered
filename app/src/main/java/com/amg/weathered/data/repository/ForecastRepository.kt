package com.amg.weathered.data.repository

import androidx.lifecycle.LiveData
import com.amg.weathered.data.db.entity.CurrentWeatherEntry
import com.amg.weathered.data.db.entity.WeatherLocation

interface ForecastRepository {

    suspend fun getCurrentWeather() : LiveData<CurrentWeatherEntry>
    suspend fun getWeatherLocation() : LiveData<WeatherLocation>
}