package com.dizzer.swivltesttask.mvp.base

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dizzer.swivltesttask.App
import com.dizzer.swivltesttask.di.component.ActivityComponent
import com.dizzer.swivltesttask.di.component.DaggerActivityComponent
import com.dizzer.swivltesttask.di.module.ActivityModule
import com.dizzer.swivltesttask.utils.NetworkUtils

abstract class BaseActivity : AppCompatActivity(), BaseView {

    var activityComponent: ActivityComponent? = null
        private set

    val isNetworkConnected: Boolean
        get() = NetworkUtils.isNetworkConnected(applicationContext)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeActivityComponent()
        performDependencyInjection()
    }

    private fun initializeActivityComponent() {
        activityComponent = DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this))
            .applicationComponent((application as App).component)
            .build()
    }

    abstract fun performDependencyInjection()

    override fun toastMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
