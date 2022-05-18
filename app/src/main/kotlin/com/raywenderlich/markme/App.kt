package com.raywenderlich.markme

import android.app.Application
import com.raywenderlich.markme.di.applicationModule
import org.koin.android.ext.android.startKoin
import timber.log.Timber
import timber.log.Timber.DebugTree


class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(DebugTree())
        startKoin(this, listOf(applicationModule))
    }
}