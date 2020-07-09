package com.app.compass.di

import android.content.Context
import android.hardware.SensorManager

val Context.sensorManager: SensorManager
    get() = getSystemService(Context.SENSOR_SERVICE) as SensorManager
