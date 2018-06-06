package com.ahmedmousa.waltest.base.di

import com.ahmedmousa.waltest.usermangement.base.presentation.di.module.MainActivityModule
import com.ahmedmousa.waltest.usermangement.base.presentation.view.activity.MainActivity
import com.ahmedmousa.waltest.usermangement.userprofile.data.di.UserDataModule
import com.ahmedmousa.waltest.usermangement.userprofile.domain.di.UserDomainModule
import com.ahmedmousa.waltest.usermangement.userprofile.presentation.di.module.UserPresentationModule
import com.ahmedmousa.waltest.usermangement.userprofile.presentation.view.fragment.FragmentUserProfile
import com.ahmedmousa.waltest.usermangement.users.data.di.UsersListDataModule
import com.ahmedmousa.waltest.usermangement.users.domain.di.UsersListDomainModule
import com.ahmedmousa.waltest.usermangement.users.presentation.di.module.UsersListPresentationModule
import com.ahmedmousa.waltest.usermangement.base.presentation.di.scope.UserMangementScope
import com.ahmedmousa.waltest.usermangement.users.presentation.view.fragment.FragmentUsersList
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class DIModulesBinder {

    @UserMangementScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindMainActivity() : MainActivity

    @UserMangementScope
    @ContributesAndroidInjector(modules = [UserPresentationModule::class , UserDomainModule::class , UserDataModule::class])
    abstract fun bindUserProfileFragment() : FragmentUserProfile

    @UserMangementScope
    @ContributesAndroidInjector(modules = [UsersListPresentationModule::class , UsersListDataModule::class , UsersListDomainModule::class])
    abstract fun bindUsersListFragment() : FragmentUsersList

}