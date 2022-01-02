package com.damoniy.myapp.view.listener

import android.app.Activity
import android.content.Intent
import android.view.View
import com.damoniy.myapp.model.Student
import com.damoniy.myapp.view.activity.StudentFormActivity

class StudentFormularyButtonListener(private val activity: Activity): View.OnClickListener {
    override fun onClick(p0: View?) {
        val intent = Intent(activity, StudentFormActivity::class.java)
        intent.putExtra("student", Student("", "", ""))
        this.activity.startActivity(intent)
    }
}