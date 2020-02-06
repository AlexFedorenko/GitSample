package com.dizzer.swivltesttask.mvp.ui.main.presenter

import android.app.Application
import android.content.Context
import android.content.Intent

import com.dizzer.swivltesttask.mvp.base.BasePresenter
import com.dizzer.swivltesttask.mvp.models.UserDetailInfoModel
import com.dizzer.swivltesttask.mvp.models.UserModel
import com.dizzer.swivltesttask.mvp.ui.main.contract.MainActivityContract
import com.dizzer.swivltesttask.mvp.ui.userDetails.view.UserDetailsActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit

class MainPresenter(
    retrofit: Retrofit,
    compositeDisposable: CompositeDisposable,
    application: Application
) : BasePresenter(retrofit, compositeDisposable, application), MainActivityContract.Presenter {

    private var view: MainActivityContract.View? = null
    private val mContext: Context = application.applicationContext
    private var models: List<UserModel>? = null
    private var isNewUserLoading = false

    override fun setView(view: MainActivityContract.View) {
        this.view = view
    }

    override fun getUsers() {
        compositeDisposable.add(apiHelper.getUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onNext = {
                    models = it
                    models?.let { data -> view?.setUsers(data) }
                },
                onError = {
                    view?.toastMessage(it.localizedMessage)
                }
            ))
    }

    override fun onUserClick(position: Int) {
        models?.get(position)?.login?.let {
            compositeDisposable.add(apiHelper.getUserDetails(it)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                    onNext = {
                            data -> onUserDetailsLoaded(data)
                    },
                    onError = {
                        view?.toastMessage(it.localizedMessage) }
                ))
        }
    }

    private fun onUserDetailsLoaded(userDetails: UserDetailInfoModel) {
        val intent = Intent(mContext, UserDetailsActivity::class.java)
        intent.putExtra("data", userDetails)
        view?.openUser(intent)
    }

    override fun loadNewUsers() {
        if (!isNewUserLoading) {
            isNewUserLoading = true
            models?.let {
                compositeDisposable.add(apiHelper.getUsers(it[it.size - 1].id!!)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeBy(
                        onNext = {
                            (models as ArrayList).addAll(it)
                            view?.addUsers(it)
                            isNewUserLoading = false
                        },
                        onError = {
                            view?.toastMessage(it.localizedMessage)
                            isNewUserLoading = false
                        }
                    ))
            }
        }
    }
}
