package com.example.cleanarchcoin.di

import android.content.Context
import com.example.cleanarchcoin.presentation.ui.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(activity: MainActivity)

    @Component.Builder
    interface AppComponentBuilder {
        @BindsInstance
        fun context(context: Context): AppComponentBuilder

        fun build(): AppComponent
    }
}