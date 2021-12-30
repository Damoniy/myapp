package com.damoniy.myapp.factories

import android.app.Activity

interface AbstractFactory {
    fun create(activity: Activity)
}
