package com.ahmedmousa.waltest.base.data.model.extensions

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.ahmedmousa.waltest.base.data.model.MyResponse
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject


/**
 * Extension function to convert a Publish subject into a LiveData by subscribing to it.
 **/
fun <T> PublishSubject<T>.toLiveData(compositeDisposable: CompositeDisposable): LiveData<T> {
    val data = MutableLiveData<T>()
    compositeDisposable.add(this.subscribe({ t: T -> data.value = t }))
    return data
}

/**
 * Extension function to push a failed event with an exception to the observing MyResponse
 * */
fun <T> PublishSubject<MyResponse<T>>.failed(e: Throwable) {
    with(this){
        loading(false)
        onNext(MyResponse.failure(e))
    }
}

/**
 * Extension function to push  a success event with data to the observing MyResponse
 * */
fun <T> PublishSubject<MyResponse<T>>.success(t: T) {
    with(this){
        loading(false)
        onNext(MyResponse.success(t))
    }
}

/**
 * Extension function to push the loading status to the observing MyResponse
 * */
fun <T> PublishSubject<MyResponse<T>>.loading(isLoading: Boolean) {
    this.onNext(MyResponse.loading(isLoading))
}