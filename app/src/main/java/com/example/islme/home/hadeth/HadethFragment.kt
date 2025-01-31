package com.example.islme.home.hadeth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.islme.databinding.HadethFragmentBinding
import com.example.islme.home.model.Hadeth
import com.google.android.material.carousel.CarouselLayoutManager
import com.google.android.material.carousel.CarouselSnapHelper
import com.google.android.material.carousel.FullScreenCarouselStrategy
import com.google.android.material.carousel.HeroCarouselStrategy

class HadethFragment : Fragment() {
    lateinit var viewBinding : HadethFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = HadethFragmentBinding.inflate(
            inflater,
            container,
            false
        )
        return viewBinding.root
    }
    val hadethList:MutableList<Hadeth> = mutableListOf()
    lateinit var adapter: HadethAdapter
    lateinit var  layoutManager : CarouselLayoutManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        readAhadethFile()
        initHadethRecycler()
    }

    private fun initHadethRecycler() {
        adapter = HadethAdapter(hadethList)
        layoutManager = CarouselLayoutManager(
            FullScreenCarouselStrategy(),
            LinearLayoutManager.HORIZONTAL,
        )
        layoutManager.carouselAlignment = CarouselLayoutManager.ALIGNMENT_CENTER
        viewBinding.hadethRecyclerView.adapter = adapter
        viewBinding.hadethRecyclerView.layoutManager = layoutManager

        val snapHelper = CarouselSnapHelper()
        snapHelper.attachToRecyclerView(viewBinding.hadethRecyclerView)
    }
    lateinit var hadethLineList : MutableList<String>
    fun readAhadethFile(){
        val fileContent = activity?.assets?.open("hadeth/ahadeth.txt")?.bufferedReader().use {
            it?.readText() }
        if (fileContent == null)return

        val hadethLineList = fileContent.trim()
            .split("#")
        hadethLineList.forEach{singlehadeth->
            val lines = singlehadeth.trim()
                .split("\n")
            val title = lines[0]
            val content = lines.takeLast(lines.size-1).joinToString("\n")
            val hadeth = Hadeth(title,content)
            hadethList.add(hadeth)
        }
    }
}
