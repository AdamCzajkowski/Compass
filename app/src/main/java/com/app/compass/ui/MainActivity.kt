package com.app.compass.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.app.compass.R
import com.app.compass.di.compassViewModelModule
import org.koin.core.context.loadKoinModules

class MainActivity : AppCompatActivity() {

    private var navigationController: NavController? = null

    init {
        loadModules()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initNavigation()
    }

    private fun loadModules() =
        loadKoinModules(listOf(compassViewModelModule))

    private fun initNavigation() {
        navigationController = findNavController(R.id.fragmentNavHost)
    }
}
