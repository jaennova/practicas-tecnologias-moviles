package com.jaennova.tecmoviles.mainmenu

import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jaennova.tecmoviles.R
import com.jaennova.tecmoviles.bmicalculator.BmiCalculatorActivity
import com.jaennova.tecmoviles.lifecycleexample.LifeCycleActivity
import com.jaennova.tecmoviles.diceroll.DiceRollActivity
import com.jaennova.tecmoviles.greetingapp.FirstAppActivity
import com.jaennova.tecmoviles.superheroapp.SuperHeroListActivity

class MenuViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val tvTitleApp: TextView = itemView.findViewById(R.id.tvTitleApp)
    private val ivIconApp: ImageView = itemView.findViewById(R.id.ivIconApp)
    private val tvDescriptionApp: TextView = itemView.findViewById(R.id.tvDescriptionApp)

    fun bind(menuItem: MenuItem) {
        tvTitleApp.text = menuItem.title
        tvDescriptionApp.text = menuItem.description
        ivIconApp.setImageResource(menuItem.iconResId)
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
        }
    }

    private fun openActivity(activityClass: Class<*>) {
        val intent = Intent(ivIconApp.context, activityClass)
        ivIconApp.context.startActivity(intent)
    }
}