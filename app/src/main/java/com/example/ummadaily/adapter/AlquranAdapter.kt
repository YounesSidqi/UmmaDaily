package com.example.ummadaily.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ummadaily.databinding.RowItemDzikirDoaBinding
import com.example.ummadaily.model.AlquranModel
import com.example.ummadaily.model.DzikirDoaModel

class AlquranAdapter(private val listAlquran: ArrayList<AlquranModel>) :
    RecyclerView.Adapter<AlquranAdapter.MyViewHolder>()
{

    class MyViewHolder(val binding: RowItemDzikirDoaBinding) :
        RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val bindingAlquran = RowItemDzikirDoaBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return MyViewHolder(bindingAlquran)
    }

    override fun getItemCount(): Int = listAlquran.size

    override fun onBindViewHolder(holder: AlquranAdapter.MyViewHolder, position: Int) {
        val DataAlquran = listAlquran[position]

        holder.binding.apply {
            tvDesc.text = DataAlquran.Surah
        }
    }

}