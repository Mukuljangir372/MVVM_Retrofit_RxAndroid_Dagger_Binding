package com.mu.jan.mvvm_retrofit_rxandroid_dagger_binding.data.repository

import androidx.lifecycle.MutableLiveData
import com.mu.jan.mvvm_retrofit_rxandroid_dagger_binding.data.api.MyApiService
import com.mu.jan.mvvm_retrofit_rxandroid_dagger_binding.data.model.MyResult
import com.mu.jan.mvvm_retrofit_rxandroid_dagger_binding.helper.listeners.ResultEvent
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Response

object MainActivityRepo {
    //we use Repo for getting list from source, source can be online or offline
    fun loadList(listener : ResultEvent,service : MyApiService){
        //get list from online or offline source
        service.getResult("key").subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                listener.onSuccess(it)
            },{
                listener.onFailed(it)
            })
    }

}