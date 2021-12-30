package com.damoniy.myapp.entity

import java.io.Serializable

class Student(var email: String, var name: String, var tel: String): Serializable {

    var id: Int = 0

    constructor() : this("", "", "")

    override fun toString(): String {
        return name
    }

    fun hasValidId() : Boolean {
        return id > 0
    }
}