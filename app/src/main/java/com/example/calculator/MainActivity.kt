package com.example.calculator

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_0.setOnClickListener { SetTextFields("0") }
        btn_1.setOnClickListener { SetTextFields("1") }
        btn_2.setOnClickListener { SetTextFields("2") }
        btn_3.setOnClickListener { SetTextFields("3") }
        btn_4.setOnClickListener { SetTextFields("4") }
        btn_5.setOnClickListener { SetTextFields("5") }
        btn_6.setOnClickListener { SetTextFields("6") }
        btn_7.setOnClickListener { SetTextFields("7") }
        btn_8.setOnClickListener { SetTextFields("8") }
        btn_9.setOnClickListener { SetTextFields("9") }
        btn_zn.setOnClickListener { SetTextFields(".") }

        btn_mun.setOnClickListener { SetTextFields("-") }
        btn_plus.setOnClickListener { SetTextFields("+") }
        btn_umn.setOnClickListener { SetTextFields("*") }
        btn_del.setOnClickListener { SetTextFields("/") }
        btn_r.setOnClickListener { SetTextFields("(") }
        btn_l.setOnClickListener { SetTextFields(")") }

        btn_clear.setOnClickListener {
            math_operation.setText(null)
            result_text.setText(null)
        }

        btn_back.setOnClickListener {
            val str = math_operation.text.toString()
           if (str.isNotEmpty()){
               math_operation.text = str.substring(0,str.length-1)
           }
            result_text.setText(null)
        }

        btn_rez.setOnClickListener {
            try {
                val ex = ExpressionBuilder(math_operation.text.toString()).build()
                val result = ex.evaluate()

                val longRes = result.toLong()
                if (result == longRes.toDouble()){
                    result_text.text = longRes.toString()
                }
                else result_text.text = result.toString()

            } catch (e:Exception){
                Log.d("Ошибка", "сообщение: ${e.message}")
            }
        }

    }

    fun SetTextFields(string: String){
        if (result_text.text != ""){
            math_operation.text = result_text.text
            result_text.setText(null)
        }
        math_operation.append(string)
    }

}