package com.damoniy.myapp.entity

class Student(val email: String, val name: String, val tel: String) {
    override fun toString(): String {
        return name
    }
}