package com.jaennova.tecmoviles.a1lifecycle

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.jaennova.tecmoviles.R

class LifeCycleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_life_cycle)
        showToast("onCreate()")
    }

    override fun onPause() { // Método llamado cuando la actividad está a punto de ser pausada
        super.onPause()
        showToast("onPause()")
    }

    override fun onStart() { // Método llamado cuando la actividad está a punto de ser visible
        super.onStart()
        showToast("onStart()")
    }

    override fun onResume() { // Método llamado cuando la actividad se vuelve visible
        super.onResume()
        showToast("onResume()")
    }

    override fun onStop() { // Método llamado cuando la actividad deja de ser visible
        super.onStop()
        showToast("onStop()")
    }

    override fun onDestroy() { // Método llamado cuando la actividad va a ser destruida
        super.onDestroy()
        showToast("onDestroy()")
    }

    override fun onRestart() { // Método llamado cuando la actividad se reinicia después de haber sido detenida
        super.onRestart()
        showToast("onRestart()")
    }

    private fun showToast(message: String) { // Función privada para mostrar un Toast con un mensaje
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}