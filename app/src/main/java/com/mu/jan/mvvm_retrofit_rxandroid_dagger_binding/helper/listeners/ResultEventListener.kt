package com.mu.jan.mvvm_retrofit_rxandroid_dagger_binding.helper.listeners

import com.mu.jan.mvvm_retrofit_rxandroid_dagger_binding.data.model.MyResult

interface ResultEventListener {
    fun onFailed(t : Throwable)
    fun onSuccess(result : MyResult)
}