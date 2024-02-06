package com.cs501.a2q5calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import javax.xml.xpath.XPathExpression
import kotlin.properties.Delegates

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
    var firstFlag = true
    var pointFlag = true

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
            checkZero()
            expression.append("0")
        }

        b1.setOnClickListener {
            checkZero()
            expression.append("1")
        }

        b2.setOnClickListener {
            checkZero()
            expression.append("2")
        }

        b3.setOnClickListener {
            checkZero()
            expression.append("3")
        }

        b4.setOnClickListener {
            checkZero()
            expression.append("4")
        }

        b5.setOnClickListener {
            checkZero()
            expression.append("5")
        }

        b6.setOnClickListener {
            checkZero()
            expression.append("6")
        }

        b7.setOnClickListener {
            checkZero()
            expression.append("7")
        }

        b8.setOnClickListener {
            checkZero()
            expression.append("8")
        }

        b9.setOnClickListener {
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

            if(firstFlag){
                history = expression.text.toString().toDouble()
            }
            else{
                history = eval(history, expression.text.toString().toDouble(), operator)
            }
            operator = "*"
        }

        b_eql.setOnClickListener {
            expression.text.clear()
            expression.append(history.toString())
        }



    }

    fun checkZero(){
        if(expression.text.equals("0.0") || expression.text.toString().toDouble().equals(0.0)){
            expression.text.clear();
        }
    }

    fun eval(history: Double, number:Double, operator:String):Double{
        
    }
}