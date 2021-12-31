package com.damoniy.myapp.ui.activities.views.listeners

import android.view.View
import android.view.View.OnClickListener
import com.damoniy.myapp.factories.AbstractFactory
import com.damoniy.myapp.factories.StudentFactory
import com.damoniy.myapp.persistence.Persistence
import com.damoniy.myapp.ui.activities.StudentFormActivity

class StudentListButtonListener(private val activity: StudentFormActivity): OnClickListener {
    private val factory: AbstractFactory<StudentFormActivity> = StudentFactory()

    override fun onClick(p0: View?) {
        val studentDAO = Persistence.studentDAO
        factory.create(activity)

        if(activity.student!!.hasValidId()) {
            studentDAO.edit(activity.student!!)
        } else {
            studentDAO.save(activity.student!!)
        }

        activity.finish()
    }
}