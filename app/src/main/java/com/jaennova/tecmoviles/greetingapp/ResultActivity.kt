package com.jaennova.tecmoviles.greetingapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.jaennova.tecmoviles.R
import com.jaennova.tecmoviles.greetingapp.FirstAppActivity.Companion.EXTRA_NAME

class ResultActivity : AppCompatActivity() {
    private lateinit var btnBack: Button
    private lateinit var tvResult: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        btnBack = findViewById(R.id.btnBack)
        getAndShowName()
        btnBack.setOnClickListener { onBackPressed() }
    }

    private fun getAndShowName() {
        tvResult = findViewById(R.id.tvResult)
        val name: String = intent.extras?.getString(EXTRA_NAME).orEmpty()
        tvResult.text = "Bienvenido! $name"
    }
}