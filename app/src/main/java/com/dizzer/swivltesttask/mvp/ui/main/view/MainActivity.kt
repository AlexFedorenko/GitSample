package com.dizzer.swivltesttask.mvp.ui.main.view

import android.os.Bundle
import com.dizzer.swivltesttask.R
import com.dizzer.swivltesttask.mvp.base.BaseActivity
import com.dizzer.swivltesttask.mvp.ui.main.contract.MainActivityContract
import com.dizzer.swivltesttask.mvp.ui.main.presenter.MainPresenter
import javax.inject.Inject

class MainActivity : BaseActivity(), MainActivityContract.View {

    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.setView(this)
    }

    override fun performDependencyInjection() {
        activityComponent?.inject(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}
