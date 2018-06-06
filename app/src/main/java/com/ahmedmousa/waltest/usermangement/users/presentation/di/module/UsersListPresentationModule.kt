package com.ahmedmousa.waltest.usermangement.users.presentation.di.module


import com.ahmedmousa.waltest.base.data.model.MyResponse
import com.ahmedmousa.waltest.base.data.networking.MyScheduler
import com.ahmedmousa.waltest.usermangement.base.domain.entity.UserEntity
import com.ahmedmousa.waltest.usermangement.users.domain.interactor.UsersListUseCase
import com.ahmedmousa.waltest.usermangement.base.presentation.di.scope.UserMangementScope
import com.ahmedmousa.waltest.usermangement.users.presentation.view.adapter.UsersListAdapter
import com.ahmedmousa.waltest.usermangement.users.presentation.viewmodel.UsersListViewModel
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject

@Module
class UsersListPresentationModule{


    @Provides
    @UserMangementScope
    fun provideUsersListAdapter() : UsersListAdapter = UsersListAdapter()

    @Provides
    @UserMangementScope
    fun provideComposite() : CompositeDisposable = CompositeDisposable()

    @Provides
    @UserMangementScope
    fun provideUsersListPublishSubject() : PublishSubject<MyResponse<List<UserEntity>>> = PublishSubject.create()

    @Provides
    @UserMangementScope
    fun provideUsersListViewModel(usersListUseCase: UsersListUseCase, scheduler: MyScheduler, compositeDisposable: CompositeDisposable ,
                                  usersListPublishSubject : PublishSubject<MyResponse<List<UserEntity>>>)
            : UsersListViewModel = UsersListViewModel(usersListUseCase , compositeDisposable , usersListPublishSubject , scheduler)

}