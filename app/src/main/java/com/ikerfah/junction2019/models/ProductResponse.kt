package com.ikerfah.junction2019.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ProductResponse {



    @SerializedName("result")
    @Expose
    var result: List<Result>? = null

    inner class Result{

        @SerializedName("id")
        @Expose
        var id: String? = null
        @SerializedName("products")
        @Expose
        var products: List<Product>? = null
        inner class Product {

            @SerializedName("id")
            @Expose
            var id: Int? = null
            @SerializedName("name")
            @Expose
            var name: String? = null
            @SerializedName("weight")
            @Expose
            var weight: Int? = null
            @SerializedName("category")
            @Expose
            var category: String? = null
            @SerializedName("image")
            @Expose
            var image: String? = null
        }
    }

}