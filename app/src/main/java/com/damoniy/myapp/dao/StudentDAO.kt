package com.damoniy.myapp.dao

import com.damoniy.myapp.entity.Student

class StudentDAO: DAO<Student> {
    private val students = ArrayList<Student>()

    override fun save(t: Student) {
        students.add(t)
    }

    override fun getObjectList(): List<Student>{
        return ArrayList(students)
    }
}