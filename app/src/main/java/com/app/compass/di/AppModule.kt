package com.app.compass.di

import com.app.compass.vm.CompassViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val compassViewModelModule = module(override = true) {
    viewModel {
        CompassViewModel()
    }
    single<SensorProvider> {
        SensorProviderImpl(

        )
    }
}
