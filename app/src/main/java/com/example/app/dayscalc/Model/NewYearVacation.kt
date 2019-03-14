package com.example.app.dayscalc.Model

import android.os.Build
import android.support.annotation.RequiresApi
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.Month
import java.time.Period

class NewYearVacation : Vacations {
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

            if (startCal.month == Month.JANUARY
                    &&  startCal.dayOfMonth == 1) {
                if (startCal.dayOfWeek != DayOfWeek.SATURDAY
                        && startCal.dayOfWeek != DayOfWeek.SUNDAY) {
                    offdays++
                } else if (endCal.dayOfWeek > DayOfWeek.MONDAY) {
                    offdays++

                }
            }

        }
        while (startCal.isBefore( endCal - Period.of(0,0,1)))//excluding end date

        return offdays
    }

}

