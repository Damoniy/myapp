package com.damoniy.myapp.ui.activities.views

import android.app.Activity
import com.damoniy.myapp.R
import com.damoniy.myapp.ui.activities.views.listeners.StudentFormButtonListener
import com.google.android.material.floatingactionbutton.FloatingActionButton

class StudentListFloatingActionButton(activity: Activity) {

    init {
        val button: FloatingActionButton = activity.findViewById(R.id.activity_student_list_add_btn)
        button.setOnClickListener(StudentFormButtonListener(activity))
    }
}