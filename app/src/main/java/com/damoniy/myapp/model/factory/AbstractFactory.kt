package com.damoniy.myapp.model.factory

import android.content.Context

abstract class AbstractFactory<T>(context: Context) {
    abstract fun create(): T
}