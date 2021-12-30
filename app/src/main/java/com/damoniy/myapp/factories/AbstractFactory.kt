package com.damoniy.myapp.factories

interface AbstractFactory<T> {
    fun create(activity: T)
}
