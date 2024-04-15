package com.jaennova.tecmoviles.diceroll

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.jaennova.tecmoviles.R

class DiceRollActivity : AppCompatActivity() {
    private lateinit var btnDice: Button
    private lateinit var ivDice: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice_roll)
        btnDice = findViewById(R.id.btnDice)
        btnDice.setOnClickListener { rollDice() }
    }

    private fun rollDice() {
        val randomDice = (1..6).random()
        ivDice = findViewById(R.id.ivDice)
        ivDice.setImageResource(getDiceDrawableResource(randomDice))
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