package com.dizzer.swivltesttask.mvp.base

import com.dizzer.swivltesttask.mvp.api.ApiHelper
import io.reactivex.disposables.CompositeDisposable
import retrofit2.Retrofit

interface IBasePresenter {

    val retrofit: Retrofit

    val apiHelper: ApiHelper

    val compositeDisposable: CompositeDisposable

    val isNetworkConnected: Boolean

    fun onDestroy()
}
