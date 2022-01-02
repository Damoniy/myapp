package com.damoniy.myapp.ui.listener

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import com.damoniy.myapp.ui.activity.StudentFormActivity

class StudentFormularyButtonListener(private val activity: Context): View.OnClickListener {
    override fun onClick(p0: View?) {
        val intent = Intent(activity, StudentFormActivity::class.java)
        this.activity.startActivity(intent)
    }
}