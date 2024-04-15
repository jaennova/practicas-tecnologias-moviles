package com.jaennova.tecmoviles.bmicalculator

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.jaennova.tecmoviles.R
import com.jaennova.tecmoviles.databinding.ActivityBmiCalculatorBinding
import java.text.DecimalFormat

class BmiCalculatorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBmiCalculatorBinding
    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false
    private var currentWeight: Int = 70
    private var currentAge: Int = 30
    private var currentHeight: Int = 120

    companion object {
        const val IMC_KEY = "IMC_RESULT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBmiCalculatorBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initListeners()
        initUI()
    }

    private fun initListeners() {
        binding.viewMale.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        binding.viewFemale.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        binding.rsHeight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##")
            currentHeight = df.format(value).toInt()
            binding.tvHeight.text = "$currentHeight cm"
        }
        binding.btnPlusWeight.setOnClickListener {
            currentWeight += 1
            setWeight()
        }
        binding.btnSubtractWeight.setOnClickListener {
            currentWeight -= 1
            setWeight()
        }
        binding.btnPlusAge.setOnClickListener {
            currentAge += 1
            setAge()
        }
        binding.btnSubtractAge.setOnClickListener {
            currentAge -= 1
            setAge()
        }
        binding.btnCalculate.setOnClickListener {
            val result = calculateIMC()
            navigateToResult(result)
        }
    }

    private fun navigateToResult(result: Double) {
        val intent = Intent(this, BmiResultActivity::class.java)
        intent.putExtra(IMC_KEY, result)
        startActivity(intent)
    }

    private fun calculateIMC(): Double {
        val df = DecimalFormat("#.##")
        val imc = currentWeight / (currentHeight.toDouble() / 100 * currentHeight.toDouble() / 100)
        return df.format(imc).toDouble()
    }

    private fun setAge() {
        binding.tvAge.text = currentAge.toString()
    }

    private fun setWeight() {
        binding.tvWeight.text = currentWeight.toString()
    }

    private fun changeGender() {
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected
    }

    private fun setGenderColor() {
        binding.viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        binding.viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
    }

    private fun getBackgroundColor(isSelectedComponent: Boolean): Int {

        val colorReference = if (isSelectedComponent) {
            R.color.bmi_colorBackgroundTertiary
        } else {
            R.color.bmi_colorBackgroundSecondary
        }

        return ContextCompat.getColor(this, colorReference)
    }

    private fun initUI() {
        setGenderColor()
        setWeight()
        setAge()
    }
}