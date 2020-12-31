package com.mu.jan.mvvm_retrofit_rxandroid_dagger_binding.component

import com.mu.jan.mvvm_retrofit_rxandroid_dagger_binding.ui.activities.MainActivity
import com.mu.jan.mvvm_retrofit_rxandroid_dagger_binding.module.MainActivityModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MainActivityModule::class])
interface UniversalComponent {
    fun inject(activity : MainActivity)

}