package com.amg.weathered.data.network.response


import com.amg.weathered.data.db.entity.WeatherLocation
import com.google.gson.annotations.SerializedName

data class FutureWeatherResponse(
    val forecast: Forecast,
    val location: WeatherLocation,
    val request: Request
)