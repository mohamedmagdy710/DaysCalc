package com.example.app.dayscalc.View

import android.os.AsyncTask
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.view.View
import android.widget.Toast
import com.example.app.dayscalc.Model.DateModel
import com.example.app.dayscalc.Model.Model
import com.example.app.dayscalc.R
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDate


class MainActivity : AppCompatActivity() {


    lateinit var model : Model
    lateinit var dateModel: DateModel


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        textviewstart.setOnClickListener {
            dateModel=DateModel()
            dateModel.ChooseDate(this,textviewstart)


        }

        textviewend.setOnClickListener {
            dateModel=DateModel()
            dateModel.ChooseDate(this,textviewend)

        }



        button.setOnClickListener(View.OnClickListener {


            var date1 = textviewstart.text
            var date2 = textviewend.text

            if (textviewstart.text.equals("Choose Start Date") || textviewend.text.equals("Choose end Date")) {
                Toast.makeText(this, "Please Choose Start & End Date", Toast.LENGTH_SHORT).show()

            } else if (LocalDate.parse(date1).isAfter(LocalDate.parse(date2))){

                 Toast.makeText(this,"Start Date is After End Date" , Toast.LENGTH_SHORT).show()
                textView.setText("")


            }else {

                model = Model()
                val date_start = date1.toString()
                val date_end = date2.toString()
                val diffrence: String = "Total Working Days Between The Two Dates : " + model.CalculateDays(date_start, date_end)
                textView.setText(diffrence)
            }

            })







    }
}
