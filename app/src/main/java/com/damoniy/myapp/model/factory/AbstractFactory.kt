package com.damoniy.myapp.model.factory

interface AbstractFactory<T> {
    fun create(activity: T)
}