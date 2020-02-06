package com.dizzer.swivltesttask

import android.app.Application
import android.content.Context
import com.dizzer.swivltesttask.di.component.ApplicationComponent
import com.dizzer.swivltesttask.di.component.DaggerApplicationComponent
import com.dizzer.swivltesttask.di.module.ApplicationModule

class App : Application() {

    var component: ApplicationComponent?
        get() = mApplicationComponent
        set(applicationComponent) {
            mApplicationComponent = applicationComponent
        }

    override fun onCreate() {
        super.onCreate()
        mApplicationComponent = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this, BuildConfig.BASE_URL)).build()

        mApplicationComponent?.inject(this)
    }

    companion object {
        private var mApplicationComponent: ApplicationComponent? = null

        val context: Context
            get() = mApplicationComponent!!.context()
    }
}
