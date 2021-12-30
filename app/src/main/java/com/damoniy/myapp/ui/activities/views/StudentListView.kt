package com.damoniy.myapp.ui.activities.views

import android.content.Context
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import com.damoniy.myapp.R
import com.damoniy.myapp.persistence.Persistence

class StudentListView(context: Context): View(context) {
    init {
        val students = Persistence.studentDAO.getObjectList()
        val studentsListView: ListView = findViewById(R.id.activity_student_list)
        studentsListView.adapter = ArrayAdapter(context, android.R.layout.simple_expandable_list_item_1, students)
    }
}