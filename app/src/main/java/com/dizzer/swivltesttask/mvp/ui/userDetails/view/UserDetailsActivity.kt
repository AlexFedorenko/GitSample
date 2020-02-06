package com.dizzer.swivltesttask.mvp.ui.userDetails.view

import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dizzer.swivltesttask.R
import com.dizzer.swivltesttask.mvp.base.BaseActivity
import com.dizzer.swivltesttask.mvp.ui.userDetails.contract.UserDetailsActivityContract
import com.dizzer.swivltesttask.mvp.ui.userDetails.presenter.UserDetailsPresenter
import kotlinx.android.synthetic.main.activity_user_details.*
import javax.inject.Inject

class UserDetailsActivity : BaseActivity(), UserDetailsActivityContract.View {

    @Inject
    lateinit var presenter: UserDetailsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)
        presenter.setView(this)
        intent.extras?.let { presenter.onCreate(it) }
    }

    override fun performDependencyInjection() {
        activityComponent?.inject(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun setAvatar(avatar: String) {
        Glide.with(this)
            .load(avatar)
            .placeholder(resources.getDrawable(R.drawable.ic_avatar_placeholder, null))
            .apply(RequestOptions.circleCropTransform())
            .into(iv_user_avatar)
    }

    override fun setName(name: String) {
        title = name
        tv_user_name.text = name
    }

    override fun setRepository(repository: String) {
        tv_repos.text = repository
    }

    override fun setGists(gists: String) {
        tv_gists.text = gists
    }

    override fun setFollower(followers: String) {
        tv_followers.text = followers
    }

    override fun setUrl(url: String) {
        tv_user_url.text = url
    }
}
