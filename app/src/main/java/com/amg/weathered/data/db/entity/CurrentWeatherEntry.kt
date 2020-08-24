package com.amg.weathered.data.db.entity


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

const val CURRENT_WEATHER_ID = 0;

@Entity(tableName = "current_weather")
data class CurrentWeatherEntry(
    @ColumnInfo(name="cloud_cover")
    val cloudcover: Int,

    @ColumnInfo(name="feels_like")
    val feelslike: Double,

    @ColumnInfo(name="humidity")
    val humidity: Double,

    @SerializedName("is_day")
    @ColumnInfo(name="is_day")
    val isDay: String,

    @ColumnInfo(name="observation_time")
    @SerializedName("observation_time")
    val observationTime: String,

    @ColumnInfo(name="precip")
    val precip: Double,

    @ColumnInfo(name="pressure")
    val pressure: Double,

    @ColumnInfo(name="temp")
    val temperature: Double,

    @ColumnInfo(name="uv_index")
    @SerializedName("uv_index")
    val uvIndex: Int,

    @ColumnInfo(name="visibility")
    val visibility: Int,

    @ColumnInfo(name="weather_code")
    @SerializedName("weather_code")
    val weatherCode: Int,

    @ColumnInfo(name="weather_descriptions")
    @SerializedName("weather_descriptions")
    val weatherDescriptions: List<String>,

    @ColumnInfo(name="weather_icons")
    @SerializedName("weather_icons")
    val weatherIcons: List<String>,

    @ColumnInfo(name="wind_degree")
    @SerializedName("wind_degree")
    val windDegree: Int,

    @ColumnInfo(name="wind_dir")
    @SerializedName("wind_dir")
    val windDir: String,

    @ColumnInfo(name="wind_speed")
    @SerializedName("wind_speed")
    val windSpeed: Double
){
    @PrimaryKey(autoGenerate = false)
    var id:Int = CURRENT_WEATHER_ID
}