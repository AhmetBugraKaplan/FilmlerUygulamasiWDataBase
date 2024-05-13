package com.example.filmleruygulamasiwdatabase

import android.content.Context
import android.content.Intent
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class KategoriAdapter(private val mContext: Context,private val kategoriList:List<Kategoriler>)
    :RecyclerView.Adapter<KategoriAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(view:View):RecyclerView.ViewHolder(view){

        var kategori_card:CardView
        var textViewKategoriAdi:TextView

        init {
            kategori_card = view.findViewById(R.id.kategori_card)
            textViewKategoriAdi = view.findViewById(R.id.textViewKategoriAd)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val view = LayoutInflater.from(mContext).inflate(R.layout.kategori_card_tasarimm,parent,false)
        return CardTasarimTutucu(view)
    }

    override fun getItemCount(): Int {
        return kategoriList.size
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {

        val kategori = kategoriList.get(position)

        holder.textViewKategoriAdi.text = kategori.kategori_ad

        holder.kategori_card.setOnClickListener {
            val intent = Intent(mContext,FilmlerActivityy::class.java)
            intent.putExtra("kategoriNesne",kategori)
            mContext.startActivity(intent)
        }
    }


}