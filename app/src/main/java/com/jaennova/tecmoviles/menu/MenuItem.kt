package com.jaennova.tecmoviles.menu

import com.jaennova.tecmoviles.R

data class MenuItem(val title: String, val iconResId: Int, val description: String)

val menuItems = listOf(
    MenuItem(
        "Life Cycle",
        R.drawable.ic_launcher_foreground,
        "Aplicación sobre el ciclo de vida de un Activity"
    ),
    MenuItem(
        "Dice Roll",
        R.drawable.ic_dice,
        "Aplicacion simple que simula la acción de un dado"
    ),
    MenuItem(
        "First App",
        R.drawable.ic_firstapp,
        "Aplicacion simple que usa intents"
    ),
    MenuItem(
        "Super Hero List",
        R.drawable.ic_firstapp,
        "Aplicacion simple que hace uso de recycler views"
    ),
)
