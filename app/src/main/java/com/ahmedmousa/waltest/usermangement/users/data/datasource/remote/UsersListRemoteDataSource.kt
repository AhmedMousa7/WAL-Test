package com.ahmedmousa.waltest.usermangement.users.data.datasource.remote

import com.ahmedmousa.waltest.usermangement.base.data.model.User
import com.ahmedmousa.waltest.usermangement.users.data.datasource.UsersListDataSource
import io.reactivex.Single
import javax.inject.Inject

class UsersListRemoteDataSource @Inject constructor(private val usersListWebService: UsersListWebService) : UsersListDataSource {

    override fun getUsersList(): Single<List<User>> {
       return usersListWebService.getUsers()
    }

}