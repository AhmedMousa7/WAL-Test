package com.ahmedmousa.waltest.usermangement.userprofile.data.datasource.remote

import com.ahmedmousa.waltest.usermangement.base.data.model.User
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface UserProfileWebservice{


    /**
     * @GET declares an HTTP GET request
     * @Path("user") annotation on the userId parameter marks it as a
     * replacement for the {user} placeholder in the @GET path
     */
    @GET("/users/{username}")
    fun getUser(@Path("username") userId: String): Single<User>

}