package com.example.ummadaily.adapter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ummadaily.R
import com.example.ummadaily.databinding.FragmentArtikelBinding
import com.example.ummadaily.model.ArtikelModel
import com.example.ummadaily.ui.detail.DetailArtikelActivity

class ArtikelAdapter (private val  ListArtikel: ArrayList<ArtikelModel>) :
    RecyclerView.Adapter<ArtikelAdapter.MyViewHolder>(){
    class MyViewHolder(val binding: FragmentArtikelBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = FragmentArtikelBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int = ListArtikel.size


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = ListArtikel[position]

        Glide.with(holder.itemView.context)
            .load(data.imageArikel)
            .into(holder.binding.imgArtikel)

        holder.binding.imgArtikel.setOnClickListener{
            val intentDetail = Intent(holder.itemView.context, DetailArtikelActivity::class.java)
            intentDetail.putExtra(DetailArtikelActivity.DETAIL_DESC, data.descArtikel)
            intentDetail.putExtra(DetailArtikelActivity.DETAIL_TITLE, data.titleArtikel)
            intentDetail.putExtra(DetailArtikelActivity.DETAIL_IMAGE, data.imageArikel)
            holder.itemView.context.startActivity(intentDetail)
        }
    }
}