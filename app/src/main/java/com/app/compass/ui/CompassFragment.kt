package com.app.compass.ui

import android.content.Context
import android.hardware.SensorManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.app.compass.R
import com.app.compass.vm.CompassViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CompassFragment : Fragment() {

    private val viewModel: CompassViewModel by viewModel()

    private lateinit var sensorManager: SensorManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_compass, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sensorManager = requireContext().getSystemService(Context.SENSOR_SERVICE) as SensorManager
        observeDegreeValue()
    }

    override fun onResume() {
        super.onResume()

        viewModel.initSensors(sensorManager)
    }

    override fun onPause() {
        super.onPause()

        viewModel.unregisterSensors(sensorManager)
    }

    private fun observeDegreeValue() {
        viewModel.rotationDegree.observe(viewLifecycleOwner, Observer { degree ->
            Log.e("degree", "degree -------> $degree")
        })
    }
}
