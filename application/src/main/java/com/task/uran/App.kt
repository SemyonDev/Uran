package com.task.uran

import android.app.Application
import com.task.di.loaderModule
import com.task.uran.di.applicationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(loaderModule, applicationModule))
        }
    }
}