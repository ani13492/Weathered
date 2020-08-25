package com.amg.weathered

import android.app.Application
import com.amg.weathered.data.api.ApiWeatherService
import com.amg.weathered.data.db.ForecastDatabase
import com.amg.weathered.data.network.ConnectivityInterceptor
import com.amg.weathered.data.network.ConnectivityInterceptorImpl
import com.amg.weathered.data.network.WeatherNetworkDataSource
import com.amg.weathered.data.network.WeatherNetworkDataSourceImpl
import com.amg.weathered.data.repository.ForecastRepository
import com.amg.weathered.data.repository.ForecastRepositoryImpl
import com.amg.weathered.provider.LocationProvider
import com.amg.weathered.provider.LocationProviderImpl
import com.amg.weathered.ui.weather.current.CurrentWeatherViewModelFactory
import com.jakewharton.threetenabp.AndroidThreeTen
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class ForecastApplication : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@ForecastApplication))

        bind() from singleton { ForecastDatabase(instance()) }
        bind() from singleton { instance<ForecastDatabase>().currentWeatherDao() }
        bind() from singleton { instance<ForecastDatabase>().weatherLocationDao() }
        bind<ConnectivityInterceptor>() with singleton { ConnectivityInterceptorImpl(instance()) }
        bind() from singleton { ApiWeatherService(instance()) }
        bind<WeatherNetworkDataSource>() with singleton { WeatherNetworkDataSourceImpl(instance()) }
        bind<LocationProvider>() with singleton { LocationProviderImpl() }
        bind<ForecastRepository>() with singleton { ForecastRepositoryImpl(instance(), instance(), instance(), instance()) }
        bind() from provider { CurrentWeatherViewModelFactory(instance()) }
    }

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
    }
}