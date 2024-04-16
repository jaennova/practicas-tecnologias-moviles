package com.jaennova.tecmoviles.greetingapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.jaennova.tecmoviles.R
import com.jaennova.tecmoviles.databinding.ActivityFirstAppBinding

class FirstAppActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFirstAppBinding
    companion object {
        const val EXTRA_NAME = "EXTRA_NAME"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstAppBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnChangeActivity.setOnClickListener { checkValue() }
    }

    private fun checkValue() {
        val name = binding.etName.text.toString()
        if (name.isEmpty()) {
            "el nombre no puede estar vacio".showToast()
        } else {
            startResultActivity(name)
        }
    }

    private fun String.showToast() {
        Toast.makeText(this@FirstAppActivity, this, Toast.LENGTH_SHORT).show()
    }

    private fun startResultActivity(name: String) {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra(EXTRA_NAME, name)
        startActivity(intent)
    }
}
