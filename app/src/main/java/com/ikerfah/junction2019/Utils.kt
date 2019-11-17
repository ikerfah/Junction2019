package com.ikerfah.junction2019

import com.ikerfah.junction2019.kitchen.MyChickenChild
import com.ikerfah.junction2019.models.ProductResponse

class Utils {

    companion object{
        fun getDataFromProductResponse(response: ProductResponse): HashMap<String, List<MyChickenChild>> {
            var hashMapToReturn: HashMap<String, List<MyChickenChild>> = hashMapOf()
            var fak = Faker.getData()
            response.result?.forEach {
                var products = arrayListOf<MyChickenChild>()
                it.products?.forEach {
                    products.add(MyChickenChild(it.name, it.weight.toString(),it.image))
                }
                hashMapToReturn[it.id.toString()] = products
            }

            return hashMapToReturn
        }
    }
}