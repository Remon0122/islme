package com.example.islme.home.radio

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islme.databinding.ItemRadioBinding
import com.example.islme.home.model.radio

class radioAdapter(val Channels :List<radio> ): RecyclerView.Adapter<radioAdapter.radioViewHolder>(){

    class radioViewHolder (val binding : ItemRadioBinding):
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): radioViewHolder {
        val binding = ItemRadioBinding.
        inflate(LayoutInflater.from(parent.context),parent,false)
        return radioViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return Channels.size
    }

    override fun onBindViewHolder(holder: radioViewHolder, position: Int) {
        val channel = Channels[position]

    }


}