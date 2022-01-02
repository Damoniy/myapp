@file:Suppress("unused")

package com.damoniy.myapp

import android.app.Application

class StudentListApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        println("Hello world from application")
    }
}