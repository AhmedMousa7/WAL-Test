package com.ahmedmousa.waltest.usermangement.users.domain.interactor

import com.ahmedmousa.waltest.usermangement.base.domain.entity.UserEntity
import com.ahmedmousa.waltest.usermangement.users.domain.repo.UsersListRepository
import io.reactivex.Single
import javax.inject.Inject

class UsersListUseCase @Inject constructor(private val usersListRepository : UsersListRepository){

    fun build() : Single<List<UserEntity>>{
        return usersListRepository.getUsersList()
    }
}