package com.ahmedmousa.waltest.usermangement.base.presentation.di.module

import com.ahmedmousa.waltest.usermangement.base.presentation.di.scope.UserMangementScope
import com.ahmedmousa.waltest.usermangement.userprofile.presentation.view.fragment.FragmentUserProfile
import com.ahmedmousa.waltest.usermangement.users.presentation.view.fragment.FragmentUsersList
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    @UserMangementScope
    fun provideUsersListFragment() : FragmentUsersList = FragmentUsersList()

    @Provides
    @UserMangementScope
    fun provideUserProfileFragment() : FragmentUserProfile = FragmentUserProfile()

}