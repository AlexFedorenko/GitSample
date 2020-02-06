package com.dizzer.swivltesttask.mvp.ui.main.presenter

import android.app.Application
import android.content.Context

import com.dizzer.swivltesttask.mvp.base.BasePresenter
import com.dizzer.swivltesttask.mvp.ui.main.contract.MainActivityContract
import io.reactivex.disposables.CompositeDisposable
import retrofit2.Retrofit

class MainPresenter(
    retrofit: Retrofit,
    compositeDisposable: CompositeDisposable,
    application: Application
) : BasePresenter(retrofit, compositeDisposable, application), MainActivityContract.Presenter {

    private var view: MainActivityContract.View? = null
    private val mContext: Context = application.applicationContext

    override fun setView(view: MainActivityContract.View) {
        this.view = view
    }
}
