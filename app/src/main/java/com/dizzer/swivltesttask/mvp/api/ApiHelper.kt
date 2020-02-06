package com.dizzer.swivltesttask.mvp.api

import com.dizzer.swivltesttask.mvp.models.UserDetailInfoModel
import com.dizzer.swivltesttask.mvp.models.UserModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiHelper {
    @GET("/users")
    fun getUsers(): Observable<List<UserModel>>
    @GET("/users")
    fun getUsers(@Query("since") userId: Long): Observable<List<UserModel>>
    @GET("/users/{login}")
    fun getUserDetails(@Path("login") login : String): Observable<UserDetailInfoModel>
}
