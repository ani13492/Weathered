package com.amg.weathered.internal

import java.io.IOException
import java.lang.Exception

class NoConnectivityException : IOException()
class LocationPermissionNotGranted : Exception()