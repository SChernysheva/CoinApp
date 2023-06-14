package com.example.cleanarchcoin.App

import android.app.Application
import com.example.cleanarchcoin.di.DaggerAppComponent

class CoinApp: Application() {

    val component by lazy {
        DaggerAppComponent.builder().context(this).build()
    }
}