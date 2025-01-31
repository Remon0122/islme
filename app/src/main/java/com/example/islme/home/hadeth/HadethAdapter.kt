package com.example.islme.home.hadeth

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islme.databinding.ItemHadethBinding
import com.example.islme.home.model.Hadeth

class HadethAdapter(val hadethList : List<Hadeth>): RecyclerView.Adapter<HadethAdapter.ViewHolder>(){

    class ViewHolder(val ViewBinding : ItemHadethBinding):
        RecyclerView.ViewHolder(ViewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding =  ItemHadethBinding
            .inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return hadethList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hadeth = hadethList[position]
        holder.ViewBinding.title.text = hadeth.title
        holder.ViewBinding.hadethText.text = hadeth.contant
    }
}