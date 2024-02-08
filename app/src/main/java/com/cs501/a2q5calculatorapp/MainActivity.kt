package com.cs501.a2q5calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import kotlin.math.roundToInt
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    //init view component
    lateinit var appname : TextView
    lateinit var expression: EditText
    lateinit var b1 : Button
    lateinit var b2 : Button
    lateinit var b3 : Button
    lateinit var b4 : Button
    lateinit var b5 : Button
    lateinit var b6 : Button
    lateinit var b7 : Button
    lateinit var b8 : Button
    lateinit var b9 : Button
    lateinit var b0 : Button
    lateinit var b_point : Button
    lateinit var b_eql : Button
    lateinit var b_sqrt : Button
    lateinit var b_plus : Button
    lateinit var b_mul : Button
    lateinit var b_div : Button
    lateinit var b_min : Button

    var history = 0.0
    var operator = ""
    var number = 0.0
    var firstFlag = true
    var pointFlag = true
    var afterAnswer = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        appname = findViewById(R.id.textView2)
        expression = findViewById(R.id.editText_expression)
        b0 = findViewById(R.id.button0)
        b1 = findViewById(R.id.button1)
        b2 = findViewById(R.id.button2)
        b3= findViewById(R.id.button3)
        b4 = findViewById(R.id.button4)
        b5 = findViewById(R.id.button5)
        b6 = findViewById(R.id.button6)
        b7 = findViewById(R.id.button7)
        b8 = findViewById(R.id.button8)
        b9 = findViewById(R.id.button9)
        b_point = findViewById(R.id.button_point)
        b_eql = findViewById(R.id.button_eql)
        b_mul = findViewById(R.id.button_mul)
        b_sqrt = findViewById(R.id.button_sqrt)
        b_plus = findViewById(R.id.button_add)
        b_div = findViewById(R.id.button_dvi)
        b_min = findViewById(R.id.button_min)

        b0.setOnClickListener {
            if(afterAnswer){
                expression.text.clear()
                afterAnswer = false
            }
            checkZero()
            expression.append("0")
        }

        b1.setOnClickListener {
            if(afterAnswer){
                expression.text.clear()
                afterAnswer = false

            }
            checkZero()
            expression.append("1")
        }

        b2.setOnClickListener {
            if(afterAnswer){
                expression.text.clear()
                afterAnswer = false

            }
            checkZero()
            expression.append("2")
        }

        b3.setOnClickListener {
            if(afterAnswer){
                expression.text.clear()
                afterAnswer = false

            }
            checkZero()
            expression.append("3")
        }

        b4.setOnClickListener {
            if(afterAnswer){
                expression.text.clear()
                afterAnswer = false

            }
            checkZero()
            expression.append("4")
        }

        b5.setOnClickListener {
            if(afterAnswer){
                expression.text.clear()
                afterAnswer = false

            }
            checkZero()
            expression.append("5")
        }

        b6.setOnClickListener {
            if(afterAnswer){
                expression.text.clear()
                afterAnswer = false
            }
            checkZero()
            expression.append("6")
        }

        b7.setOnClickListener {
            if(afterAnswer){
                expression.text.clear()
                afterAnswer = false
            }
            checkZero()
            expression.append("7")
        }

        b8.setOnClickListener {
            if(afterAnswer){
                expression.text.clear()
                afterAnswer = false
            }
            checkZero()
            expression.append("8")
        }

        b9.setOnClickListener {
            if(afterAnswer){
                expression.text.clear()
                afterAnswer = false
            }
            checkZero()
            expression.append("9")
        }

        b_point.setOnClickListener {
            if(pointFlag){
                checkZero()
                expression.append(".")
                pointFlag = false;
            }
            else{
                pointFlag = true
                expression.text.clear()
                Snackbar.make(it, "Cannot have 2 digit point!",Snackbar.LENGTH_LONG)
            }
        }

        b_mul.setOnClickListener {

            if(!chechOper()){
                Snackbar.make(it, "Only support simple operation!Pls start over again", Snackbar.LENGTH_LONG)
                expression.text.clear()
                history = 0.0
                number = 0.0
                operator = ""
                afterAnswer = true
                expression.text.clear()
                return@setOnClickListener
            }
            try {

                history = expression.text.toString().toDouble()
            }
            catch (e:Exception){
                Snackbar.make(it,"Does not read in last number", Snackbar.LENGTH_LONG).show()
                history = 0.0
                number = 0.0
                operator = ""
                afterAnswer = true
                expression.text.clear()
                return@setOnClickListener

            }
            operator = "*"
            expression.text.clear()

        }

        b_plus.setOnClickListener {
            if(!chechOper()){
                Snackbar.make(it, "Only support simple operation!Pls start over again", Snackbar.LENGTH_LONG).show()
                expression.text.clear()
                history = 0.0
                number = 0.0
                operator = ""
                afterAnswer = true
                expression.text.clear()
                return@setOnClickListener
            }
            try {

                history = expression.text.toString().toDouble()
            }
            catch (e:Exception){
                Snackbar.make(it,"Does not read in last number", Snackbar.LENGTH_LONG).show()
                history = 0.0
                number = 0.0
                operator = ""
                afterAnswer = true
                expression.text.clear()
                return@setOnClickListener

            }
            operator = "+"
            expression.text.clear()

        }

        b_min.setOnClickListener {
            if(!chechOper()){
                Snackbar.make(it, "Only support simple operation!Pls start over again", Snackbar.LENGTH_LONG).show()
                expression.text.clear()
                history = 0.0
                number = 0.0
                operator = ""
                afterAnswer = true
                expression.text.clear()
                return@setOnClickListener
            }
            try {

                history = expression.text.toString().toDouble()
            }
            catch (e:Exception){
                Snackbar.make(it,"Does not read in last number", Snackbar.LENGTH_LONG).show()
                history = 0.0
                number = 0.0
                operator = ""
                afterAnswer = true
                expression.text.clear()
                return@setOnClickListener

            }
            operator = "-"
            expression.text.clear()

        }

        b_div.setOnClickListener {
            if(!chechOper()){
                Snackbar.make(it, "Only support simple operation!Pls start over again", Snackbar.LENGTH_LONG).show()
                expression.text.clear()
                history = 0.0
                number = 0.0
                operator = ""
                afterAnswer = true
                expression.text.clear()
                return@setOnClickListener
            }
            try {

                history = expression.text.toString().toDouble()
            }
            catch (e:Exception){
                Snackbar.make(it,"Does not read in last number", Snackbar.LENGTH_LONG).show()
                history = 0.0
                number = 0.0
                operator = ""
                afterAnswer = true
                expression.text.clear()
                return@setOnClickListener

            }
            operator = "/"
            expression.text.clear()
        }

        b_sqrt.setOnClickListener {
            Snackbar.make(it, "Type number you want to operate after press sqrt", Snackbar.LENGTH_LONG).show()
            if(!chechOper()){
                Snackbar.make(it, "Only support simple operation! Pls start over again", Snackbar.LENGTH_LONG).show()
                expression.text.clear()
                history = 0.0
                number = 0.0
                operator = ""
                afterAnswer = true
                expression.text.clear()
                return@setOnClickListener
            }
            operator = "sqrt"
        }

        b_eql.setOnClickListener {
            number = expression.text.toString().toDouble()
            expression.text.clear()
            if(number.equals(0.0) && operator == "/"){
                Snackbar.make(it, "Cannot divide by Zero!", Snackbar.LENGTH_LONG)
                return@setOnClickListener
            }
            history = eval(history, number, operator);
            history = (history * 100.0).roundToInt() / 100.0
            Log.d("TAG", "Answer his: $history")
            var sign = ""
            if (history < 0){
                sign = "-"
            }
            expression.append(sign+history.toString())
            history = 0.0
            number = 0.0
            operator = ""
            afterAnswer = true
        }



    }

    private fun chechOper(): Boolean {
        if(operator == ""){
            return true
        }
        return false
    }

    fun checkZero(){
        if(expression.text.toString() == "" || expression.text.toString().toDouble().equals(0.0)){
            expression.text.clear();
        }
    }

    private fun eval(history: Double, number: Double, operator: String): Double {

        var res = when (operator) {
            "+" -> history + number
            "sqrt" -> sqrt(number)
            "-" -> history - number
            "*" -> history * number
            "/" -> history / number
            "" -> history
            else -> 0.0
        }
        Log.d("TAG", "Answer : $res")
        return res
    }
}