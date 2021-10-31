package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tipcalculator.databinding.ActivityMainBinding
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    lateinit var bindingMainActivity: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMainActivity = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingMainActivity.root)

        bindingMainActivity.calculateButton.setOnClickListener {
            calculateTip()
        }
    }

    private fun calculateTip() {

        val cost = bindingMainActivity.costOfService.text.toString().toDouble()
        val percentage = when(bindingMainActivity.radioGroup.checkedRadioButtonId) {
            R.id.amazing -> 0.2
            R.id.good -> 0.18
            R.id.ok -> 0.15
            else -> 0.0

        }

        if(bindingMainActivity.roundTipSwitch.isChecked){
            bindingMainActivity.tipAmountTextView.text = getString(R.string.tip_amount_text_view, (cost + (cost * percentage).roundToInt()).toInt().toString())

        }else {
            bindingMainActivity.tipAmountTextView.text = getString(R.string.tip_amount_text_view, (cost + (cost * percentage)).toString())
        }


    }

}



