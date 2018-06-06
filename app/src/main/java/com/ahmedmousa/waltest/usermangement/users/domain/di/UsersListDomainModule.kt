package com.ahmedmousa.waltest.usermangement.users.domain.di

import com.ahmedmousa.waltest.usermangement.users.domain.interactor.UsersListUseCase
import com.ahmedmousa.waltest.usermangement.users.domain.repo.UsersListRepository
import com.ahmedmousa.waltest.usermangement.base.presentation.di.scope.UserMangementScope
import dagger.Module
import dagger.Provides

@Module
class UsersListDomainModule {

    @Provides
    @UserMangementScope
    fun provideUsersListUseCase(usersListRepository: UsersListRepository)  =  UsersListUseCase(usersListRepository)

}