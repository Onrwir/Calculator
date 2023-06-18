package pl.onrwir.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var tvResult :TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvResult = findViewById<TextView>(R.id.tvResult)
        val btnSeven = findViewById<Button>(R.id.btnSeven)
        val btnEight = findViewById<Button>(R.id.btnEight)
        val btnNine = findViewById<Button>(R.id.btnNine)
        val btnDivide = findViewById<Button>(R.id.btnDivide)

        val btnList = arrayOf(btnSeven, btnEight, btnNine, btnDivide)
        for (button in btnList){
            button.setOnClickListener(this)
        }

//        btnSeven.setOnClickListener(this)
//        btnEight.setOnClickListener(this)
//        btnNine.setOnClickListener(this)
//        btnDivide.setOnClickListener(this)



    }

    override fun onClick(p0: View?) {

        when (p0?.id){
            R.id.btnSeven -> {
                val result = "Button seven clicked"
                tvResult?.text = result
            }

        }

        //Toast.makeText(this,"Button ${p0?.id} Clicked",Toast.LENGTH_LONG).show()
    }
}