package com.ikerfah.junction2019.retro

class DataWrapper<T> {

    var state: Ressource = Ressource.INITIAL
    var data: T? = null


    constructor(state: Ressource, data: T?) {
        this.state = state
        this.data = data
    }
}