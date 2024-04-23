package com.jaennova.tecmoviles.calculator

import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.children
import com.jaennova.tecmoviles.R
import com.jaennova.tecmoviles.databinding.ActivityCalculatorBinding

class CalculatorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCalculatorBinding

    private var accumulatedValue = ""
    private var currentInput = ""
    private var currentOperator = ""
    private val expressionEvaluator = ExpressionEvaluator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        initViews()
    }

    private fun initViews() {
        binding.apply {
            binding.layoutMain.children.filterIsInstance<ImageButton>().forEach { button: ImageButton ->
                button.setOnClickListener { handleButtonClick(button.contentDescription.toString()) }
            }
        }
    }

    private fun handleButtonClick(buttonText: String) {
        when {
            Character.isDigit(buttonText[0]) -> handleDigitInput(buttonText)
            isOperator(buttonText) -> handleOperatorInput(buttonText)
            buttonText == "=" -> handleEqualInput()
            buttonText == "." -> handleDecimalInput()
            buttonText == "C" -> handleClearInput()
        }
    }

    private fun handleDigitInput(digit: String) {
        currentInput += digit
        binding.tvResult.text = currentInput
    }

    private fun handleOperatorInput(operator: String) {
        if (accumulatedValue.isNotEmpty()) {
            binding.tvFormula.text = "$accumulatedValue$currentOperator"
        }
        accumulatedValue = currentInput.ifEmpty { accumulatedValue }
        currentInput = ""
        currentOperator = operator
        binding.tvFormula.text = "$accumulatedValue$currentOperator"
        binding.tvResult.text = ""

        // Agregar estos casos
        when (operator) {
            "%" -> {
                accumulatedValue = evaluateModulo(accumulatedValue)
                binding.tvResult.text = accumulatedValue
            }

            "+/-" -> {
                accumulatedValue = negateNumber(accumulatedValue)
                binding.tvResult.text = accumulatedValue
            }
        }
    }

    private fun evaluateModulo(value: String): String {
        val num = value.toDoubleOrNull() ?: return ""
        return num.toInt().toString()
    }

    private fun negateNumber(value: String): String {
        val num = value.toDoubleOrNull() ?: return ""
        return (-num).toString()
    }


    private fun handleEqualInput() {
        if (currentInput.isNotEmpty() && currentOperator.isNotEmpty()) {
            binding.tvFormula.text = "$accumulatedValue$currentOperator$currentInput"
            try {
                val result =
                    expressionEvaluator.evaluate(accumulatedValue, currentInput, currentOperator)
                accumulatedValue = result
                binding.tvResult.text = result
            } catch (e: Exception) {
                // Handle error cases (e.g., division by zero)
                binding.tvResult.text = "Error"
            }
        }
    }

    private fun handleDecimalInput() {
        if (!currentInput.contains(".")) {
            currentInput += if (currentInput.isEmpty()) "0."
            else "."
            binding.tvResult.text = currentInput
        }
    }

    private fun handleClearInput() {
        currentInput = ""
        accumulatedValue = ""
        currentOperator = ""
        binding.tvResult.text = "0"
        binding.tvFormula.text = ""
    }

    private fun isOperator(char: String) =
        char == "+" || char == "-" || char == "*" || char == "/" || char == "%" || char == "+/-"
}

class ExpressionEvaluator {
    fun evaluate(firstNumber: String, secondNumber: String, operator: String): String {
        val num1 = firstNumber.toDoubleOrNull() ?: return ""
        val num2 = secondNumber.toDoubleOrNull() ?: return ""

        return when (operator) {
            "+" -> formatResult(num1 + num2)
            "-" -> formatResult(num1 - num2)
            "*" -> formatResult(num1 * num2)
            "/" -> if (num2 == 0.0) "Error" else formatResult(num1 / num2)
            "%" -> formatResult(num1 % num2)
            else -> ""
        }
    }

    private fun formatResult(result: Double): String {
        return if (result % 1 == 0.0) {
            result.toInt().toString()
        } else {
            result.toString()
        }
    }
}