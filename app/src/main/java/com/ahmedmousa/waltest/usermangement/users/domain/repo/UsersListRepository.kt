package com.ahmedmousa.waltest.usermangement.users.domain.repo

import com.ahmedmousa.waltest.usermangement.base.domain.entity.UserEntity
import io.reactivex.Single

interface UsersListRepository{

    fun getUsersList() : Single<List<UserEntity>>
}