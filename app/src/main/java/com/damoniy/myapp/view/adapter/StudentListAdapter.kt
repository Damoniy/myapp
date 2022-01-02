package com.damoniy.myapp.view.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.damoniy.myapp.R
import com.damoniy.myapp.model.Student

class StudentListAdapter(private val activity: Activity) : BaseAdapter() {

    private val students: ArrayList<Student> = ArrayList()

    override fun getCount(): Int {
        return students.size
    }

    override fun getItem(position: Int): Student {
        return students[position]
    }

    override fun getItemId(position: Int): Long {
        return students[position].id.toLong()
    }

    fun update(list: List<Student>) {
        students.clear()
        students.addAll(list)
    }

    fun remove(student: Student) {
        students.remove(student)
        this.notifyDataSetChanged()
    }

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
        val newView: View = setupView(view, viewGroup)
        fillFields(newView, this.getItem(position))
        return newView
    }

    private fun fillFields(view: View, student: Student) {
        val name: TextView = view.findViewById(R.id.item_student_name)
        val email: TextView = view.findViewById(R.id.item_student_email)
        name.text = student.name
        email.text = student.email
    }

    private fun setupView(view: View?, viewGroup: ViewGroup?) =
        view ?: LayoutInflater.from(activity).inflate(R.layout.item_student, viewGroup, false)
}