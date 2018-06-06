package com.ahmedmousa.waltest.base.data.model.extensions

import com.ahmedmousa.waltest.base.data.networking.MyScheduler
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Extension function to subscribe on the background thread and observe on the main thread for a Completable
 * */
fun Completable.performOnBackOutOnMain(myScheduler: MyScheduler): Completable {
    return this.subscribeOn(myScheduler.io())
            .observeOn(myScheduler.mainThread())
}

/**
 * Extension function to subscribe on the background thread and observe on the main thread  for a Flowable
 * */
fun <T> Flowable<T>.performOnBackOutOnMain(myScheduler: MyScheduler): Flowable<T> {
    return this.subscribeOn(myScheduler.io())
            .observeOn(myScheduler.mainThread())
}

/**
 * Extension function to subscribe on the background thread and observe on the main thread for a Observable
 * */
fun <T> Observable<T>.performOnBackOutOnMain(myScheduler: MyScheduler): Observable<T> {
    return this.subscribeOn(myScheduler.io())
            .observeOn(myScheduler.mainThread())
}

/**
 * Extension function to subscribe on the background thread and observe on the main thread for a Single
 * */
fun <T> Single<T>.performOnBackOutOnMain(myScheduler: MyScheduler): Single<T> {
    return this.subscribeOn(myScheduler.io())
            .observeOn(myScheduler.mainThread())
}

/**
 * Extension function to add a Disposable to a CompositeDisposable
 */
fun Disposable.addTo(compositeDisposable: CompositeDisposable) {
    compositeDisposable.add(this)
}

/**
 * Extension function to subscribe on the background thread for a Flowable
 * */
fun <T> Flowable<T>.performOnBack(myScheduler: MyScheduler): Flowable<T> {
    return this.subscribeOn(myScheduler.io())
}

/**
 * Extension function to subscribe on the background thread for a Completable
 * */
fun Completable.performOnBack(myScheduler: MyScheduler): Completable {
    return this.subscribeOn(myScheduler.io())
}

/**
 * Extension function to subscribe on the background thread for a Observable
 * */
fun <T> Observable<T>.performOnBack(myScheduler: MyScheduler): Observable<T> {
    return this.subscribeOn(myScheduler.io())
}