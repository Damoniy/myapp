package com.damoniy.myapp.ui.activities

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.damoniy.myapp.R
import com.damoniy.myapp.entity.Student
import com.damoniy.myapp.ui.activities.views.listeners.StudentListButtonListener

class StudentFormActivity : AppCompatActivity() {

    var student: Student? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.title = "New student"
        this.setContentView(R.layout.activity_student_form)
        this.update()
        this.createButton()
    }

    private fun createButton() {
        val button: Button = findViewById(R.id.activity_student_form_btn_send)
        button.setOnClickListener(StudentListButtonListener(this))
    }

    private fun update() {
        if(intent.hasExtra("student")) {
            student = intent.getSerializableExtra("student") as Student
            val name: TextView = findViewById(R.id.activity_student_form_name)
            name.text = student!!.name
        } else {
            student = Student()
        }
    }
}