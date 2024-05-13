package com.example.filmleruygulamasiwdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.filmleruygulamasiwdatabase.databinding.ActivityDetayBinding

class DetayActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetayBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val film = intent.getSerializableExtra("filmNesne") as Filmler

        binding.textViewFilmAdd.text = film.film_ad
        binding.textViewYil.text = film.film_yil.toString()
        binding.textViewYonetmen.text = film.yonetmen.yonetmen_ad

        binding.imageViewResim.setImageResource(resources.getIdentifier(film.film_resim
            ,"drawable",packageName))


    }
}