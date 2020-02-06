package com.dizzer.swivltesttask.di.component

import com.dizzer.swivltesttask.di.PerActivity
import com.dizzer.swivltesttask.di.module.ActivityModule
import com.dizzer.swivltesttask.mvp.ui.main.view.MainActivity
import dagger.Component

@PerActivity
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {
    fun inject(activity: MainActivity)
}
