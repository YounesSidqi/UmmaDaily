package com.example.ummadaily.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ummadaily.databinding.RowItemDzikirDoaBinding
import com.example.ummadaily.model.AlquranModel
import com.example.ummadaily.model.DzikirDoaModel

class DzikirDoaAdapter(private val listDzikirDoa: ArrayList<DzikirDoaModel>) :
    RecyclerView.Adapter<DzikirDoaAdapter.MyViewHolder>()
{

    class MyViewHolder(val binding: RowItemDzikirDoaBinding) :
        RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val bindingDzikirDoa = RowItemDzikirDoaBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return MyViewHolder(bindingDzikirDoa)
    }

    override fun getItemCount(): Int = listDzikirDoa.size

    override fun onBindViewHolder(holder: DzikirDoaAdapter.MyViewHolder, position: Int) {
        val DataDzikirDoa = listDzikirDoa[position]

        holder.binding.apply {
            tvDesc.text = DataDzikirDoa.desc
            tvLafaz.text = DataDzikirDoa.lafaz
            tvTerjemah.text = DataDzikirDoa.terjemah
        }
    }

}