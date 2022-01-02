package com.damoniy.myapp.model.factory

import android.widget.TextView
import com.damoniy.myapp.R
import com.damoniy.myapp.view.activity.StudentFormActivity

class StudentFactory: AbstractFactory<StudentFormActivity> {
    override fun create(activity: StudentFormActivity) {
        val student = activity.student
        val name = activity.findViewById<TextView>(R.id.activity_student_form_name).text.toString()
        val email = activity.findViewById<TextView>(R.id.activity_student_form_email).text.toString()
        val tel = activity.findViewById<TextView>(R.id.activity_student_form_tel).text.toString()

        if (student != null) {
            student.name = name
            student.email = email
            student.tel = tel
        }
    }
}