package com.damoniy.myapp.ui

import android.app.Activity
import android.content.Context
import android.widget.TextView
import com.damoniy.myapp.R
import com.damoniy.myapp.model.Student
import com.damoniy.myapp.model.factory.AbstractFactory
import com.damoniy.myapp.model.factory.StudentFactory
import com.damoniy.myapp.persistence.Persistence

class FormularyView(private val context: Activity) {
    private val keyExtra: String = "student"
    private val titleEditStudent: String = "Editar aluno"
    private val titleNewStudent: String = "Cadastrar novo aluno"

    private val studentFactory: AbstractFactory<Student> = StudentFactory(context)
    private val studentDAO = Persistence.studentDAO
    private var student: Student? = null


    private fun fillViewFields() {
        val name: TextView = context.findViewById(R.id.activity_student_form_name)
        val email: TextView = context.findViewById((R.id.activity_student_form_email))
        val tel: TextView = context.findViewById((R.id.activity_student_form_tel))

        name.text = student!!.name
        email.text = student!!.email
        tel.text = student!!.tel
    }

    fun update() {
        if (context.intent.hasExtra(keyExtra)) {
            student = context.intent.getSerializableExtra(keyExtra) as Student
            fillViewFields()
            context.title = titleEditStudent
        } else {
            student = studentFactory.create()
            context.title = titleNewStudent
        }
    }

    fun finishFormulary() {
        if (student == null) student = studentFactory.create()
        this.fillStudentFields()
        this.takeFinishProperAction()
        context.finish()
    }

    private fun fillStudentFields() {
        val name = getViewTextById(R.id.activity_student_form_name)
        val email = getViewTextById(R.id.activity_student_form_email)
        val tel = getViewTextById(R.id.activity_student_form_tel)

        student!!.name = name
        student!!.email = email
        student!!.tel = tel
    }

    private fun takeFinishProperAction() {
        if (this.student!!.hasValidId()) {
            return studentDAO.edit(this.student!!)
        }
        return studentDAO.save(this.student!!)
    }

    private fun getViewTextById(id: Int): String {
        return context.findViewById<TextView>(id).text.toString()
    }
}