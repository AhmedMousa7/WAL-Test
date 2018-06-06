package com.ahmedmousa.waltest.usermangement.base.domain.entity



data class UserEntity (var login: String? = null, var id: Int = 0,
                       var avatar_url: String? = null , var url: String? = null, var name: String? = null , var location: String? = null,
                       var followers: Int = 0, var following: Int = 0,
                       var created_at: String? = null , var updated_at: String?= null)
