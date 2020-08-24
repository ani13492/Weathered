package com.amg.weathered.data.network.response


import com.amg.weathered.data.db.entity.CurrentWeatherEntry
import com.amg.weathered.data.db.entity.Location
import com.amg.weathered.data.db.entity.Request
import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponse(
    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry,
    val location: Location,
    val request: Request
)