package com.ahmedmousa.waltest.usermangement.userprofile.domain.interactor

import com.ahmedmousa.waltest.usermangement.base.domain.entity.UserEntity
import com.ahmedmousa.waltest.usermangement.userprofile.domain.repo.UserRepository
import io.reactivex.Single
import javax.inject.Inject

class UserProfileUseCase @Inject constructor(private val userRepository: UserRepository) {

    fun build(username : String) : Single<UserEntity>{
        return userRepository.getUser(username)
    }

}