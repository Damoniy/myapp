package com.damoniy.myapp.dao

import android.util.Log
import com.damoniy.myapp.model.Student

class StudentDAO: DAO<Student> {
    private val students = ArrayList<Student>()
    private var idCounter = 1

    init {
        this.save(Student("Agatha Harkness", "agatha@harkness.com", "+01 (00) 1111-2222"))
        this.save(Student("Wanda Maximoff", "wanda@maximoff.com", "+01 (00) 1111-2223"))
    }

    override fun save(t: Student) {
        t.id = idCounter
        students.add(t)
        this.updateId()
    }

    private fun updateId() {
        idCounter++
    }

    override fun edit(t: Student) {
        for(st in students) {
            if(st.id == t.id) {
                val pos = students.indexOf(st)
                students[pos] = t
            }
        }
    }

    override fun getObjectList(): List<Student>{
        println("called")
        return ArrayList(students)
    }

    fun remove(student: Student) {
        students.remove(student)
    }
}