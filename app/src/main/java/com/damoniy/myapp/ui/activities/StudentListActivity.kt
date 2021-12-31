package com.damoniy.myapp.ui.activities

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.damoniy.myapp.R
import com.damoniy.myapp.entity.Student
import com.damoniy.myapp.persistence.Persistence
import com.damoniy.myapp.ui.activities.views.listeners.StudentFormularyButtonListener
import com.damoniy.myapp.ui.activities.views.listeners.StudentListViewListener
import com.google.android.material.floatingactionbutton.FloatingActionButton

class StudentListActivity: AppCompatActivity() {

    private lateinit var arrayAdapter: ArrayAdapter<Student>

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
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, students)
        studentsListView.adapter = arrayAdapter
        studentsListView.onItemClickListener = StudentListViewListener(this)
        studentsListView.setOnItemLongClickListener { adapterView, view, i, l -> this.onItemLongClick(adapterView, view, i, l) }
    }

    private fun onItemLongClick(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long): Boolean {
        val student = captureStudent(adapterView, position)
        Persistence.studentDAO.remove(student)
        this.arrayAdapter.remove(student)
        return true
    }

    private fun captureStudent(adapterView: AdapterView<*>?, position: Int): Student {
        return adapterView!!.getItemAtPosition(position) as Student
    }
}