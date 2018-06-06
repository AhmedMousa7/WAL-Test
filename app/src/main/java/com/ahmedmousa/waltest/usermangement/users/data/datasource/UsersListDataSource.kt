package com.ahmedmousa.waltest.usermangement.users.data.datasource

import com.ahmedmousa.waltest.usermangement.base.data.model.User
import io.reactivex.Single

interface UsersListDataSource{

    fun getUsersList() : Single<List<User>>
}