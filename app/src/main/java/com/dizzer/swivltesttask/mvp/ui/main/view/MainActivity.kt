package com.dizzer.swivltesttask.mvp.ui.main.view

import android.content.Intent
import android.os.Bundle
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.dizzer.swivltesttask.R
import com.dizzer.swivltesttask.mvp.base.BaseActivity
import com.dizzer.swivltesttask.mvp.models.UserModel
import com.dizzer.swivltesttask.mvp.ui.main.adapter.UsersAdapter
import com.dizzer.swivltesttask.mvp.ui.main.contract.MainActivityContract
import com.dizzer.swivltesttask.mvp.ui.main.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainActivityContract.View, UsersAdapter.OnUserClickListener,
    SwipeRefreshLayout.OnRefreshListener{

    @Inject
    lateinit var presenter: MainPresenter
    private val adapter = UsersAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.setView(this)
        rv_users.adapter = adapter
        srl_holder.setOnRefreshListener(this)
        presenter.getUsers()
    }

    override fun performDependencyInjection() {
        activityComponent?.inject(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun setUsers(data: List<UserModel>) {
        adapter.models = data
        srl_holder.isRefreshing = false
    }

    override fun onUserClick(position: Int) {
        presenter.onUserClick(position)
    }

    override fun openUser(intent: Intent) {
        startActivity(intent)
    }

    override fun onRefresh() {
        presenter.getUsers()
    }
}
