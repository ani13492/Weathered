package com.amg.weathered.ui.weather.current

import androidx.lifecycle.ViewModel
import com.amg.weathered.data.repository.ForecastRepository
import com.amg.weathered.internal.lazyDeferred

class CurrentWeatherViewModel(
    private val forecastRepository: ForecastRepository
) : ViewModel() {

    val weather by lazyDeferred {
        forecastRepository.getCurrentWeather()
    }

    val weatherLocation by lazyDeferred {
        forecastRepository.getWeatherLocation()
    }
}