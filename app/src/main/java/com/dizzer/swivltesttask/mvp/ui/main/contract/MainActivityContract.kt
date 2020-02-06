package com.dizzer.swivltesttask.mvp.ui.main.contract

import com.dizzer.swivltesttask.mvp.base.BaseView
import com.dizzer.swivltesttask.mvp.base.IBasePresenter


interface MainActivityContract {

    interface View : BaseView

    interface Presenter : IBasePresenter {
        fun setView(view: View)
    }
}
