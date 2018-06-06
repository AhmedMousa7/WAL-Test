package com.ahmedmousa.waltest.usermangement.users.data.datasource.remote

import com.ahmedmousa.waltest.usermangement.base.data.model.User
import io.reactivex.Single
import retrofit2.http.GET

interface UsersListWebService {

    /**
     * @GET declares an HTTP GET request
     * @Path("user") annotation on the userId parameter marks it as a
     * replacement for the {user} placeholder in the @GET path
     */
    @GET("/users")
    fun getUsers(): Single<List<User>>

}