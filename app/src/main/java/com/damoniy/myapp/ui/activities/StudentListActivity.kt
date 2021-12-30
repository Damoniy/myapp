package com.damoniy.myapp.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.damoniy.myapp.R
import com.damoniy.myapp.ui.activities.views.StudentListFloatingActionButton
import com.damoniy.myapp.ui.activities.views.StudentListView

class StudentListActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.title = "Student's List"
        this.setContentView(R.layout.activity_student_list)
        StudentListFloatingActionButton(this)
    }

    override fun onResume() {
        super.onResume()
        StudentListView(this)
    }
}