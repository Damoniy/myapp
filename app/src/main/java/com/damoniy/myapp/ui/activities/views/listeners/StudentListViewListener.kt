package com.damoniy.myapp.ui.activities.views.listeners

import android.app.Activity
import android.content.Intent
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import com.damoniy.myapp.entity.Student
import com.damoniy.myapp.ui.activities.StudentFormActivity

class StudentListViewListener(private val activity: Activity): OnItemClickListener {
    override fun onItemClick(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val student = captureStudent(adapterView, position)
        openStudentEditor(student)
    }

    private fun captureStudent(adapterView: AdapterView<*>?, position: Int): Student {
        return adapterView!!.getItemAtPosition(position) as Student
    }

    private fun openStudentEditor(student: Student) {
        val intent = Intent(activity, StudentFormActivity::class.java)
        intent.putExtra("student", student)
        activity.startActivity(intent)
    }
}