package com.jaennova.tecmoviles.a3firstapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.jaennova.tecmoviles.R

class FirstAppActivity : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var btnChangeActivity: Button
    private lateinit var tvName: TextView

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
        tvName = findViewById(R.id.tvName)
        tvName.text = intent.getStringExtra("name")
    }

    private fun setListeners() {
        btnChangeActivity.setOnClickListener { checkValue() }
    }

    private fun checkValue() {
        val name = etName.text.toString()
        if (name.isEmpty()) {
            showToast("el nombre no puede estar vacio")
        } else {
            startResultActivity(name)
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun startResultActivity(name: String) {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("name", name)
        startActivity(intent)
    }
}
