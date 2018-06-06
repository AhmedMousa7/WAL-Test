package com.ahmedmousa.waltest.base.data.networking

import io.reactivex.Scheduler

/**
 *  Interface to mock different threads during testing.
* */
interface MyScheduler {
    fun mainThread():Scheduler
    fun io():Scheduler
}