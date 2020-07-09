package com.app.compass.vm

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CompassViewModel : ViewModel(), SensorEventListener {
    val rotationDegree = MutableLiveData<Float>()

    fun initSensors(sensorManager: SensorManager) {
        val accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_UI)
    }

    fun unregisterSensors(sensorManager: SensorManager) =
        sensorManager.unregisterListener(this)

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
        Unit
    }

    override fun onSensorChanged(event: SensorEvent) {
        if (event.sensor.type == Sensor.TYPE_ACCELEROMETER) {
            rotationDegree.postValue(event.values[0])
        }
    }
}
