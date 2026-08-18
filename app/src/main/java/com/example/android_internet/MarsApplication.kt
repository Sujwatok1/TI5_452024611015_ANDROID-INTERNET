package com.example.android_internet

import android.app.Application
import com.example.android_internet.data.AppContainer
import com.example.android_internet.data.DefaultAppContainer

class MarsApplication : Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}

