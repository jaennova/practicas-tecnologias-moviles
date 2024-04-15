package com.jaennova.tecmoviles.mainmenu

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jaennova.tecmoviles.R

class MainActivity : AppCompatActivity() {
    private lateinit var rvMenu: RecyclerView
    private lateinit var menuAdapter: MenuAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        rvMenu = findViewById(R.id.rvMenu)
        rvMenu.layoutManager = LinearLayoutManager(this)
        menuAdapter = MenuAdapter(this, menuItems)
        rvMenu.adapter = menuAdapter
    }
}