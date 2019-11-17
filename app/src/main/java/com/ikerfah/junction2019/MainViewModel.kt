package com.ikerfah.junction2019

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ikerfah.junction2019.models.ProductResponse
import com.ikerfah.junction2019.retro.ApiRepository
import com.ikerfah.junction2019.retro.DataWrapper
import com.ikerfah.junction2019.retro.ScanRecipeResponse

class MainViewModel : ViewModel {


    var repo : ApiRepository
    private var products =  MutableLiveData<DataWrapper<ProductResponse>>()

    constructor(){
        repo = ApiRepository()
    }


    fun getMissedProduct():LiveData<DataWrapper<ProductResponse>> {

        return repo.getMissedProduct()
    }
}