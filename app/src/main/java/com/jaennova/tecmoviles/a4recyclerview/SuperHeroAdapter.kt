package com.jaennova.tecmoviles.a4recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jaennova.tecmoviles.R

class SuperHeroAdapter(
    private val context: Context,
    private val superheroList: MutableList<Superhero>
) : RecyclerView.Adapter<SuperHeroViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.item_super_hero_list, parent, false)
        return SuperHeroViewHolder(view)
    }

    override fun getItemCount() = superheroList.size

    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {
        val superheroList = superheroList[position]
        holder.bind(superheroList)
    }
}