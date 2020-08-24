package com.amg.weathered.data.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.amg.weathered.data.api.ApiWeatherService
import com.amg.weathered.data.network.response.CurrentWeatherResponse
import com.amg.weathered.internal.NoConnectivityException

class WeatherNetworkDataSourceImpl(
    private val apiWeatherService: ApiWeatherService
) : WeatherNetworkDataSource {

    private val _downloadedCurrentWeather = MutableLiveData<CurrentWeatherResponse>()

    override val downloadCurrentWeather: LiveData<CurrentWeatherResponse>
        get() = _downloadedCurrentWeather

    override suspend fun fetchCurrentWeather(location: String, languageCode: String) {
        try {
            val fetchedCurrentWeather = apiWeatherService.getCurrentWeatherAsync(location, languageCode)
                .await()
            _downloadedCurrentWeather.postValue(fetchedCurrentWeather)
        }
        catch (e: NoConnectivityException)  {
            Log.e("Connectivity : ", "No Internet.", e)
        }
    }
}