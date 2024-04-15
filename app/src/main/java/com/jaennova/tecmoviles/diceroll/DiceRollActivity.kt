package com.jaennova.tecmoviles.diceroll

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jaennova.tecmoviles.R
import com.jaennova.tecmoviles.databinding.ActivityDiceRollBinding

class DiceRollActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDiceRollBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDiceRollBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnDice.setOnClickListener { rollDice() }
    }

    private fun rollDice() {
        val randomDice = (1..6).random()
        binding.ivDice.setImageResource(getDiceDrawableResource(randomDice))
    }

    private fun getDiceDrawableResource(diceValue: Int): Int {
        return when (diceValue) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }
}