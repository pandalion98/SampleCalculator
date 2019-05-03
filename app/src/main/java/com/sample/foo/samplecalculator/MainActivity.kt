package com.sample.foo.samplecalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import kotlinx.android.synthetic.main.activity_main.*

import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    private var currentAction: Char = ' '

    private var valueOne = java.lang.Double.NaN
    private var valueTwo: Double = 0.toDouble()

    private val decimalFormat: DecimalFormat = DecimalFormat("#.##########")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        buttonDot.setOnClickListener { editText.text = editText.text.toString() + "." }

        buttonZero.setOnClickListener { editText.text = editText.text.toString() + "0" }

        buttonOne.setOnClickListener { editText.text = editText.text.toString() + "1" }

        buttonTwo.setOnClickListener { editText.text = editText.text.toString() + "2" }

        buttonThree.setOnClickListener { editText.text = editText.text.toString() + "3" }

        buttonFour.setOnClickListener { editText.text = editText.text.toString() + "4" }

        buttonFive.setOnClickListener { editText.text = editText.text.toString() + "5" }

        buttonSix.setOnClickListener { editText.text = editText.text.toString() + "6" }

        buttonSeven.setOnClickListener { editText.text = editText.text.toString() + "7" }

        buttonEight.setOnClickListener { editText.text = editText.text.toString() + "8" }

        buttonNine.setOnClickListener { editText.text = editText.text.toString() + "9" }

        buttonAdd.setOnClickListener {
            computeCalculation()
            currentAction = ADDITION
            infoTextView.setText(decimalFormat.format(valueOne) + "+")
            editText.text = null
        }

        buttonSubtract.setOnClickListener {
            computeCalculation()
            currentAction = SUBTRACTION
            infoTextView.setText(decimalFormat.format(valueOne) + "-")
            editText.text = null
        }

        buttonMultiply.setOnClickListener {
            computeCalculation()
            currentAction = MULTIPLICATION
            infoTextView.setText(decimalFormat.format(valueOne) + "*")
            editText.text = null
        }

        buttonDivide.setOnClickListener {
            computeCalculation()
            currentAction = DIVISION
            infoTextView.setText(decimalFormat.format(valueOne) + "/")
            editText.text = null
        }

        buttonEqual.setOnClickListener {
            computeCalculation()
            infoTextView.setText(infoTextView.text.toString() +
                    decimalFormat.format(valueTwo) + " = " + decimalFormat.format(valueOne))
            valueOne = java.lang.Double.NaN
            currentAction = '0'
        }

        buttonClear.setOnClickListener {
            if (editText.text.length > 0) {
                val currentText = editText.text
                editText.text = currentText.subSequence(0, currentText.length - 1)
            } else {
                valueOne = java.lang.Double.NaN
                valueTwo = java.lang.Double.NaN
                editText.text = ""
                infoTextView.setText("")
            }
        }
    }

    private fun computeSequential() {

    }

    private fun computeCalculation() {
        if (!java.lang.Double.isNaN(valueOne)) {
            valueTwo = java.lang.Double.parseDouble(editText.text.toString())
            editText.text = null

            when (currentAction) {
                ADDITION -> valueOne += valueTwo
                SUBTRACTION -> valueOne -= valueTwo
                MULTIPLICATION -> valueOne *= valueTwo
                DIVISION -> valueOne /= valueTwo
            }
        } else {
            try {
                valueOne = java.lang.Double.parseDouble(editText.text.toString())
            } catch (e: Exception) {
            }

        }
    }

    companion object {
        private const val ADDITION = '+'
        private const val SUBTRACTION = '-'
        private const val MULTIPLICATION = '*'
        private const val DIVISION = '/'
    }
}
