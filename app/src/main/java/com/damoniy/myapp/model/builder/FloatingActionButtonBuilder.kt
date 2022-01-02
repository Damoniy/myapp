package com.damoniy.myapp.model.builder

import android.app.Activity
import com.google.android.material.floatingactionbutton.FloatingActionButton

object FloatingActionButtonBuilder {
    class Builder(activity: Activity, id: Int) : FloatingActionButton(activity) {
        val instance: FloatingActionButton = activity.findViewById(id)
    }
}