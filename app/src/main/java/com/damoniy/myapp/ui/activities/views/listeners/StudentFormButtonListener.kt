package com.damoniy.myapp.ui.activities.views.listeners

import android.content.Context
import android.content.Intent
import android.view.View
import android.view.View.OnClickListener
import com.damoniy.myapp.ui.activities.StudentFormActivity

class StudentFormButtonListener(private val context: Context): OnClickListener {
    override fun onClick(p0: View?) {
        this.context.startActivity(Intent(context, StudentFormActivity::class.java))
    }
}