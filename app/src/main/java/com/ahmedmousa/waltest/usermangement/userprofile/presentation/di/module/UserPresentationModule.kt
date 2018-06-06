package com.ahmedmousa.waltest.usermangement.userprofile.presentation.di.module

import com.ahmedmousa.waltest.base.data.model.MyResponse
import com.ahmedmousa.waltest.base.data.networking.MyScheduler
import com.ahmedmousa.waltest.usermangement.base.domain.entity.UserEntity
import com.ahmedmousa.waltest.usermangement.base.presentation.di.scope.UserMangementScope
import com.ahmedmousa.waltest.usermangement.userprofile.domain.interactor.UserProfileUseCase
import com.ahmedmousa.waltest.usermangement.userprofile.presentation.viewmodel.UserProfileViewModel
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject


@Module
class UserPresentationModule {

    @Provides
    @UserMangementScope
    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    @UserMangementScope
    fun provideUserInfoPublishSubject() : PublishSubject<MyResponse<UserEntity>> = PublishSubject.create()

    @Provides
    @UserMangementScope
    fun provideUserProfileViewModel(userProfileUseCase: UserProfileUseCase, compositeDisposable: CompositeDisposable,
                                scheduler : MyScheduler , userInfoPublishSubject  : PublishSubject<MyResponse<UserEntity>>) : UserProfileViewModel
            = UserProfileViewModel(userProfileUseCase , compositeDisposable , userInfoPublishSubject , scheduler)

}