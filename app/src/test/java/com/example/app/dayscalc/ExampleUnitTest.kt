package com.example.app.dayscalc

import com.example.app.dayscalc.Model.Model
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun calculate_working_days() {
        //Make sure to use the same date format "yyyy-MM-dd"
        val model = Model()
        val workingDays = model.CalculateDays("2014-08-07","2014-08-11")
        assertEquals(1, workingDays)

        val model2= Model()
        val workingDays2 = model2.CalculateDays("2014-08-13","2014-08-21")
        assertEquals(5, workingDays2)
    }
}
