package com.damoniy.myapp.ui.activities.views.listeners

import android.app.Activity
import android.content.Intent
import android.view.View
import android.view.View.OnClickListener
import com.damoniy.myapp.model.Student
import com.damoniy.myapp.ui.activities.StudentFormActivity

class StudentFormularyButtonListener(private val activity: Activity): OnClickListener {
    override fun onClick(p0: View?) {
        val intent = Intent(activity, StudentFormActivity::class.java)
        intent.putExtra("student", Student("", "", ""))
        this.activity.startActivity(intent)
    }
}