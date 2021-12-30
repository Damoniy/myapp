package com.damoniy.myapp.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.damoniy.myapp.R
import com.damoniy.myapp.ui.activities.views.StudentFormSendButton

class StudentFormActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.activity_student_form)
        StudentFormSendButton(this)
    }
}