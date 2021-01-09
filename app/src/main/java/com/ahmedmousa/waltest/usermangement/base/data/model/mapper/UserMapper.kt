package com.ahmedmousa.waltest.usermangement.base.data.model.mapper


import com.ahmedmousa.waltest.usermangement.base.data.model.User
import com.ahmedmousa.waltest.usermangement.base.domain.entity.UserEntity
import javax.inject.Inject

class UserMapper @Inject constructor(){

    fun map(user : User?) : UserEntity {
        return UserEntity(login = user!!.login , url = user.htmlUrl , avatar_url = user.avatarUrl , location = user.location)
    }

    fun map(users : List<User>) : List<UserEntity> {
        return users.map { user: User -> map(user) }
    }
}