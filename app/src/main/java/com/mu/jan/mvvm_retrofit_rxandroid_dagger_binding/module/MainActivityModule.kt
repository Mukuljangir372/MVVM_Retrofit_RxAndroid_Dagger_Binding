package com.mu.jan.mvvm_retrofit_rxandroid_dagger_binding.module

import android.content.Context
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.mu.jan.mvvm_retrofit_rxandroid_dagger_binding.data.api.MyApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class MainActivityModule(val context : Context) {
    @Provides
    @Singleton
    fun retrofit() : Retrofit{
        return Retrofit.Builder()
            .baseUrl("")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }
    @Provides
    @Singleton
    fun myApiService(retrofit: Retrofit) : MyApiService{
        return retrofit.create(MyApiService::class.java)
    }
}