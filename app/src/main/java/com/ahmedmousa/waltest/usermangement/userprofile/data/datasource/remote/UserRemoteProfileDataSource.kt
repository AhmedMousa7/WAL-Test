package com.ahmedmousa.waltest.usermangement.userprofile.data.datasource.remote

import com.ahmedmousa.waltest.usermangement.userprofile.data.datasource.UserProfileDataSource
import com.ahmedmousa.waltest.usermangement.base.data.model.User
import io.reactivex.Single

import javax.inject.Inject

class UserRemoteProfileDataSource @Inject constructor(private val userProfileWebservice: UserProfileWebservice) : UserProfileDataSource {

    override fun getUser(username: String) : Single<User>{
        return userProfileWebservice.getUser(username)
    }

}