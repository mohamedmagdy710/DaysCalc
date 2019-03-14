package com.example.app.dayscalc.Model

import android.content.Context
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.Log
import junit.framework.Test
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.Month
import java.time.Period
import java.util.*
import java.util.logging.Logger

/**
 * Created by Mohamed on 3/13/19.
 */
class QueensBirthdayVacation : Vacations {
    var offdays = 0
    private var startCal : LocalDate
    private var endCal: LocalDate


    constructor(startCal: LocalDate, endCal: LocalDate) {
        this.startCal = startCal
        this.endCal = endCal
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun calculate(): Int {


        do {
            //excluding start date
            startCal = startCal.plus(Period.of( 0,0,1))

            if(startCal.month == Month.JUNE
                    &&  ((startCal.getDayOfMonth()-1) / 7 +1) == 2
                    && startCal.dayOfWeek == DayOfWeek.MONDAY){

                offdays++
            }

        }
        while (startCal.isBefore( endCal - Period.of(0,0,1)))//excluding end date

        return offdays



    }

}