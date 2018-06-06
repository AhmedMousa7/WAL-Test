package com.ahmedmousa.waltest.base.data.networking

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Implementation of [MyScheduler] with actual threads.
 * */
class MySchedulerImpl : MyScheduler {

    override fun mainThread(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

    override fun io(): Scheduler {
        return Schedulers.io()
    }
}