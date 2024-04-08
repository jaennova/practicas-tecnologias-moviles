package com.jaennova.tecmoviles.a4recyclerview

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jaennova.tecmoviles.R
import com.squareup.picasso.Picasso

class SuperHeroViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val superHeroName = view.findViewById<TextView>(R.id.tvSuperHero)
    private val realName = view.findViewById<TextView>(R.id.tvRealName)
    private val publisher = view.findViewById<TextView>(R.id.tvPublisher)
    private val avatar = view.findViewById<ImageView>(R.id.ivAvatar)

    fun bind(superheroList: Superhero) {
        superHeroName.text = superheroList.superhero
        realName.text = superheroList.realName
        publisher.text = superheroList.publisher
        Picasso.get().load(superheroList.photo).into(avatar)
    }
}