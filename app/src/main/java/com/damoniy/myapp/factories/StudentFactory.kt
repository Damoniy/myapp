package com.damoniy.myapp.factories

import android.app.Activity
import android.widget.TextView
import com.damoniy.myapp.R
import com.damoniy.myapp.entity.Student
import com.damoniy.myapp.persistence.Persistence

class StudentFactory: AbstractFactory {
    override fun create(activity: Activity) {
        val studentDAO = Persistence.studentDAO
        val name = activity.findViewById<TextView>(R.id.activity_student_form_name).text.toString()
        val email = activity.findViewById<TextView>(R.id.activity_student_form_email).text.toString()
        val tel = activity.findViewById<TextView>(R.id.activity_student_form_tel).text.toString()
        val student = Student(email, name, tel)
        studentDAO.save(student)
    }
}