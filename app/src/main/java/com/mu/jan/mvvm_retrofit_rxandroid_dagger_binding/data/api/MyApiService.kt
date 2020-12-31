package com.mu.jan.mvvm_retrofit_rxandroid_dagger_binding.data.api

import com.mu.jan.mvvm_retrofit_rxandroid_dagger_binding.data.model.MyResult
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface MyApiService {
    @GET("search")
    fun getResult(@Query("key") key : String): Observable<MyResult>
}