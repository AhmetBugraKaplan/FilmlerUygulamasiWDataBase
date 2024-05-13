package com.example.filmleruygulamasiwdatabase

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class FilmlerAdapter(private val mContext: Context,private val FilmList:List<Filmler>)
    :RecyclerView.Adapter<FilmlerAdapter.FilmTasarimTutucu>(){

    inner class FilmTasarimTutucu(view:View): RecyclerView.ViewHolder(view){

        var card_film : CardView
        var imageViewResim : ImageView
        var textViewFilmAd : TextView

        init {
          card_film = view.findViewById(R.id.film_card)
            imageViewResim = view.findViewById(R.id.imageViewFilmResim)
            textViewFilmAd = view.findViewById(R.id.textViewFilmAd)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmTasarimTutucu {
        val view = LayoutInflater.from(mContext).inflate(R.layout.film_card_tasarim,parent,false)
        return  FilmTasarimTutucu(view)
    }

    override fun getItemCount(): Int {
        return FilmList.size
    }

    override fun onBindViewHolder(holder: FilmTasarimTutucu, position: Int) {
        val film = FilmList.get(position)

        holder.textViewFilmAd.text = film.film_ad

        holder.imageViewResim.setImageResource(mContext.resources.getIdentifier(film.film_resim
            ,"drawable",mContext.packageName))

        holder.card_film.setOnClickListener {
            val intent = Intent(mContext,DetayActivity::class.java)
            intent.putExtra("filmNesne",film)
            mContext.startActivity(intent)
        }

    }

}