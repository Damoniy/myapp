package com.damoniy.myapp.dao

import com.damoniy.myapp.entity.Student

class StudentDAO: DAO<Student> {
    private val students = ArrayList<Student>()
    private var idCounter = 1

    init {
        this.save(Student("p", "La", "222"))
        this.save(Student("p", "La", "222"))
    }

    override fun save(t: Student) {
        t.id = idCounter
        students.add(t)
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
        return ArrayList(students)
    }
}