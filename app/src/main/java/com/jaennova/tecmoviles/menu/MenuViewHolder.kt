package com.jaennova.tecmoviles.menu

import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jaennova.tecmoviles.R
import com.jaennova.tecmoviles.a1lifecycle.LifeCycleActivity
import com.jaennova.tecmoviles.a2diceroll.DiceRollActivity
import com.jaennova.tecmoviles.a3firstapp.FirstAppActivity
import com.jaennova.tecmoviles.a4recyclerview.SuperHeroListActivity

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
        }
    }

    private fun openActivity(activityClass: Class<*>) {
        val intent = Intent(ivIconApp.context, activityClass)
        ivIconApp.context.startActivity(intent)
    }
}