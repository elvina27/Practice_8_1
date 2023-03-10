package com.example.practice_8_1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AllExamples = findViewById<TextView>(R.id.txtAllExamples)
        NumberRight = findViewById<TextView>(R.id.txtNumberRight)
        NumberFalse = findViewById<TextView>(R.id.txtNumberFalse)
        TimeMin = findViewById<TextView>(R.id.txtTimeMin)
        TimeMax = findViewById<TextView>(R.id.txtTimeMax)
        TimeAverage = findViewById<TextView>(R.id.txtTimeAverage)
        PrecentageCorrectAnswers = findViewById<TextView>(R.id.txtPrecentageCorrectAnswers)
        FirstOperand = findViewById<TextView>(R.id.txtFirstOperand)
        Ooperation = findViewById<TextView>(R.id.txtOperation)
        SecondOperand = findViewById<TextView>(R.id.txtSecondOperand)
        Result = findViewById<TextView>(R.id.txtResult)
        Right = findViewById<Button>(R.id.btnRight)
        False = findViewById<Button>(R.id.btnFalse)
        Start = findViewById<Button>(R.id.btnStart)
    }

    lateinit var AllExamples: TextView
    lateinit var NumberRight: TextView
    lateinit var NumberFalse: TextView
    lateinit var TimeMin: TextView
    lateinit var TimeMax: TextView
    lateinit var TimeAverage: TextView
    lateinit var PrecentageCorrectAnswers: TextView
    lateinit var FirstOperand: TextView
    lateinit var Ooperation: TextView
    lateinit var SecondOperand: TextView
    lateinit var Result: TextView
    lateinit var Right: Button
    lateinit var False: Button
    lateinit var Start: Button
    var FirstNumRand: Int = 0
    var SecondNumRand: Int = 0
    var ResultRand: Int = 0

    var i: Int = 0
    var j: Int = 0
    var SumTrueFalse: Int = 0


    fun btnStartClick(view: View) {
        Start.isEnabled =  false
        Right.isEnabled = true
        False.isEnabled = true

        var random = Random
        //первый операнд

        val FirstNumRand = random.nextInt(10, 100)
        FirstOperand.text = FirstNumRand.toString()

         //второй операнд
         val SecondNumRand = random.nextInt(10, 100)
         SecondOperand.text = SecondNumRand.toString()

    //операция
        val RandOperat = arrayOf("+", "-", "*", "/")
        val Rand = RandOperat.random()
        Ooperation.text = Rand
        when (Ooperation.text.toString()) {
            "+" -> FirstNumRand + SecondNumRand
            "-" -> FirstNumRand - SecondNumRand
            "*" -> FirstNumRand * SecondNumRand
            "/" -> FirstNumRand / SecondNumRand
        }

    //результат

     ResultRand = random.nextInt(1, 2)
    if (ResultRand == 1) {
        when (Ooperation.text.toString()) {
            "+" -> (FirstOperand.text.toString().toInt() + SecondOperand.text.toString()
                .toInt()) == Result.text.toString().toInt()
            "-" -> (FirstOperand.text.toString().toInt() - SecondOperand.text.toString()
                .toInt()) == Result.text.toString().toInt()
            "*" -> (FirstOperand.text.toString().toInt() * SecondOperand.text.toString()
                .toInt()) == Result.text.toString().toInt()
            "/" ->(FirstOperand.text.toString().toInt() / SecondOperand.text.toString()
                .toInt()) == Result.text.toString().toInt()
        }
    }
        else if (ResultRand == 2) {
            Result.setText("" + random.nextInt(10,200))
        }
    }


    fun btnRightClick(view: View) {

        if (ResultRand == 1) {
            if (Result.text.toString().toInt() == FirstNumRand + SecondNumRand && Ooperation.text == "+") {
                SumTrueFalse++
                i++
            } else if (Result.text.toString().toInt() == FirstNumRand - SecondNumRand && Ooperation.text == "-") {
                SumTrueFalse++
                i++
            } else if (Result.text.toString().toInt() == FirstNumRand * SecondNumRand && Ooperation.text == "*") {
                SumTrueFalse++
                i++
            } else if (Result.text.toString().toDouble() == (FirstNumRand.toDouble() / SecondNumRand.toDouble()) && Ooperation.text == "/") {
                SumTrueFalse++
                i++
            }
            else {
                j++
                SumTrueFalse++
            }
        }
          else {
              if (Result.text.toString().toInt() != FirstNumRand + SecondNumRand && Ooperation.text == "+") {
                  SumTrueFalse++
                  i++
                  } else if (Result.text.toString().toInt() != FirstNumRand - SecondNumRand && Ooperation.text == "-") {
                  SumTrueFalse++
                  i++
                  } else if (Result.text.toString().toInt() != FirstNumRand * SecondNumRand && Ooperation.text == "*") {
                  SumTrueFalse++
                  i++
                 } else if (Result.text.toString().toInt() != FirstNumRand * SecondNumRand && Ooperation.text == "/") {
                  SumTrueFalse++
                  i++
                 }
              else {
                  j++
                  SumTrueFalse++
              }
          }
    }

    fun Сount(){
        SumTrueFalse = i + j //SumTrueFalse - хранит сумму кол-ва правильных (i) и неправильных (j) ответов
        AllExamples.text = SumTrueFalse.toString() //устанавливаем значение Decided в TextView, переведя его в строку методом toString
    }
}
