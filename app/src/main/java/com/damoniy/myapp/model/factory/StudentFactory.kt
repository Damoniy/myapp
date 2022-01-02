package com.damoniy.myapp.model.factory

import android.app.Activity
import android.widget.TextView
import com.damoniy.myapp.R
import com.damoniy.myapp.model.Student

class StudentFactory(private val activity: Activity): AbstractFactory<Student>(activity) {
    override fun create(): Student {
        val name = activity.findViewById<TextView>(R.id.activity_student_form_name).text.toString()
        val email = activity.findViewById<TextView>(R.id.activity_student_form_email).text.toString()
        val tel = activity.findViewById<TextView>(R.id.activity_student_form_tel).text.toString()

        return Student(name, email, tel)
    }
}