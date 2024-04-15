package com.jaennova.tecmoviles.greetingapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.jaennova.tecmoviles.R

class FirstAppActivity : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var btnChangeActivity: Button

    companion object {
        const val EXTRA_NAME = "EXTRA_NAME"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_first_app)

        initializeViews()
        setListeners()
    }

    private fun initializeViews() {
        etName = findViewById(R.id.etName)
        btnChangeActivity = findViewById(R.id.btnChangeActivity)
    }

    private fun setListeners() {
        btnChangeActivity.setOnClickListener { checkValue() }
    }

    private fun checkValue() {
        val name = etName.text.toString()
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
