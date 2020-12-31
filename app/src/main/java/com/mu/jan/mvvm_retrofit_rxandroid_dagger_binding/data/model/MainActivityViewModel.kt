package com.mu.jan.mvvm_retrofit_rxandroid_dagger_binding.data.model

import androidx.lifecycle.MutableLiveData
import com.mu.jan.mvvm_retrofit_rxandroid_dagger_binding.data.api.MyApiService
import com.mu.jan.mvvm_retrofit_rxandroid_dagger_binding.data.repository.MainActivityRepo
import com.mu.jan.mvvm_retrofit_rxandroid_dagger_binding.helper.listeners.ResultEvent
import com.mu.jan.mvvm_retrofit_rxandroid_dagger_binding.helper.listeners.ResultEventListener

class MainActivityViewModel(val service : MyApiService){

    private lateinit var list : MutableLiveData<MyResult>
    private var resultEvent : ResultEvent = ResultEvent()

    fun getList(OnSuccess: (MutableLiveData<MyResult>) -> Unit,OnFailed : (Throwable) -> Unit){
        //get list using Repo
        //callback
        resultEvent.setListener(object : ResultEventListener{
            override fun onFailed(t: Throwable) {
                OnFailed(t)
            }
            override fun onSuccess(result: MyResult) {
                //convert result into LiveData
                val mLiveData = MutableLiveData<MyResult>()
                mLiveData.value = result

                OnSuccess(mLiveData)
            }
        })
        MainActivityRepo.loadList(resultEvent,service)
    }
}