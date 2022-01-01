package com.damoniy.myapp.model

import java.io.Serializable

class Student(var name: String, var email:String, var tel: String): Serializable {

    var id: Int = 0

    constructor() : this("", "", "")

    override fun toString(): String {
        return name
    }

    fun hasValidId() : Boolean {
        return id > 0
    }
}