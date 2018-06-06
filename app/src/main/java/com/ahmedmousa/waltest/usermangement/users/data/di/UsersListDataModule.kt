package com.ahmedmousa.waltest.usermangement.users.data.di


import com.ahmedmousa.waltest.usermangement.base.data.model.mapper.UserMapper
import com.ahmedmousa.waltest.usermangement.users.data.datasource.UsersListDataSource
import com.ahmedmousa.waltest.usermangement.users.data.datasource.remote.UsersListRemoteDataSource
import com.ahmedmousa.waltest.usermangement.users.data.datasource.remote.UsersListWebService
import com.ahmedmousa.waltest.usermangement.users.data.repo.UsersListRepositoryImpl
import com.ahmedmousa.waltest.usermangement.users.domain.repo.UsersListRepository
import com.ahmedmousa.waltest.usermangement.base.presentation.di.scope.UserMangementScope
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class UsersListDataModule {


    @Provides
    @UserMangementScope
    fun getWebService(retrofit: Retrofit) : UsersListWebService = retrofit.create(UsersListWebService::class.java)

    @Provides
    @UserMangementScope
    fun getUsersListDataMapper() : UserMapper = UserMapper()

    @Provides
    @UserMangementScope
    fun getUsersListRemoteDataSource(webservice: UsersListWebService): UsersListDataSource = UsersListRemoteDataSource(webservice)

    @Provides
    @UserMangementScope
    fun getUsersListRepository(userDataSource: UsersListDataSource, userMapper: UserMapper) : UsersListRepository =
            UsersListRepositoryImpl(userDataSource , userMapper)

}