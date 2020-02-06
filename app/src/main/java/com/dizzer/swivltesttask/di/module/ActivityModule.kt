package com.dizzer.swivltesttask.di.module

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.dizzer.swivltesttask.di.ActivityContext
import com.dizzer.swivltesttask.di.PerActivity
import com.dizzer.swivltesttask.mvp.ui.main.presenter.MainPresenter
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import retrofit2.Retrofit

@Module
class ActivityModule(private val mActivity: AppCompatActivity) {

    @Provides
    @ActivityContext
    internal fun provideContext(): Context {
        return mActivity
    }

    @Provides
    internal fun provideActivity(): AppCompatActivity {
        return mActivity
    }

    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }

    @Provides
    @PerActivity
    internal fun provideMainPresenter(
        retrofit: Retrofit,
        compositeDisposable: CompositeDisposable, application: Application
    ): MainPresenter {
        return MainPresenter(retrofit, compositeDisposable, application)
    }
}
