package com.ahmedmousa.waltest.usermangement.userprofile.data.datasource

import com.ahmedmousa.waltest.usermangement.base.data.model.User
import io.reactivex.Single

interface UserProfileDataSource{

    fun getUser(username : String) : Single<User>
}