package com.ahmedmousa.waltest.usermangement.users.data.repo

import com.ahmedmousa.waltest.usermangement.base.data.model.User
import com.ahmedmousa.waltest.usermangement.base.data.model.mapper.UserMapper
import com.ahmedmousa.waltest.usermangement.base.domain.entity.UserEntity
import com.ahmedmousa.waltest.usermangement.users.data.datasource.UsersListDataSource
import com.ahmedmousa.waltest.usermangement.users.domain.repo.UsersListRepository
import io.reactivex.Single

class UsersListRepositoryImpl(private val usersListDataSource: UsersListDataSource, private val userEntityMapper: UserMapper) : UsersListRepository {

    override fun getUsersList(): Single<List<UserEntity>> {
        return usersListDataSource.getUsersList().map{ users: List<User> ->
            userEntityMapper.map(users)
        }
    }

}