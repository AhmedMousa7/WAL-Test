package com.ahmedmousa.waltest.usermangement.userprofile.domain.repo

import com.ahmedmousa.waltest.usermangement.base.domain.entity.UserEntity
import io.reactivex.Single


interface UserRepository{

    fun getUser(username : String) : Single<UserEntity>
}