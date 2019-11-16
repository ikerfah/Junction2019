package com.ikerfah.junction2019.kitchen

class MyChickenChild{

    var name: String? = null
    var weight: String? = null
        get() = "$field kg"


    constructor(name: String?, weight: String?) {
        this.name = name
        this.weight = weight
    }
}