package com.ahmedmousa.waltest.usermangement.userprofile.presentation.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.ahmedmousa.waltest.base.data.model.MyResponse
import com.ahmedmousa.waltest.base.data.model.extensions.*
import com.ahmedmousa.waltest.base.data.networking.MyScheduler
import com.ahmedmousa.waltest.usermangement.base.domain.entity.UserEntity
import com.ahmedmousa.waltest.usermangement.userprofile.domain.interactor.UserProfileUseCase
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

class UserProfileViewModel @Inject constructor(private val userProfileUseCase: UserProfileUseCase, private val compositeDisposable: CompositeDisposable,
                                               private val userInfoPublishSubject  : PublishSubject<MyResponse<UserEntity>>, private val scheduler: MyScheduler) : ViewModel(){


    private val userInfo: LiveData<MyResponse<UserEntity>> by lazy {
        userInfoPublishSubject.toLiveData(compositeDisposable)
    }

    fun getUser(username: String) : LiveData<MyResponse<UserEntity>> {
        if (userInfo.value == null) {

            userInfoPublishSubject.loading(true)

            userProfileUseCase.build(username)
                    .performOnBackOutOnMain(scheduler)
                    .subscribe({ user ->
                        userInfoPublishSubject.success(user)
                    }, { error ->
                        userInfoPublishSubject.failed(error)
                    })
                    .addTo(compositeDisposable)
        }

        return userInfo
    }

    override fun onCleared() {
        compositeDisposable.clear()
    }

}