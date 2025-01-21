package com.example.islme.home.quran

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islme.AppConstant
import com.example.islme.databinding.QuranFragmentBinding

class QuranFragment : Fragment() {
    lateinit var viewBinding : QuranFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = QuranFragmentBinding.inflate(
            inflater,
            container,
            false
        )
        return viewBinding.root
    }
    lateinit var adapter: ChaptersAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ChaptersAdapter(Chapters)
        viewBinding.chapterRecycler.adapter = adapter
    }
    val Chapters = AppConstant.getChapters()
}