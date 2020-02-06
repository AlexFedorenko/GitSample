package com.dizzer.swivltesttask.mvp.ui.main.contract

import android.content.Intent
import com.dizzer.swivltesttask.mvp.base.BaseView
import com.dizzer.swivltesttask.mvp.base.IBasePresenter
import com.dizzer.swivltesttask.mvp.models.UserModel


interface MainActivityContract {

    interface View : BaseView {
        fun setUsers(data: List<UserModel>)
        fun addUsers(data: List<UserModel>)
        fun openUser(intent: Intent)
    }

    interface Presenter : IBasePresenter {
        fun setView(view: View)
        fun getUsers()
        fun onUserClick(position: Int)
        fun loadNewUsers()
    }
}
