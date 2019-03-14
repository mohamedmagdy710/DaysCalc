package com.example.app.dayscalc.Model

import android.app.DatePickerDialog
import android.content.Context
import android.content.res.Resources
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.app.dayscalc.View.MainActivity
import java.util.*

/**
 * Created by Mohamed on 3/12/19.
 */
class DateModel {

    var date: String =""
    val c = Calendar.getInstance()
    var day = c.get(Calendar.DAY_OF_MONTH)
    var month = c.get(Calendar.MONTH)
    var year = c.get(Calendar.YEAR)


    fun ChooseDate (context: Context, textview: TextView) {

        val dpd = DatePickerDialog(context ,DatePickerDialog.OnDateSetListener { view: DatePicker, Myear, Mmonth, dayOfMonth ->

            date = "" + Myear + "-" + String.format("%02d", Mmonth + 1) + "-" + String.format("%02d", dayOfMonth)
            textview.setText(date)
          /////////////////////  editText.clearFocus()


        }, year, month, day)

        dpd.show()


    }
}