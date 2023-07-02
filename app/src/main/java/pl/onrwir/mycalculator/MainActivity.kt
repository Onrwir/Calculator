package pl.onrwir.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var tvInput : TextView? = null
    var lastNumeric : Boolean = true
    var lastDot : Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvInput = findViewById<TextView>(R.id.tvResult)


    }

    override fun onClick(p0: View?) {

        when (p0?.id){
            R.id.btnOne, R.id.btnTwo, R.id.btnThree, R.id.btnFour, R.id.btnFive, R.id.btnSix, R.id.btnSeven, R.id.btnEight, R.id.btnNine, R.id.btnZero -> {
                tvInput?.append((p0 as Button).text)
                lastNumeric = true
                lastDot = false
            }
            R.id.btnCLR -> {
                tvInput?.text = ""
                lastNumeric = false
                lastDot = true
            }
            R.id.btnDot ->
            {
                tvInput?.append(".")
                lastDot = true
                lastNumeric = false
            }
            R.id.btnDivide, R.id.btnMultiply, R.id.btnSubtract, R.id.btnAdd -> {
                tvInput?.text?.let{
                    if(lastNumeric && !isOperatorAdded(it.toString())){
                        tvInput?.append((p0 as Button).text)
                        lastNumeric = false
                        lastDot = false
                    }
                }

            }
            R.id.btnEqual -> {

            }

        }

    }


    private fun isOperatorAdded(value : String) : Boolean{
        return if(value.startsWith("-")){
            false
        }else{
            value.contains("/")
                    || value.contains("*")
                    || value.contains("+")
                    || value.contains("-")
        }
    }

}