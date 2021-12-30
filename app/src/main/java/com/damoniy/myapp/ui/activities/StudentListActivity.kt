package com.damoniy.myapp.ui.activities

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.damoniy.myapp.R
import com.damoniy.myapp.persistence.Persistence
import com.damoniy.myapp.ui.activities.views.listeners.StudentFormularyButtonListener
import com.damoniy.myapp.ui.activities.views.listeners.StudentListViewListener
import com.google.android.material.floatingactionbutton.FloatingActionButton

class StudentListActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.title = "Student's List"
        this.setContentView(R.layout.activity_student_list)
        this.createButton()
    }

    override fun onResume() {
        super.onResume()
        this.configureListView()
    }


    private fun createButton() {
        val button: FloatingActionButton = findViewById(R.id.activity_student_list_add_btn)
        button.setOnClickListener(StudentFormularyButtonListener(this))
    }

    private fun configureListView() {
        val students = Persistence.studentDAO.getObjectList()
        val studentsListView: ListView = findViewById(R.id.activity_student_list)
        studentsListView.adapter = ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, students)
        studentsListView.onItemClickListener = StudentListViewListener(this)
    }
}