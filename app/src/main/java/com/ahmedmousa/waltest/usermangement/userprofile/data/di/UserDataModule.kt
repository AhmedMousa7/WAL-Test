package com.ahmedmousa.waltest.usermangement.userprofile.data.di

import com.ahmedmousa.waltest.usermangement.userprofile.data.datasource.UserProfileDataSource
import com.ahmedmousa.waltest.usermangement.userprofile.data.datasource.remote.UserProfileWebservice
import com.ahmedmousa.waltest.usermangement.userprofile.data.datasource.remote.UserRemoteProfileDataSource
import com.ahmedmousa.waltest.usermangement.base.data.model.mapper.UserMapper
import com.ahmedmousa.waltest.usermangement.base.presentation.di.scope.UserMangementScope
import com.ahmedmousa.waltest.usermangement.userprofile.data.repo.UserRepositoryImpl
import com.ahmedmousa.waltest.usermangement.userprofile.domain.repo.UserRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class UserDataModule{

    @Provides
    @UserMangementScope
    fun getWebService(retrofit: Retrofit) : UserProfileWebservice = retrofit.create(UserProfileWebservice::class.java)

    @Provides
    @UserMangementScope
    fun getUserDataMapper() : UserMapper = UserMapper()

    @Provides
    @UserMangementScope
    fun getUserRemoteDataSource(userProfileWebservice: UserProfileWebservice): UserProfileDataSource = UserRemoteProfileDataSource(userProfileWebservice)

    @Provides
    @UserMangementScope
    fun getUserRepository(userProfileDataSource: UserProfileDataSource, userMapper: UserMapper) : UserRepository =
            UserRepositoryImpl(userProfileDataSource , userMapper)
}