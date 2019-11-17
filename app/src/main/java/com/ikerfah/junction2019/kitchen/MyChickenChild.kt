package com.ikerfah.junction2019.kitchen

class MyChickenChild{

    var name: String? = null
    var weight: String? = null
        get() = "$field kg"
    var imgUrl: String? = null


    constructor(name: String?, weight: String?) {
        this.name = name
        this.weight = weight
    }

    constructor(name: String?, weight: String?, imgUrl: String?) {
        this.name = name
        this.weight = weight
        this.imgUrl = imgUrl
    }


}