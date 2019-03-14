package com.example.app.dayscalc.Model

import android.os.Build
import android.support.annotation.RequiresApi
import java.time.LocalDate
import java.time.Period



class Easter : Vacations{

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

            var easter = CalculateEaster(startCal.year)


            if(startCal.equals(easter.minusDays(2)) && endCal.isAfter(easter))
            {
                offdays++
            }
            if(startCal.equals(easter.plusDays(1)) && endCal.isAfter(easter.plusDays(1)))
            {
                offdays++
            }

        }
        while (startCal.isBefore( endCal - Period.of(0,0,1)))//excluding end date


        return offdays
    }


    lateinit var easterdate : LocalDate

    @RequiresApi(Build.VERSION_CODES.O)
    fun CalculateEaster(year : Int): LocalDate {

    var x = year
    var A: Int = x % 19
    var B: Int = x / 100
    var C: Int = x % 100
    var D: Int = B / 4
    var E: Int = B % 4
    var G: Int = ((8 * B) + 13) / 25
    var H: Int = ((19 * A) + B - D - G + 15) % 30
    var M = (A + 11 * H) / 319
    var J = C / 4
    var K = C % 4
    var L = (2 * E + 2 * J - K - H + M + 32) % 7
    var N = (H - M + L + 90) / 25
    var P = (H - M + L + N + 19) % 32


        var day = P
        var month = N
        var date : String = "" + year + "-" + String.format("%02d", month) + "-" + String.format("%02d", day)
        easterdate = LocalDate.parse(date)
        return easterdate

}




}