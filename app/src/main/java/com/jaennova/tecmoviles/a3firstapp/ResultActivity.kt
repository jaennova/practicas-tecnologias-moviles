package com.jaennova.tecmoviles.a3firstapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.jaennova.tecmoviles.R

class ResultActivity : AppCompatActivity() {
    private lateinit var btnBack: Button
    private lateinit var tvGreeting: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        btnBack = findViewById(R.id.btnBack)

        getAndShowName()
        btnBack.setOnClickListener { onBackPressed() }
    }
    private fun getAndShowName(){
        tvGreeting = findViewById(R.id.tvGreeting)
        val bundle = intent.extras
        val name = bundle?.get("name")
        tvGreeting.text = getString(R.string.welcome, name)
    }
}