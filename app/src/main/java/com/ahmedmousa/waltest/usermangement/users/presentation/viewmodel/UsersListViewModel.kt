package com.ahmedmousa.waltest.usermangement.users.presentation.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.ahmedmousa.waltest.base.data.model.MyResponse
import com.ahmedmousa.waltest.base.data.model.extensions.*
import com.ahmedmousa.waltest.base.data.networking.MyScheduler
import com.ahmedmousa.waltest.usermangement.base.domain.entity.UserEntity
import com.ahmedmousa.waltest.usermangement.users.domain.interactor.UsersListUseCase
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

class UsersListViewModel @Inject constructor(private val usersListUseCase : UsersListUseCase,
                                             private val compositeDisposable: CompositeDisposable,
                                             private val usersListPublishSubject : PublishSubject<MyResponse<List<UserEntity>>>,
                                             private val myScheduler: MyScheduler) : ViewModel(){

    private val usersListLiveData : LiveData<MyResponse<List<UserEntity>>> by lazy {
        usersListPublishSubject.toLiveData(compositeDisposable)
    }

    fun getUsersList() : LiveData<MyResponse<List<UserEntity>>>{

        if (usersListLiveData.value == null){

            usersListUseCase.build()
                    .performOnBackOutOnMain(myScheduler)
                    .subscribe ({ users ->
                       usersListPublishSubject.success(users)
                    } , {error ->
                        usersListPublishSubject.failed(error)
                    }).addTo(compositeDisposable)
        }

        return usersListLiveData
    }

    override fun onCleared() {
        compositeDisposable.clear()
    }

}