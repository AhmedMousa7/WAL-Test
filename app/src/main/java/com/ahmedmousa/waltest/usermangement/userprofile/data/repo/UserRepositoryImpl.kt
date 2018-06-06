package com.ahmedmousa.waltest.usermangement.userprofile.data.repo

import com.ahmedmousa.waltest.usermangement.userprofile.data.datasource.UserProfileDataSource
import com.ahmedmousa.waltest.usermangement.base.data.model.User
import com.ahmedmousa.waltest.usermangement.base.data.model.mapper.UserMapper
import com.ahmedmousa.waltest.usermangement.base.domain.entity.UserEntity
import com.ahmedmousa.waltest.usermangement.userprofile.domain.repo.UserRepository
import io.reactivex.Single
import javax.inject.Inject


class UserRepositoryImpl @Inject constructor(private val userProfileDataSource: UserProfileDataSource, private val userEntityMapper: UserMapper) : UserRepository {


    override fun getUser(username : String) : Single<UserEntity>{

        return userProfileDataSource.getUser(username).map{ user: User ->
            userEntityMapper.map(user)
        }
    }
}