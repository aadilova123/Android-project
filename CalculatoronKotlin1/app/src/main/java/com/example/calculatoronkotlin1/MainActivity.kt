package com.example.calculatoronkotlin1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var input: TextView
    private lateinit var signbox: TextView

    internal var value1: String? = null
    internal var value2: String? = null
    internal var sign: String? = null

    internal var operation: String? = null
    internal var num1: Double? = null
    internal var num2: Double? = null
    internal var result: Double? = null
    internal lateinit var del: Button


    internal var hasPoint: Boolean = false
    internal var checkNumb = true
    internal var checkOper = false
    internal var equalCliked = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        input = calcText
        signbox = signBox
        del = btn_del
        del.isLongClickable = true

        if (savedInstanceState != null) {
            value1 = savedInstanceState.getString("number1")
            value2 = savedInstanceState.getString("number2")
            checkNumb = savedInstanceState.getBoolean("checkNumber")
            hasPoint = savedInstanceState.getBoolean("hasPoint")
            equalCliked = savedInstanceState.getBoolean("equalClicked")
            input.text = savedInstanceState.getString("numberInput")
            checkOper = savedInstanceState.getBoolean("checkOperation")
            signbox.text = savedInstanceState.getString("signInput")
            sign = savedInstanceState.getString("sign")
            operation = savedInstanceState.getString("operation")
        }

        del.setOnLongClickListener {
            input.text = null
            signbox.text = null
            value1 = null
            value2 = null
            sign = null
            hasPoint = false
            equalCliked = false
            checkOper = false
            true
        }

    }

    fun btn0(view: View) {
        if (equalCliked) {
            input.text = null
            if (checkNumb)
                input.text = input.text.toString() + "0"
            equalCliked = false

        } else if (checkNumb) {
            if (input.text == "0") {
                input.text = "0"
            } else
                input.text = input.text.toString() + "0"
        }
    }

    fun btn1(view: View) {
        if (equalCliked) {
            input.text = null
            if (checkNumb)
                input.text = input.text.toString() + "1"
            equalCliked = false

        } else if (checkNumb) {
            if (input.text == "0")
                input.text = "0"
            else
                input.text = input.text.toString() + "1"
        }

    }

    fun btn2(view: View) {
        if (equalCliked) {
            input.text = null
            if (checkNumb)
                input.text = input.text.toString() + "2"
            equalCliked = false

        } else if (checkNumb) {
            if (input.text == "0") {
                input.text = "0"
            } else
                input.text = input.text.toString() + "2"
        }

    }

    fun btn3(view: View) {
        if (equalCliked) {
            input.text = null
            if (checkNumb)
                input.text = input.text.toString() + "3"
            equalCliked = false

        } else if (checkNumb) {
            if (input.text == "0") {
                input.text = "0"
            } else
                input.text = input.text.toString() + "3"
        }

    }

    fun btn4(view: View) {
        if (equalCliked) {
            input.text = null
            if (checkNumb)
                input.text = input.text.toString() + "4"
            equalCliked = false

        } else if (checkNumb) {
            if (input.text == "0") {
                input.text = "0"
            } else
                input.text = input.text.toString() + "4"
        }

    }

    fun btn5(view: View) {
        if (equalCliked) {
            input.text = null
            if (checkNumb)
                input.text = input.text.toString() + "5"
            equalCliked = false

        } else if (checkNumb) {
            if (input.text == "0") {
                input.text = "0"
            } else
                input.text = input.text.toString() + "5"
        }

    }

    fun btn6(view: View) {
        if (equalCliked) {
            input.text = null
            if (checkNumb)
                input.text = input.text.toString() + "6"
            equalCliked = false

        } else if (checkNumb) {
            if (input.text == "0") {
                input.text = "0"
            } else
                input.text = input.text.toString() + "6"
        }

    }

    fun btn7(view: View) {
        if (equalCliked) {
            input.text = null
            if (checkNumb)
                input.text = input.text.toString() + "7"
            equalCliked = false

        } else if (checkNumb) {
            if (input.text == "0") {
                input.text = "0"
            } else
                input.text = input.text.toString() + "7"
        }

    }

    fun btn8(view: View) {
        if (equalCliked) {
            input.text = null
            if (checkNumb)
                input.text = input.text.toString() + "8"
            equalCliked = false

        } else if (checkNumb) {
            if (input.text == "0") {
                input.text = "0"
            } else
                input.text = input.text.toString() + "8"
        }

    }

    fun btn9(view: View) {
        if (equalCliked) {
            input.text = null
            if (checkNumb)
                input.text = input.text.toString() + "9"
            equalCliked = false
        } else if (checkNumb) {
            if (input.text == "0") {
                input.text = "0"
            } else
                input.text = input.text.toString() + "9"
        }

    }


    fun btn_divide(view: View) {

        if (checkOper == false) {
            sign = "/"
            value1 = input.text.toString()
            input.text = null
            signbox.text = "/"
            hasPoint = false
            checkOper = true

        } else {
            sign = "/"
            signbox.text = "/"
        }
    }

    fun btn_multiply(view: View) {

        if (checkOper == false) {
            sign = "*"
            value1 = input.text.toString()
            input.text = null
            signbox.text = "*"
            hasPoint = false
            checkOper = true

        } else {
            sign = "*"
            signbox.text = "*"
        }

    }

    operator fun minus(view: View) {

        if (checkOper == false) {
            sign = "-"
            value1 = input.text.toString()
            input.text = null
            signbox.text = "-"
            checkOper = true
            hasPoint = false
        } else {
            sign = "-"
            signbox.text = "-"
        }


    }

    operator fun plus(view: View) {

        if (checkOper == false) {
            sign = "+"
            value1 = input.text.toString()
            input.text = null
            signbox.text = "+"
            hasPoint = false
            checkOper = true

        } else {
            sign = "+"
            signbox.text = "+"
        }


    }

    fun btn_root(view: View) {
        sign = "root"
        input.text = null
        hasPoint = false
        signbox.text = "√"
    }

    fun btn_square(view: View) {

        if (checkOper == false) {
            sign = "square"
            value1 = input.text.toString()
            input.text = null
            signbox.text = value1 + " ^2"
            hasPoint = false
            checkOper = true

        } else {
            sign = "square"
            signbox.text = value1 + " ^2"
        }
    }


    fun btn_percent(view: View) {
        if (checkOper == false) {
            sign = "%"
            value1 = input.text.toString()
            hasPoint = false
            input.text = null
            checkOper = true
            signbox.text = "%"
        } else {
            sign = "%"
            signbox.text = "%"
        }
    }


    fun equal(view: View) {
        if (sign == null) {
            signbox.text = "Error!"
        } else if (input.text == "" && sign !== "square" && sign !== "!" && sign !== "%") {
            signbox.text = "Error!"
        } else if ((sign == "+" || sign == "-" || sign == "*" || sign == "/" || sign == "square") && value1 == "") {
            signbox.text = "Error!"
        } else {
            hasPoint = true
            equalCliked = true
            when (sign) {

                "root" -> {
                    value1 = input.text.toString()

                    num1 = java.lang.Double.parseDouble(value1.toString())
                    input.text = Math.sqrt(num1!!).toString() + ""
                    sign = null
                    signbox.text = null
                    checkOper = false
                }
                "%" -> {
                    num1 = java.lang.Double.parseDouble(value1.toString())
                    input.text = (num1!! / 100).toString() + ""
                    sign = null
                    checkOper = false

                    signbox.text = null
                }
                "square" -> {

                    num1 = value1?.let { java.lang.Double.parseDouble(it) }
                    result = num1!! * num1!!
                    input.text = result.toString() + ""
                    sign = null
                    signbox.text = null
                    checkOper = false
                }

                "+" -> {
                    value2 = input.text.toString()
                    num1 = java.lang.Double.parseDouble(value1.toString())
                    num2 = java.lang.Double.parseDouble(value2.toString())
                    result = num1!! + num2!!
                    input.text = result.toString() + ""
                    sign = null
                    checkOper = false
                    signbox.text = null
                }
                "-" -> {
                    value2 = input.text.toString()
                    num1 = java.lang.Double.parseDouble(value1.toString())
                    num2 = java.lang.Double.parseDouble(value2.toString())
                    result = num1!! - num2!!
                    input.text = result.toString() + ""
                    sign = null
                    checkOper = false

                    signbox.text = null
                }
                "*" -> {
                    value2 = input.text.toString()
                    num1 = java.lang.Double.parseDouble(value1.toString())
                    num2 = java.lang.Double.parseDouble(value2.toString())
                    result = num1!! * num2!!
                    input.text = result.toString() + ""
                    sign = null
                    checkOper = false

                    signbox.text = null
                }
                "/" -> {
                    num1 = java.lang.Double.parseDouble(value1.toString())
                    value2 = input.text.toString()
                    num2 = java.lang.Double.parseDouble(value2.toString())
                    if (num2==0.0)
                        input.text = "Can't divide by zero"
                    else {
                        result = num1!! / num2!!
                        input.text = result.toString() + ""

                    }
                    checkOper = false
                    sign = null
                    signbox.text = null
                }
            }

        }
    }

    fun btn_dot(view: View) {
        if (!hasPoint && checkNumb) {
            if (input.text == "") {
                input.text = "0."
            } else {
                input.text = input.text.toString() + "."
            }
            hasPoint = true
        }
    }

    fun delete(view: View) {
        if (input.text == "")
            input.text = null
        else {
            val len = input.text.length
            val s = input.text.toString()
            if (s[len - 1] == '.') {
                hasPoint = false
                input.text = input.text.subSequence(0, len - 1)
            } else
                input.text = input.text.subSequence(0, len - 1)
        }
    }

    fun clear(view: View) {
        input.text = null
        signbox.text = null
        value1
        value2 = null
        sign = null
        hasPoint = false
        equalCliked = false
        checkOper=false
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("numberInput", input.text.toString())
        outState.putString("signInput", signbox.text.toString())
        outState.putString("sign", sign)
        outState.putString("number1", value1)
        outState.putString("number2", value2)
        outState.putBoolean("equalClicked", equalCliked)
        outState.putBoolean("checkNumber", checkNumb)
        outState.putBoolean("checkOperation", checkOper)
        outState.putBoolean("hasPoint", hasPoint)
        operation = signbox.text.toString()
        outState.putString("operation", operation)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        savedInstanceState.getString("numberInput")
        savedInstanceState.getString("number1")
        savedInstanceState.getString("number2")
        savedInstanceState.getString("checkNumber")
        savedInstanceState.getString("hasPoint")
        savedInstanceState.getString("signInput")
        savedInstanceState.getString("sign")
        savedInstanceState.getString("equalClicked")
        savedInstanceState.getString("checkOperation")
        savedInstanceState.getString("operation")

    }


}


