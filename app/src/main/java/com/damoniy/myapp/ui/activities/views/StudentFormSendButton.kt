package com.damoniy.myapp.ui.activities.views

import android.app.Activity
import android.widget.Button
import com.damoniy.myapp.R
import com.damoniy.myapp.ui.activities.views.listeners.StudentListButtonListener

class StudentFormSendButton(activity: Activity) {

    init {
        val button: Button = activity.findViewById(R.id.activity_student_form_btn_send)
        button.setOnClickListener(StudentListButtonListener(activity))
    }
}