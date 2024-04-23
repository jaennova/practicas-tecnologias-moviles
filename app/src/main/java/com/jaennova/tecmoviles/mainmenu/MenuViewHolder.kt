package com.jaennova.tecmoviles.mainmenu

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.jaennova.tecmoviles.bmicalculator.BmiCalculatorActivity
import com.jaennova.tecmoviles.calculator.CalculatorActivity
import com.jaennova.tecmoviles.databinding.MenuItemBinding
import com.jaennova.tecmoviles.lifecycleexample.LifeCycleActivity
import com.jaennova.tecmoviles.diceroll.DiceRollActivity
import com.jaennova.tecmoviles.greetingapp.FirstAppActivity
import com.jaennova.tecmoviles.superheroapp.SuperHeroListActivity

class MenuViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = MenuItemBinding.bind(view)
    fun bind(menuItem: MenuItem) {
        binding.tvTitleApp.text = menuItem.title
        binding.tvDescriptionApp.text = menuItem.description
        binding.ivIconApp.setImageResource(menuItem.iconResId)
        itemView.setOnClickListener {
            navigateToActivity(menuItem)
        }

    }

    private fun navigateToActivity(menuItem: MenuItem) {
        when (menuItem.title) {
            "Life Cycle" -> openActivity(LifeCycleActivity::class.java)
            "Dice Roll" -> openActivity(DiceRollActivity::class.java)
            "Greeting" -> openActivity(FirstAppActivity::class.java)
            "Super Hero List" -> openActivity(SuperHeroListActivity::class.java)
            "BMI Calculator" -> openActivity(BmiCalculatorActivity::class.java)
            "Calculator" -> openActivity(CalculatorActivity::class.java)
        }
    }

    private fun openActivity(activityClass: Class<*>) {
        val intent = Intent(binding.ivIconApp.context, activityClass)
        binding.ivIconApp.context.startActivity(intent)
    }
}