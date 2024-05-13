package com.example.filmleruygulamasiwdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Data
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.filmleruygulamasiwdatabase.databinding.ActivityFilmlerActivityyBinding

class FilmlerActivityy : AppCompatActivity() {
    private lateinit var binding : ActivityFilmlerActivityyBinding
    private lateinit var fimList: ArrayList<Filmler>
    private lateinit var adapter : FilmlerAdapter
    private lateinit var dbh:DataBaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilmlerActivityyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val kategori = intent.getSerializableExtra("kategoriNesne") as Kategoriler


        binding.toolbarFilmler.title = "Filmler: ${kategori.kategori_ad}"
        setSupportActionBar(binding.toolbarFilmler)

        binding.filmlerRv.setHasFixedSize(true)
        binding.filmlerRv.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

        dbh =DataBaseHelper(this)


        fimList = Filmlerdao().tumFilmlerByKategoriId(dbh,kategori.kategori_id)

        adapter = FilmlerAdapter(this,fimList)

        binding.filmlerRv.adapter = adapter
    }
}