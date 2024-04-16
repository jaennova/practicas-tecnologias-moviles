package com.jaennova.tecmoviles.greetingapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jaennova.tecmoviles.databinding.ActivityResultBinding
import com.jaennova.tecmoviles.greetingapp.FirstAppActivity.Companion.EXTRA_NAME

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getAndShowName()
        binding.btnBack.setOnClickListener { onBackPressed() }
    }

    private fun getAndShowName() {
        val name: String = intent.extras?.getString(EXTRA_NAME).orEmpty()
        binding.tvResult.text = "Bienvenido! $name"
    }
}