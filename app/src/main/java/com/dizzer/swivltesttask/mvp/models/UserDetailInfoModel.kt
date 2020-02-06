package com.dizzer.swivltesttask.mvp.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserDetailInfoModel(
    val avatar_url: String?,
    val bio: String?,
    val blog: String?,
    val company: String?,
    val created_at: String?,
    val email: String?,
    val events_url: String?,
    val followers: Int?,
    val followers_url: String?,
    val following: Int?,
    val following_url: String?,
    val gists_url: String?,
    val gravatar_id: String?,
    val hireable: String?,
    val html_url: String?,
    val id: Long?,
    val location: String?,
    val login: String?,
    val name: String?,
    val node_id: String?,
    val organizations_url: String?,
    val public_gists: Int?,
    val public_repos: Int?,
    val received_events_url: String?,
    val repos_url: String?,
    val site_admin: Boolean?,
    val starred_url: String?,
    val subscriptions_url: String?,
    val type: String?,
    val updated_at: String?,
    val url: String?
) : Parcelable