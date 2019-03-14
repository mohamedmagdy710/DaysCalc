package com.example.app.dayscalc.Model

import android.os.Build
import android.support.annotation.RequiresApi
import junit.framework.Test
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.Month
import java.time.Period
import java.util.logging.Logger


class ChristmasVacation : Vacations {

    var offdays = 0
    private var boxstartCal : LocalDate
    private var boxendCal: LocalDate


    constructor(startCalbox: LocalDate, endCalbox: LocalDate) {
        this.boxstartCal = startCalbox
        this.boxendCal = endCalbox

    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun calculate(): Int {

        do {


            //excluding start date
            boxstartCal = boxstartCal.plus(Period.of( 0,0,1))

            Logger.getLogger(Test::class.java.name).warning(boxstartCal.toString())

            if(boxstartCal.month == Month.DECEMBER
                    && boxstartCal.dayOfMonth == 25 ){
                if  ( boxstartCal.dayOfWeek != DayOfWeek.SATURDAY
                        && boxstartCal.dayOfWeek != DayOfWeek.SUNDAY) {
                    offdays++
                } else if (boxstartCal.dayOfWeek == DayOfWeek.SATURDAY
                        && (boxendCal.dayOfWeek > DayOfWeek.MONDAY )){
                    offdays++

                }else if (boxstartCal.dayOfWeek == DayOfWeek.SUNDAY
                        && boxendCal.dayOfWeek> DayOfWeek.TUESDAY) {
                    offdays++

                }

            }

        }
        while (boxstartCal.isBefore( boxendCal - Period.of(0,0,1)))//excluding end date


        return offdays
    }
}

