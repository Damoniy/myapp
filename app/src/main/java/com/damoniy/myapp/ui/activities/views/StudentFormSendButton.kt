package com.damoniy.myapp.ui.activities.views

import android.content.Context
import android.view.View
import android.widget.Button
import com.damoniy.myapp.R
import com.damoniy.myapp.ui.activities.views.listeners.StudentListButtonListener

class StudentFormSendButton(context: Context) : View(context) {

    init {
        val btn: Button = findViewById(R.id.activity_student_form_btn_send)
        btn.setOnClickListener(StudentListButtonListener(context))
    }
}