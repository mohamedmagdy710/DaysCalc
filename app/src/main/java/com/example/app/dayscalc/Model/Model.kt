package com.example.app.dayscalc.Model

import android.content.Context
import android.os.AsyncTask
import android.os.Build
import android.support.annotation.RequiresApi
import java.time.LocalDate


class Model {

    var calculateWD :CalculateWorkingDays = CalculateWorkingDays()
    var calculateVD : CalculateVacationDays = CalculateVacationDays()


    @RequiresApi(Build.VERSION_CODES.O)
    fun CalculateDays (start : String, end: String): Long {

        val dateObj1 : LocalDate = LocalDate.parse(start)
        val dateObj2 : LocalDate = LocalDate.parse(end)

        val work :Int = calculateWD.calculate(dateObj1,dateObj2)
        val vacation :Int = calculateVD.calculate(dateObj1,dateObj2)
        val finalDays : Int = work - vacation

      return finalDays.toLong()

    }



}



