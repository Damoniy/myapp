package com.damoniy.myapp.ui.activities.views

import android.content.Context
import android.view.View
import com.damoniy.myapp.R
import com.damoniy.myapp.ui.activities.views.listeners.StudentListButtonListener
import com.google.android.material.floatingactionbutton.FloatingActionButton

class StudentListFloatingActionButton(context: Context): View(context) {
    init {
        val addBtn: FloatingActionButton = findViewById(R.id.activity_student_list_add_btn)
        addBtn.setOnClickListener(StudentListButtonListener(context))
    }
}