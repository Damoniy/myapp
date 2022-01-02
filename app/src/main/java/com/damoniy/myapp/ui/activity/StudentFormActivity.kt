package com.damoniy.myapp.ui.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.damoniy.myapp.R
import com.damoniy.myapp.model.Student
import com.damoniy.myapp.model.factory.AbstractFactory
import com.damoniy.myapp.model.factory.StudentFactory
import com.damoniy.myapp.persistence.Persistence

class StudentFormActivity : AppCompatActivity() {
    private val keyExtra: String = "student"
    private val titleEditStudent: String = "Editar aluno"
    private val titleNewStudent: String = "Cadastrar novo aluno"
    private val studentFactory: AbstractFactory<Student> = StudentFactory(this)
    private val studentDAO = Persistence.studentDAO
    private var student: Student? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.activity_student_form)
        this.update()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        this.menuInflater.inflate(R.menu.activity_student_formulary_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.activity_student_formulary_menu_save -> finishFormulary()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun finishFormulary() {
        if (student == null) student = studentFactory.create()
        this.fillStudentFields()
        this.takeFinishProperAction()
        this.finish()
    }

    private fun takeFinishProperAction() {
        if (this.student!!.hasValidId()) {
            return studentDAO.edit(this.student!!)
        }
        return studentDAO.save(this.student!!)
    }

    private fun update() {
        if (intent.hasExtra(keyExtra)) {
            student = intent.getSerializableExtra(keyExtra) as Student
            fillViewFields()
            this.title = titleEditStudent
        } else {
            student = studentFactory.create()
            this.title = titleNewStudent
        }
    }

    private fun fillStudentFields() {
        val name = getViewTextById(R.id.activity_student_form_name)
        val email = getViewTextById(R.id.activity_student_form_email)
        val tel = getViewTextById(R.id.activity_student_form_tel)

        student!!.name = name
        student!!.email = email
        student!!.tel = tel
    }

    private fun getViewTextById(id: Int): String {
        return findViewById<TextView>(id).text.toString()
    }

    private fun fillViewFields() {
        val name: TextView = findViewById(R.id.activity_student_form_name)
        val email: TextView = findViewById((R.id.activity_student_form_email))
        val tel: TextView = findViewById((R.id.activity_student_form_tel))

        name.text = student!!.name
        email.text = student!!.email
        tel.text = student!!.tel
    }
}
