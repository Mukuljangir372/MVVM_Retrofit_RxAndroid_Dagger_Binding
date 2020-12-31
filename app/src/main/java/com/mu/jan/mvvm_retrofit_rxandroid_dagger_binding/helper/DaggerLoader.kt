package com.mu.jan.mvvm_retrofit_rxandroid_dagger_binding.helper

import com.mu.jan.mvvm_retrofit_rxandroid_dagger_binding.component.DaggerUniversalComponent
import com.mu.jan.mvvm_retrofit_rxandroid_dagger_binding.module.MainActivityModule
import com.mu.jan.mvvm_retrofit_rxandroid_dagger_binding.ui.activities.MainActivity

object DaggerLoader {
    fun inject(activity : MainActivity){
        DaggerUniversalComponent.builder()
                .mainActivityModule(MainActivityModule(activity))
                .build().inject(activity)
    }
}