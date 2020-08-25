package com.amg.weathered.provider

import com.amg.weathered.data.db.entity.WeatherLocation

class LocationProviderImpl : LocationProvider {
    override suspend fun hasLocationChanged(lastWeatherLocation: WeatherLocation): Boolean {
        return true;
    }

    override suspend fun getPreferredLocationString(): String {
        return "Philadelphia"
    }
}