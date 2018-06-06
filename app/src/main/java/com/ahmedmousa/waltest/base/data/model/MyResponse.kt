package com.ahmedmousa.waltest.base.data.model

/**
 * Created by karn on 18/1/18.
 */
sealed class MyResponse<T> {

    data class Progress<T>(var loading: Boolean) : MyResponse<T>()
    data class Success<T>(var data: T) : MyResponse<T>()
    data class Failure<T>(val e: Throwable) : MyResponse<T>()

    companion object {
        fun <T> loading(isLoading: Boolean): MyResponse<T> = Progress(isLoading)

        fun <T> success(data: T): MyResponse<T> = Success(data)

        fun <T> failure(e: Throwable): MyResponse<T> = Failure(e)
    }
}