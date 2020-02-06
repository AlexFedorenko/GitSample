package com.dizzer.swivltesttask.mvp.ui.userDetails.contract

import android.os.Bundle
import com.dizzer.swivltesttask.mvp.base.BaseView
import com.dizzer.swivltesttask.mvp.base.IBasePresenter


interface UserDetailsActivityContract {
    interface View : BaseView {
        fun setAvatar(avatar: String)
        fun setName(name: String)
        fun setRepository(repository: String)
        fun setGists(gists: String)
        fun setFollower(followers: String)
        fun setUrl(url: String)
    }

    interface Presenter : IBasePresenter {
        fun setView(view: View)
        fun onCreate(bundle: Bundle)
    }
}
