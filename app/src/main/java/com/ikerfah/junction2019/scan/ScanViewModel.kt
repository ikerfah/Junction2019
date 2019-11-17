package com.ikerfah.junction2019.scan

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ikerfah.junction2019.retro.ApiRepository
import com.ikerfah.junction2019.retro.DataWrapper
import com.ikerfah.junction2019.retro.ScanRecipeResponse

class ScanViewModel : ViewModel {


    var repo : ApiRepository
    private var data =  MutableLiveData<DataWrapper<ScanRecipeResponse>>()

    constructor(){
        repo = ApiRepository()
    }


    fun addRecipe(qr: String):LiveData<DataWrapper<ScanRecipeResponse>> {

        return repo.addRecipe(qr)
    }
}