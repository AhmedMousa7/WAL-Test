package com.ahmedmousa.waltest.usermangement.userprofile.domain.di

import com.ahmedmousa.waltest.usermangement.base.presentation.di.scope.UserMangementScope
import com.ahmedmousa.waltest.usermangement.userprofile.domain.interactor.UserProfileUseCase
import com.ahmedmousa.waltest.usermangement.userprofile.domain.repo.UserRepository
import dagger.Module
import dagger.Provides


@Module
class UserDomainModule{

    @Provides
    @UserMangementScope
    fun getUserProfileUseCase(userRepository: UserRepository) : UserProfileUseCase = UserProfileUseCase(userRepository)

}