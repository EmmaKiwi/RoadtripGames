package com.mercari.roadtripgames

import android.app.Application

class RoadTripApplication: Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .context(this)
            .build()
    }
}