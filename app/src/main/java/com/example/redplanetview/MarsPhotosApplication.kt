package com.example.redplanetview

import android.app.Application
import com.example.redplanetview.data.AppContainer
import com.example.redplanetview.data.DefaultAppContainer

class MarsPhotosApplication: Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }

}