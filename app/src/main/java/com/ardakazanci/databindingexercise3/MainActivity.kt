package com.ardakazanci.databindingexercise3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ardakazanci.databindingexercise3.adapter.HeroesAdapter
import com.ardakazanci.databindingexercise3.model.Hero
import com.ardakazanci.databindingexercise3.repository.HeroesRepository

class MainActivity : AppCompatActivity(),HeroesAdapter.OnHeroClickListener {
    override fun onHeroClick(hero: Hero) {
        Log.d("MainActivity", "Clicked Hero: ${hero.name}")
    }

    private lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyclerView = findViewById(R.id.heroes_list)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val repository = HeroesRepository.getInstance(applicationContext)
        val heroes = repository.fetchHeroes()

        val adapter = HeroesAdapter(heroes,this)
        recyclerView.adapter = adapter


    }
}
