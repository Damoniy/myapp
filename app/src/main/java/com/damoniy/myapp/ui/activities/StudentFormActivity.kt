package com.damoniy.myapp.ui.activities

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.damoniy.myapp.R
import com.damoniy.myapp.entity.Student
import com.damoniy.myapp.ui.activities.views.listeners.StudentListButtonListener

class StudentFormActivity : AppCompatActivity() {

    private val keyExtra: String = "student"
    private val titleEditStudent: String = "Editar aluno"
    private val titleNewStudent: String = "Cadastrar novo aluno"

    var student: Student? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.activity_student_form)
        this.update()
        this.createButton()
    }

    private fun createButton() {
        val button: Button = findViewById(R.id.activity_student_form_btn_send)
        button.setOnClickListener(StudentListButtonListener(this))
    }

    private fun update() {
        if(intent.hasExtra(keyExtra)) {
            student = intent.getSerializableExtra(keyExtra) as Student
            fillFields()
            this.title = titleEditStudent
        } else {
            student = Student()
            this.title = titleNewStudent
        }
    }

    private fun fillFields() {
        val name: TextView = findViewById(R.id.activity_student_form_name)
        name.text = student!!.name
    }
}