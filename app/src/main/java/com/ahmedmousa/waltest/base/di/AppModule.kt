package com.ahmedmousa.waltest.base.di

import android.app.Application
import android.content.Context
import com.ahmedmousa.waltest.base.data.networking.ApiInterface
import com.ahmedmousa.waltest.base.data.networking.MySchedulerImpl
import com.ahmedmousa.waltest.base.data.networking.MyScheduler
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context = application.applicationContext


    @Provides
    @Singleton
    fun scheduler(): MyScheduler = MySchedulerImpl()


    @Provides
    @Singleton
    fun getRetrofit() : Retrofit = ApiInterface.create()

}