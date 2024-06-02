package com.jaennova.tecmoviles.mainmenu

import android.content.res.Configuration
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import com.jaennova.tecmoviles.R
import com.jaennova.tecmoviles.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var menuAdapter: MenuAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        setupDarkModeButton()
        val languageButton: ImageButton = findViewById(R.id.languageButton)
        languageButton.setOnClickListener {
            toggleLanguage()
        }

    }

    private fun setupRecyclerView() {
        val menuItems = listOf(
            MenuItem(
                R.string.menu_title_lifecycle,
                R.drawable.ic_cycle,
                R.string.menu_desc_lifecycle
            ),
            MenuItem(
                R.string.menu_title_dice_roll,
                R.drawable.ic_dice,
                R.string.menu_desc_dice_roll
            ),
            MenuItem(
                R.string.menu_title_greeting,
                R.drawable.ic_firstapp,
                R.string.menu_desc_greeting
            ),
            MenuItem(
                R.string.menu_title_super_hero_list,
                R.drawable.ic_superhero,
                R.string.menu_desc_super_hero_list
            ),
            MenuItem(
                R.string.menu_title_bmi_calculator,
                R.drawable.ic_bmi_app,
                R.string.menu_desc_bmi_calculator
            ),
            MenuItem(
                R.string.menu_title_calculator,
                R.drawable.ic_calculator,
                R.string.menu_desc_calculator
            ),
            MenuItem(
                R.string.menu_title_random_user,
                R.drawable.ic_user,
                R.string.menu_desc_random_user
            )
        )


        binding.rvMenu.layoutManager = LinearLayoutManager(this)
        menuAdapter = MenuAdapter(this, menuItems)
        binding.rvMenu.adapter = menuAdapter
    }

    private fun setupDarkModeButton() {
        val darkModeButton = binding.darkModeButton

        // Set the initial icon based on the current mode
        updateDarkModeButtonIcon()

        darkModeButton.setOnClickListener {
            toggleNightMode()
            updateDarkModeButtonIcon()
        }
    }

    private fun updateDarkModeButtonIcon() {
        val nightMode = AppCompatDelegate.getDefaultNightMode()
        val currentNightMode = if (nightMode == AppCompatDelegate.MODE_NIGHT_YES ||
            (nightMode == AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM &&
                    resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES)
        ) {
            R.drawable.light_mode
        } else {
            R.drawable.dark_mode
        }
        binding.darkModeButton.setImageResource(currentNightMode)
    }

    private fun toggleNightMode() {
        val nightMode = AppCompatDelegate.getDefaultNightMode()
        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
    }
    private fun toggleLanguage() {
        val currentLocale = resources.configuration.locale
        val newLocale = if (currentLocale == Locale.ENGLISH) Locale("es") else Locale.ENGLISH

        val configuration = Configuration(resources.configuration)
        configuration.setLocale(newLocale)
        resources.updateConfiguration(configuration, resources.displayMetrics)

        recreate()
    }
}
