package com.mu.jan.mvvm_retrofit_rxandroid_dagger_binding.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mu.jan.mvvm_retrofit_rxandroid_dagger_binding.R
import com.mu.jan.mvvm_retrofit_rxandroid_dagger_binding.data.api.MyApiService
import com.mu.jan.mvvm_retrofit_rxandroid_dagger_binding.data.model.MainActivityViewModel
import com.mu.jan.mvvm_retrofit_rxandroid_dagger_binding.databinding.ActivityMainBinding
import com.mu.jan.mvvm_retrofit_rxandroid_dagger_binding.helper.DaggerLoader
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    //binding
    private lateinit var binding : ActivityMainBinding
    //viewModel
    private lateinit var mainActivityViewModel : MainActivityViewModel
    //inject
    @Inject lateinit var myApiService : MyApiService


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //dagger
        DaggerLoader.inject(this)
        //RecyclerView
        //recyclerView = binding.recyclerView
        //viewModel
        mainActivityViewModel = MainActivityViewModel(myApiService)
        mainActivityViewModel.getList({
            //setAdapter
            //recyclerView.adapter = CustomAdapter(context,it.value)
        },{
            //error
        })


    }
}