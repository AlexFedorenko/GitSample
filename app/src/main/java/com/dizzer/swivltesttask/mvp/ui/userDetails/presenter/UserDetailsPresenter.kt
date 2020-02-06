package com.dizzer.swivltesttask.mvp.ui.userDetails.presenter

import android.app.Application
import android.content.Context
import android.os.Bundle

import com.dizzer.swivltesttask.mvp.base.BasePresenter
import com.dizzer.swivltesttask.mvp.models.UserDetailInfoModel
import com.dizzer.swivltesttask.mvp.ui.userDetails.contract.UserDetailsActivityContract
import io.reactivex.disposables.CompositeDisposable
import retrofit2.Retrofit

class UserDetailsPresenter(
    retrofit: Retrofit,
    compositeDisposable: CompositeDisposable,
    application: Application
) : BasePresenter(retrofit, compositeDisposable, application), UserDetailsActivityContract.Presenter {

    private var view: UserDetailsActivityContract.View? = null
    private val mContext: Context = application.applicationContext
    private var model: UserDetailInfoModel? = null

    override fun setView(view: UserDetailsActivityContract.View) {
        this.view = view
    }

    override fun onCreate(bundle: Bundle) {
        model = bundle.getParcelable("data")
        model?.let { setUpUI() }
    }

    private fun setUpUI() {
        model?.name?.let { view?.setName(it) }
        model?.url?.let { view?.setUrl(it) }
        model?.avatar_url?.let { view?.setAvatar(it) }
        model?.followers?.let { view?.setFollower("Followers : $it") }
        model?.public_gists?.let { view?.setGists("Gists : $it") }
        model?.public_repos?.let { view?.setRepository("Repos : $it") }
    }
}
