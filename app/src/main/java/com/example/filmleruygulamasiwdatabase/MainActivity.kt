package com.example.filmleruygulamasiwdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Data
import android.text.Layout
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.filmleruygulamasiwdatabase.databinding.ActivityMainBinding
import com.info.sqlitekullanimihazirveritabani.DatabaseCopyHelper

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var kategoriList : ArrayList<Kategoriler>
    private lateinit var adapter : KategoriAdapter
    private lateinit var dbh :DataBaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        veriTabaniKopyala()

        binding.toolbarKategori.title = "Kategoriler"
        setSupportActionBar(binding.toolbarKategori)

        binding.kategoriRv.setHasFixedSize(true)
        binding.kategoriRv.layoutManager = LinearLayoutManager(this)

        dbh = DataBaseHelper(this)

        kategoriList = ArrayList()

        kategoriList = Kategorilerdao().tumKategoriler(dbh)





        adapter = KategoriAdapter(this,kategoriList)

        binding.kategoriRv.adapter = adapter
    }

    fun veriTabaniKopyala(){
        val copyHelper = DatabaseCopyHelper(this)
        try {
            copyHelper.createDataBase()
            copyHelper.openDataBase()
        }catch(e:Exception){
            e.printStackTrace()
        }
    }
}