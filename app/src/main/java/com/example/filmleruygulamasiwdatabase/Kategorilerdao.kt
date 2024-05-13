package com.example.filmleruygulamasiwdatabase

import android.annotation.SuppressLint

class Kategorilerdao(){

    @SuppressLint("Range")
    fun tumKategoriler(dbx:DataBaseHelper): ArrayList<Kategoriler>{
        val db = dbx.writableDatabase

        val kategorilerListe = ArrayList<Kategoriler>()

        val c = db.rawQuery("SELECT * FROM kategoriler",null)

        while (c.moveToNext()){
            val kategori = Kategoriler(c.getInt(c.getColumnIndex("kategori_id"))
            ,c.getString(c.getColumnIndex("kategori_ad")))

            println(kategori.kategori_ad)


            kategorilerListe.add(kategori)
        }

        return kategorilerListe
    }
}