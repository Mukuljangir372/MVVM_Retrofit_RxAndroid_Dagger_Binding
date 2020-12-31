package com.mu.jan.mvvm_retrofit_rxandroid_dagger_binding.helper.listeners

import com.mu.jan.mvvm_retrofit_rxandroid_dagger_binding.data.model.MyResult

class ResultEvent {
    lateinit var l : ResultEventListener
    fun setListener(l : ResultEventListener){
        this.l = l
    }
    fun onSuccess(result : MyResult){
        if(this::l.isInitialized) l.onSuccess(result)
    }
    fun onFailed(t : Throwable){
        if(this::l.isInitialized) l.onFailed(t)
    }

}