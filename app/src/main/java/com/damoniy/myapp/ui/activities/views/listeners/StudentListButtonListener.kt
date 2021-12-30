package com.damoniy.myapp.ui.activities.views.listeners

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import android.view.View.OnClickListener
import com.damoniy.myapp.factories.AbstractFactory
import com.damoniy.myapp.factories.StudentFactory
import com.damoniy.myapp.ui.activities.StudentListActivity

class StudentListButtonListener(private val activity: Activity): OnClickListener {
    private val factory: AbstractFactory = StudentFactory()

    override fun onClick(p0: View?) {
        factory.create(activity)
        activity.finish()
    }
}