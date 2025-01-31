package com.example.islme.home.quran

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islme.databinding.ItemChapterBinding
import com.example.islme.home.model.Chapter


class ChaptersAdapter(val chapters:List<Chapter>):RecyclerView.Adapter<ChaptersAdapter.ViewHolder>(){


    class ViewHolder(val itemBinding : ItemChapterBinding)
        : RecyclerView.ViewHolder(itemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = ItemChapterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return chapters.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val Chapter = chapters[position]

        holder.itemBinding.EnglishQuranSuras.text = Chapter.titleEn
        holder.itemBinding.ArabicQuranSuras.text = Chapter.titleAr
        holder.itemBinding.numberOfVerses.text = Chapter.VersesNumber
        holder.itemBinding.ChapterIndexTv.text = "${Chapter.index+1}"
        onItemClick?.let { onClick ->
            holder.itemView.setOnClickListener{
                onClick.OnItemClick(position,Chapter)
            }
        }
    }
    var onItemClick :  OnItemClick ?=null
    fun interface OnItemClick{
        fun OnItemClick(position:Int,chapter: Chapter)
    }
}