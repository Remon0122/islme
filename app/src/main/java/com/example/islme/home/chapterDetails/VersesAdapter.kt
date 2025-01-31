package com.example.islme.home.chapterDetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islme.databinding.ItemVerseBinding

class VersesAdapter(val verses : List<String>): RecyclerView.Adapter<VersesAdapter.ViewHolder>(){

    class ViewHolder(val ViewBinding : ItemVerseBinding)
        : RecyclerView.ViewHolder(ViewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val ViewBinding = ItemVerseBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(ViewBinding)
    }

    override fun getItemCount(): Int {
        return verses.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.ViewBinding.content.text = verses[position]
    }
}