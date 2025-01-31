package com.example.islme.home.chapterDetails

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.example.islme.AppConstant
import com.example.islme.databinding.ActivityChaptersDetailsBinding
import com.example.islme.home.model.Chapter

class ChaptersDetailsActivity : AppCompatActivity() {
    lateinit var viewBinding : ActivityChaptersDetailsBinding
    var chapter: Chapter ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityChaptersDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        init()
        initRecyclerView()
    }
    lateinit var adapter: VersesAdapter
    private fun initRecyclerView() {
        adapter  = VersesAdapter(verseList)
        viewBinding.contant.versesRecycler.adapter = adapter
    }

    fun init(){
        setSupportActionBar(viewBinding.toolbar.toolbar)
        supportActionBar?.setDisplayUseLogoEnabled(true)
        supportActionBar?.setDisplayUseLogoEnabled(true)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            chapter = intent.getParcelableExtra(
                AppConstant.EXTRA.EXTRA_CHAPTER,
                Chapter::class.java
            )
        }else{
            chapter = intent.getParcelableExtra(
                AppConstant.EXTRA.EXTRA_CHAPTER
            )
        }
        viewBinding.toolbar.toolbarTitle.text = chapter?.titleEn
        viewBinding.contant.chapterTitle.text = chapter?.titleAr
        readChapterDetailsFile(chapter!!.index)
    }
    lateinit var verseList : List<String>
    fun readChapterDetailsFile(chapterIndex:Int){
        val content = assets.open("quran/${chapterIndex+1}.txt")?.bufferedReader().use {
            it?.readText() }
        if (content != null) {
            verseList = content.split("\n")
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}