package com.jaennova.tecmoviles.a4recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jaennova.tecmoviles.R

class SuperHeroListActivity : AppCompatActivity() {
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: SuperHeroAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_super_hero_list)
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        mRecyclerView = findViewById(R.id.rvSuperHeroList)
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mAdapter = SuperHeroAdapter(this, getSuperheros())
        mRecyclerView.adapter = mAdapter
    }

}