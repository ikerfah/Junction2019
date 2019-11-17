package com.ikerfah.junction2019.retro

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ikerfah.junction2019.models.ProductResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.Executors


class ApiRepository {

    private var retrofit: Retrofit? = null
    private var service: ApiService? = null


    constructor() {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.43.15:8001/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .callbackExecutor(Executors.newSingleThreadExecutor())
            .build()
        service = retrofit!!.create(ApiService::class.java)
    }

    fun addRecipe(qrcode :String): LiveData<DataWrapper<ScanRecipeResponse>> {

        var data = MutableLiveData<DataWrapper<ScanRecipeResponse>>(
            DataWrapper<ScanRecipeResponse>(
                Ressource.LOADING,
                null
            )
        )
        service?.listRepos(qrcode)?.enqueue(object : Callback<ScanRecipeResponse> {

            override fun onFailure(call: Call<ScanRecipeResponse>, t: Throwable) {

                data.value = DataWrapper(Ressource.FAILED, null)
            }

            override fun onResponse(
                call: Call<ScanRecipeResponse>,
                response: Response<ScanRecipeResponse>
            ) {
                if (response.isSuccessful) {
                    data.postValue( DataWrapper(Ressource.SUCCES, response.body()))
                }
            }

        })

        return data
    }


    fun getMissedProduct(): LiveData<DataWrapper<ProductResponse>> {

        var data = MutableLiveData<DataWrapper<ProductResponse>>(
            DataWrapper<ProductResponse>(
                Ressource.LOADING,
                null
            )
        )
        service?.missedProducts()?.enqueue(object : Callback<ProductResponse> {

            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {

                data.value = DataWrapper(Ressource.FAILED, null)
            }

            override fun onResponse(
                call: Call<ProductResponse>,
                response: Response<ProductResponse>
            ) {
                if (response.isSuccessful) {
                    data.postValue( DataWrapper(Ressource.SUCCES, response.body()))
                }
            }

        })

        return data
    }

    fun getAllProducts(): LiveData<DataWrapper<ProductResponse>> {

        var data = MutableLiveData<DataWrapper<ProductResponse>>(
            DataWrapper<ProductResponse>(
                Ressource.LOADING,
                null
            )
        )
        service?.missedProducts()?.enqueue(object : Callback<ProductResponse> {

            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {

                data.value = DataWrapper(Ressource.FAILED, null)
            }

            override fun onResponse(
                call: Call<ProductResponse>,
                response: Response<ProductResponse>
            ) {
                if (response.isSuccessful) {
                    data.postValue( DataWrapper(Ressource.SUCCES, response.body()))
                }
            }

        })

        return data
    }

}