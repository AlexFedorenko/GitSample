package com.dizzer.swivltesttask.mvp.base

import android.app.Application

import com.dizzer.swivltesttask.mvp.api.ApiHelper
import com.dizzer.swivltesttask.utils.NetworkUtils
import io.reactivex.disposables.CompositeDisposable
import retrofit2.Retrofit

abstract class BasePresenter(
    final override val retrofit: Retrofit,
    override val compositeDisposable: CompositeDisposable, private val mApplication: Application
) : IBasePresenter {
    final override val apiHelper: ApiHelper = retrofit.create(ApiHelper::class.java)

    override val isNetworkConnected: Boolean
        get() = NetworkUtils.isNetworkConnected(mApplication.applicationContext)

    override fun onDestroy() {
        compositeDisposable.dispose()
    }
}
