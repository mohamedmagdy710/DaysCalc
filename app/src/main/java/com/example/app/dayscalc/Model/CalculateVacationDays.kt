package com.example.app.dayscalc.Model

import android.os.Build
import android.support.annotation.RequiresApi
import java.time.LocalDate

class CalculateVacationDays {

    var vacationDayes = 0

    @RequiresApi(Build.VERSION_CODES.O)
    fun calculate(startCal: LocalDate, endCal: LocalDate) : Int {


        var boxingVacatuion : BoxingVacation = BoxingVacation(startCal, endCal)
        var anzVacation : AnzacDayVacation = AnzacDayVacation(startCal, endCal)
        var australiaVacation : AustraliaDayVacation = AustraliaDayVacation(startCal, endCal)
        var christmasVacation : ChristmasVacation = ChristmasVacation(startCal, endCal)
        var newYearVacation : NewYearVacation = NewYearVacation(startCal, endCal)
        var easterVacation : Easter = Easter(startCal, endCal)
        var laborVacation : LaborDayVacation = LaborDayVacation(startCal, endCal)
        var queenBDVacation : QueensBirthdayVacation = QueensBirthdayVacation(startCal, endCal)


        var boxdays : Int = boxingVacatuion.calculate()
        var anzdays: Int = anzVacation.calculate()
        var ausdays : Int = australiaVacation.calculate()
        var chrisdays : Int = christmasVacation.calculate()
        var newyeardays : Int = newYearVacation.calculate()
        var easterdays : Int = easterVacation.calculate()
        var labordays : Int = laborVacation.calculate()
        var queendays : Int = queenBDVacation.calculate()


            vacationDayes = anzdays + ausdays + boxdays + chrisdays + labordays + newyeardays + queendays + easterdays


        return vacationDayes

    }



}