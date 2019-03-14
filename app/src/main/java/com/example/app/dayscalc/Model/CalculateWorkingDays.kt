package com.example.app.dayscalc.Model
import android.os.Build
import android.support.annotation.RequiresApi
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.Period

class CalculateWorkingDays  {


    lateinit var startCal :LocalDate
    lateinit var endCal : LocalDate

    var workDays = 0

    @RequiresApi(Build.VERSION_CODES.O)
    fun calculate(start : LocalDate, end :LocalDate) : Int{

         startCal = start
         endCal= end


        //Return 0 if start and end are the same
        if (startCal.equals( endCal)) {
            return 0
        }



        do  {
            //excluding start date
            startCal = startCal.plus(Period.of( 0,0,1))


            if (startCal.dayOfWeek !== DayOfWeek.SATURDAY && startCal.dayOfWeek !== DayOfWeek.SUNDAY) {
                workDays++
            }

        }
        while (startCal.isBefore( endCal - Period.of(0,0,1)))//excluding end date

        return workDays

    }



}