package com.app.domain.provider

import android.hardware.Sensor

interface SensorProvider {
    val accelerometer: Sensor
}
