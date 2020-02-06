package com.dizzer.swivltesttask.di.component

import android.app.Application
import android.content.Context
import com.dizzer.swivltesttask.App
import com.dizzer.swivltesttask.di.ApplicationContext
import com.dizzer.swivltesttask.di.module.ApplicationModule
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    val retrofit: Retrofit

    fun inject(app: App)

    @ApplicationContext
    fun context(): Context

    fun application(): Application
}
