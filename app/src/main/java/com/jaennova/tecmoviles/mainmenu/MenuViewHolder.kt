package com.jaennova.tecmoviles.mainmenu

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.jaennova.tecmoviles.apiexample.RandomUserActivity
import com.jaennova.tecmoviles.bmicalculator.BmiCalculatorActivity
import com.jaennova.tecmoviles.calculator.CalculatorActivity
import com.jaennova.tecmoviles.databinding.MenuItemBinding
import com.jaennova.tecmoviles.lifecycleexample.LifeCycleActivity
import com.jaennova.tecmoviles.diceroll.DiceRollActivity
import com.jaennova.tecmoviles.greetingapp.FirstAppActivity
import com.jaennova.tecmoviles.superheroapp.SuperHeroListActivity
import com.jaennova.tecmoviles.R

class MenuViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = MenuItemBinding.bind(view)

    fun bind(menuItem: MenuItem) {
        binding.tvTitleApp.text = itemView.context.getString(menuItem.titleResId)
        binding.tvDescriptionApp.text = itemView.context.getString(menuItem.descriptionResId)
        binding.ivIconApp.setImageResource(menuItem.iconResId)
        itemView.setOnClickListener {
            navigateToActivity(menuItem)
        }
    }


    private fun navigateToActivity(menuItem: MenuItem) {
        val context = binding.ivIconApp.context
        when (menuItem.titleResId) {
            R.string.menu_title_lifecycle -> openActivity(context, LifeCycleActivity::class.java)
            R.string.menu_title_dice_roll -> openActivity(context, DiceRollActivity::class.java)
            R.string.menu_title_greeting -> openActivity(context, FirstAppActivity::class.java)
            R.string.menu_title_super_hero_list -> openActivity(context, SuperHeroListActivity::class.java)
            R.string.menu_title_bmi_calculator -> openActivity(context, BmiCalculatorActivity::class.java)
            R.string.menu_title_calculator -> openActivity(context, CalculatorActivity::class.java)
            R.string.menu_title_random_user -> openActivity(context, RandomUserActivity::class.java)
        }
    }

    private fun openActivity(context: Context, activityClass: Class<*>) {
        val intent = Intent(context, activityClass)
        startActivity(context, intent, null)
    }
}
