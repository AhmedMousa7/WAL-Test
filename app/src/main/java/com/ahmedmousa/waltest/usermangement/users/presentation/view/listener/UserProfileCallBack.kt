package com.ahmedmousa.waltest.usermangement.users.presentation.view.listener

import com.ahmedmousa.waltest.usermangement.base.domain.entity.UserEntity

interface UserProfileCallBack{


    fun onShowUserProfile(userEntity: UserEntity)

}