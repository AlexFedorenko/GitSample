package com.dizzer.swivltesttask.mvp.api

import com.dizzer.swivltesttask.mvp.models.UserModel
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiHelper {
    @GET("/users")
    fun getUsers(): Observable<List<UserModel>>
}
