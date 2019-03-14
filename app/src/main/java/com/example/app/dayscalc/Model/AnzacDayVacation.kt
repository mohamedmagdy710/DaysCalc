package com.example.app.dayscalc.Model
import android.os.Build
import android.support.annotation.RequiresApi
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.Month
import java.time.Period

class AnzacDayVacation : Vacations {
    var offdays = 0

   private var anzstartCal : LocalDate
    private var anzendCal: LocalDate


    constructor(startCalanz: LocalDate, endCalanz: LocalDate) {
        this.anzstartCal = startCalanz
        this.anzendCal = endCalanz


    }


    @RequiresApi(Build.VERSION_CODES.O)
   override fun calculate(): Int {



        do  {

            //excluding start date
            anzstartCal = anzstartCal.plus(Period.of( 0,0,1))


            if(anzstartCal.month == Month.APRIL
                    && anzstartCal.dayOfMonth == 25
                    && anzstartCal.dayOfWeek != DayOfWeek.SATURDAY
                    && anzstartCal.dayOfWeek != DayOfWeek.SUNDAY)
            {
                offdays++
            }

        }
        while (anzstartCal.isBefore( anzendCal - Period.of(0,0,1)))//excluding end date

        return offdays

         }


}